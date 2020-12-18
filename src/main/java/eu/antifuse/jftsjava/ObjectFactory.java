package eu.antifuse.jftsjava;//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.12.18 um 12:50:40 PM CET 
//


import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Structure }
     * 
     */
    public Structure createStructure() {
        return new Structure();
    }

    /**
     * Create an instance of {@link Structure.Automaton }
     * 
     */
    public Structure.Automaton createStructureAutomaton() {
        return new Structure.Automaton();
    }

    /**
     * Create an instance of {@link Structure.Automaton.Block }
     * 
     */
    public Structure.Automaton.Block createStructureAutomatonBlock() {
        return new Structure.Automaton.Block();
    }

    /**
     * Create an instance of {@link Structure.Automaton.State }
     * 
     */
    public Structure.Automaton.State createStructureAutomatonState() {
        return new Structure.Automaton.State();
    }

    /**
     * Create an instance of {@link Structure.Automaton.Transition }
     * 
     */
    public Structure.Automaton.Transition createStructureAutomatonTransition() {
        return new Structure.Automaton.Transition();
    }

}
