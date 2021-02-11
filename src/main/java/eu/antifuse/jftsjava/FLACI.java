package eu.antifuse.jftsjava;

@SuppressWarnings("unused")
public class FLACI {

    String name;
    String description;
    String type;
    FLACI.Automaton automaton;
    String[] lastInputs;

    public FLACI() {
    }

    public static class Automaton {
        String[] simulationInput;
        String[] Alphabet;
        String[] StackAlphabet;
        FLACI.Automaton.State[] States;

        public Automaton() {
        }

        public static class State {
            int ID;
            String Name;
            int x;
            int y;
            boolean Final;
            int Radius;
            boolean Start;
            FLACI.Automaton.State.Transition[] Transitions;

            public State() {
            }

            public static class Transition {
                int Source;
                int Target;
                int x;
                int y;
                String[][] Labels;

                public Transition() {
                }
            }
        }
    }

}
