# jfts4j

## What it does
jfts4j is a JFLAP to Turing Machine Simulator converter. It supports the conversion of JFLAP XML to Simulator scripts (saved as plain text and displayed on screen) and vice-versa.
The GUI was designed with JavaFX, XML parsing and building is handled with JAXB.

## What not to do
**Do not** try to convert non-Turing (or multi-tape) JFLAP automata. Keep Turing Machine Simulator scripts in their standard format, leaving out comments and sticking to the order name-init-accept.
If the program does nothing and you are absolutely sure it should not, message me on here (slow) or on [Twitter](https://twitter.com/antifuse) (fast). 
