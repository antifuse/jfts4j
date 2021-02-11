package eu.antifuse.jftsjava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {

    private final Map<String, String> flaciToTMS = Map.of("R", ">", "L", "<", "N", "-");
    private final Map<String, String> tmsToFlaci = Map.of(">", "R", "<", "L", "-", "N");

    public String flaciToTMS(File input) throws IOException {
        Gson gson = new Gson();
        FLACI flaci = gson.fromJson(Files.readString(Path.of(input.getAbsolutePath())), FLACI.class);
        String emptySlot = flaci.automaton.StackAlphabet[0];
        if (!flaci.type.equals("TM")) return "Dieser Automat kann nicht umgewandelt werden!";
        StringJoiner output = new StringJoiner("\n");
        output.add("name: " + flaci.name);
        FLACI.Automaton.State init = null;
        ArrayList<String> finals = new ArrayList<>();
        HashMap<Integer, String> stateIds = new HashMap<>();
        for (FLACI.Automaton.State s : flaci.automaton.States) {
            if (s.Start) init = s;
            if (s.Final) finals.add(s.Name);
            stateIds.put(s.ID, s.Name);
        }
        if (init == null) return null;
        output.add("init: " + init.Name);
        output.add("accept: " + String.join(",", finals) + "\n");
        for (FLACI.Automaton.State s : flaci.automaton.States)
            for (FLACI.Automaton.State.Transition t : s.Transitions)
                for (String[] l : t.Labels)
                    output.add(stateIds.get(t.Source) + "," + (l[0].equals(emptySlot) ? "_" : l[0]))
                            .add(stateIds.get(t.Target) + "," + (l[1].equals(emptySlot) ? "_" : l[1]) + "," + flaciToTMS.get(l[2]) + "\n");
        return output.toString();
    }

    public String jflapToTMS(File input) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Structure.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Structure jff = (Structure) unmarshaller.unmarshal(input);

        if (!jff.type.equals("turing")) return null;
        StringJoiner output = new StringJoiner("\n");
        output.add("name: " + input.getName());
        String initial = "";
        ArrayList<String> finals = new ArrayList<>();
        Statelike[] states = new Statelike[0];
        HashMap<Short, String> stateIds = new HashMap<>();

        if (jff.getAutomaton().getBlock().size() != 0)
            states = jff.getAutomaton().getBlock().toArray(new Structure.Automaton.Block[0]);
        else if (jff.getAutomaton().getState().size() != 0)
            states = jff.getAutomaton().getState().toArray(new Structure.Automaton.State[0]);
        Structure.Automaton.Transition[] transitions = jff.getAutomaton().getTransition().toArray(new Structure.Automaton.Transition[0]);
        for (Statelike s : states) {
            if (s.getInitial() != null) {
                initial = s.getName();
            }
            if (s.getFinal() != null) {
                finals.add(s.getName());
            }
            stateIds.put(s.getId(), s.getName());
        }
        output.add("init: " + initial);
        output.add("accept: " + String.join(",", finals) + "\n");
        for (Structure.Automaton.Transition t : transitions) {
            String from = stateIds.get(t.getFrom());
            String to = stateIds.get(t.getTo());
            output.add(from + "," + (t.getRead().equals("") ? "_" : t.getRead()));
            output.add(to + "," + (t.getWrite().equals("") ? "_" : t.getWrite()) + "," + (t.getMove().replace("R", ">").replace("L", "<").replace("S", "-")) + "\n");
        }
        return output.toString();
    }

    public void tmsToFlaci(String input, File output) throws IOException {
        input = input.replace(" ", "");
        String pattern = "name:(\\S+)\\n*init:(\\S+)\\n*accept:(\\S+)\\n*([\\S\\n]*)\\z";
        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(input);
        if (!m.find()) return;
        String init = m.group(2);
        Set<String> accept = new HashSet<>(Arrays.asList(m.group(3).split(",")));
        String rules = m.group(4);
        FLACI flaci = new FLACI();
        flaci.name = m.group(1);
        flaci.description = "Erstellt von antifuse/jfts4j";
        flaci.type = "TM";
        flaci.automaton = new FLACI.Automaton();
        int id = 1;
        HashMap<String, FLACI.Automaton.State> states = new HashMap<>();
        HashMap<StringPair, FLACI.Automaton.State.Transition> transitions = new HashMap<>();
        HashSet<String> alphabet = new HashSet<>();
        for (String rule : rules.split("\\n\\n")) {
            String[] inout = rule.split("\\n");
            String[] in = inout[0].split(",");
            String[] out = inout[1].split(",");
            if (!states.containsKey(in[0])) {
                FLACI.Automaton.State state = new FLACI.Automaton.State();
                state.Name = in[0];
                state.ID = id++;
                state.Transitions = new FLACI.Automaton.State.Transition[0];
                state.Radius = 30;
                if (in[0].equals(init)) state.Start = true;
                if (accept.contains(in[0])) state.Final = true;
                states.put(in[0], state);
            }
            if (!states.containsKey(out[0])) {
                FLACI.Automaton.State state = new FLACI.Automaton.State();
                state.Name = out[0];
                state.ID = id++;
                state.Transitions = new FLACI.Automaton.State.Transition[0];
                state.Radius = 30;
                if (out[0].equals(init)) state.Start = true;
                if (accept.contains(out[0])) state.Final = true;
                states.put(out[0], state);
            }
            alphabet.add(in[1]);
            alphabet.add(out[1]);
            StringPair key = new StringPair(in[0], out[0]);
            if (!transitions.containsKey(key)) {
                FLACI.Automaton.State.Transition t = new FLACI.Automaton.State.Transition();
                t.Labels = new String[0][0];
                t.Source = states.get(in[0]).ID;
                t.Target = states.get(out[0]).ID;
                transitions.put(key, t);
            }
            List<String[]> labels = new ArrayList<>(Arrays.asList(transitions.get(key).Labels));
            labels.add(new String[]{in[1], out[1], tmsToFlaci.get(out[2])});
            transitions.get(key).Labels = labels.toArray(String[][]::new);
        }
        transitions.forEach((stringPair, transition) -> {
            List<FLACI.Automaton.State.Transition> ts = new ArrayList<>(Arrays.asList(states.get(stringPair.a).Transitions));
            ts.add(transition);
            states.get(stringPair.a).Transitions = ts.toArray(FLACI.Automaton.State.Transition[]::new);
        });
        alphabet.remove("_");
        flaci.automaton.Alphabet = alphabet.stream().sorted(String::compareTo).toArray(String[]::new);
        flaci.automaton.StackAlphabet = new String[flaci.automaton.Alphabet.length + 1];
        System.arraycopy(flaci.automaton.Alphabet, 0, flaci.automaton.StackAlphabet, 1, flaci.automaton.Alphabet.length);
        flaci.automaton.StackAlphabet[0] = "_";
        flaci.automaton.States = states.values().toArray(new FLACI.Automaton.State[0]);
        FileWriter fileWriter = new FileWriter(output);
        new GsonBuilder().setPrettyPrinting().create().toJson(flaci, fileWriter);
        fileWriter.close();
    }

    private static class StringPair {
        final String a, b;

        public StringPair(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StringPair that = (StringPair) o;
            return Objects.equals(a, that.a) && Objects.equals(b, that.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public void tmsToJflap(String input, File output) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Structure.class);
        Marshaller marshaller = jc.createMarshaller();
        input = input.replace(" ", "");
        String init;
        HashMap<String, Structure.Automaton.State> states = new HashMap<>();
        ArrayList<Structure.Automaton.Transition> transitions = new ArrayList<>();
        short newID = 1;
        String pattern = "name:(\\S+)\\n*init:(\\S+)\\n*accept:(\\S+)\\n*([\\S\\n]*)\\z";
        Pattern regex = Pattern.compile(pattern);
        Matcher m = regex.matcher(input);
        if (!m.find()) return;
        ObjectFactory of = new ObjectFactory();
        init = m.group(2);
        ArrayList<String> accept = new ArrayList<>(Arrays.asList(m.group(3).split(",")));
        String rules = m.group(4);
        for (String rule : rules.split("\\n\\n")) {
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
                states.put(in[0], from);
            }
            if (!states.containsKey(out[0])) {
                Structure.Automaton.State to = of.createStructureAutomatonState();
                to.setId(newID);
                newID++;
                to.setName(out[0]);
                if (out[0].equals(init)) to.setInitial("");
                if (accept.contains(out[0])) to.setFinal("");
                states.put(out[0], to);
            }
            Structure.Automaton.Transition goals = of.createStructureAutomatonTransition();
            goals.setFrom(states.get(in[0]).getId());
            goals.setTo(states.get(out[0]).getId());
            goals.setRead(in[1].replace("_", ""));
            goals.setWrite(out[1].replace("_", ""));
            goals.setMove(out[2].replace("<", "L").replace(">", "R").replace("-", "S"));
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
