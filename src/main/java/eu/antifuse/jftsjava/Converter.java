package eu.antifuse.jftsjava;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Converter {
    public String convertFile(File input) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Structure.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Structure jff = (Structure) unmarshaller.unmarshal(input);

        if (!jff.type.equals("turing")) return null;
        StringBuilder output = new StringBuilder();
        output.append("name: " + input.getName() + "\n");
        String initial = "";
        ArrayList<String> finals = new ArrayList<>();
        Statelike[] states = new Statelike[0];
        HashMap<Short, String> stateIds = new HashMap<>();

        if (jff.getAutomaton().getBlock().size() != 0) states = jff.getAutomaton().getBlock().toArray(new Structure.Automaton.Block[0]);
        else if (jff.getAutomaton().getState().size() != 0) states = jff.getAutomaton().getState().toArray(new Structure.Automaton.State[0]);
        Structure.Automaton.Transition[] transitions = jff.getAutomaton().getTransition().toArray(new Structure.Automaton.Transition[0]);
        for (Statelike s: states) {
            if (s.getInitial() != null) {
                initial = s.getName();
            }
            if (s.getFinal() != null) {
                finals.add(s.getName());
            }
            stateIds.put(s.getId(), s.getName());
        }
        output.append("init: " + initial + "\n");
        output.append("accept: " + String.join(",", finals) + "\n\n");
        for (Structure.Automaton.Transition t: transitions) {
            String from = stateIds.get(t.getFrom());
            String to = stateIds.get(t.getTo());
            output.append(from + "," + (t.getRead().equals("") ? "_":t.getRead()) + "\n");
            output.append(to + "," + (t.getWrite().equals("") ? "_":t.getWrite()) + "," + (t.getMove().replace("R",">").replace("L","<").replace("S","-")) + "\n\n");
        }
        return output.toString();
    }
}
