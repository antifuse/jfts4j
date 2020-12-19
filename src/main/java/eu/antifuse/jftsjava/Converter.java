package eu.antifuse.jftsjava;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void convertScript(String input, File output) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Structure.class);
        Marshaller marshaller = jc.createMarshaller();
        input = input.replace(" ", "");
        String init;
        ArrayList<String> accept = new ArrayList<>();
        HashMap<String,Structure.Automaton.State> states = new HashMap<>();
        ArrayList<Structure.Automaton.Transition> transitions = new ArrayList<>();
        short newID = 1;
        String pattern = "name:(\\S+)\\n*init:(\\S+)\\n*accept:(\\S+)\\n*([\\S\\n]*)\\z";
        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(input);
        if (!m.find()) return;
        ObjectFactory of = new ObjectFactory();
        init = m.group(2);
        accept.addAll(Arrays.asList(m.group(3).split(",")));
        String rules = m.group(4);
        for (String rule: rules.split("\\n\\n")) {
            String[] inout = rule.split("\\n");
            String[] in = inout[0].split(",");
            String[] out = inout[1].split(",");
            if (!states.containsKey(in[0])) {
                Structure.Automaton.State from = of.createStructureAutomatonState();
                from.setId(newID);
                newID++;
                from.setName(in[0]);
                if (in[0].equals(init)) from.setInitial("");
                if (accept.contains(in[0])) from.setFinal("");
                states.put(in[0],from);
            }
            if (!states.containsKey(out[0])) {
                Structure.Automaton.State to = of.createStructureAutomatonState();
                to.setId(newID);
                newID++;
                to.setName(out[0]);
                if (out[0].equals(init)) to.setInitial("");
                if (accept.contains(out[0])) to.setFinal("");
                states.put(out[0],to);
            }
            Structure.Automaton.Transition goals = of.createStructureAutomatonTransition();
            goals.setFrom(states.get(in[0]).getId());
            goals.setTo(states.get(out[0]).getId());
            goals.setRead(in[1].replace("_",""));
            goals.setWrite(out[1].replace("_",""));
            goals.setMove(out[2].replace("<","L").replace(">","R").replace("-","S"));
            transitions.add(goals);
        }
        Structure.Automaton automaton = of.createStructureAutomaton();
        automaton.getState().addAll(states.values());
        automaton.getTransition().addAll(transitions);
        Structure s = of.createStructure();
        s.setAutomaton(automaton);
        s.setType("turing");
        marshaller.marshal(s, output);
    }
}
