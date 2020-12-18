package eu.antifuse.jftsjava;//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2020.12.18 um 12:50:40 PM CET 
//


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="automaton">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="block" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="final" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                             &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="state" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="final" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                             &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="transition" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="read" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="write" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="move" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "type",
    "automaton"
})
@XmlRootElement(name = "structure")
public class Structure {

    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected Automaton automaton;

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der automaton-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Automaton }
     *     
     */
    public Automaton getAutomaton() {
        return automaton;
    }

    /**
     * Legt den Wert der automaton-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Automaton }
     *     
     */
    public void setAutomaton(Automaton value) {
        this.automaton = value;
    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="block" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="final" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                   &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="state" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="final" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                   &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="transition" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                   &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                   &lt;element name="read" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="write" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="move" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "block",
        "state",
        "transition"
    })
    public static class Automaton {

        protected List<Block> block;
        protected List<State> state;
        @XmlElement(required = true)
        protected List<Transition> transition;

        /**
         * Gets the value of the block property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the block property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBlock().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Block }
         * 
         * 
         */
        public List<Block> getBlock() {
            if (block == null) {
                block = new ArrayList<Block>();
            }
            return this.block;
        }

        /**
         * Gets the value of the state property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the state property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getState().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link State }
         * 
         * 
         */
        public List<State> getState() {
            if (state == null) {
                state = new ArrayList<State>();
            }
            return this.state;
        }

        /**
         * Gets the value of the transition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the transition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTransition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Transition }
         * 
         * 
         */
        public List<Transition> getTransition() {
            if (transition == null) {
                transition = new ArrayList<Transition>();
            }
            return this.transition;
        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="final" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *         &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "tag",
            "x",
            "y",
            "_final",
            "initial"
        })
        public static class Block implements Statelike{

            @XmlElement(required = true)
            protected String tag;
            @XmlElement(required = true)
            protected BigDecimal x;
            @XmlElement(required = true)
            protected BigDecimal y;
            @XmlElement(name = "final")
            protected Object _final;
            protected Object initial;
            @XmlAttribute(name = "id", required = true)
            @XmlSchemaType(name = "unsignedByte")
            protected short id;
            @XmlAttribute(name = "name", required = true)
            protected String name;

            /**
             * Ruft den Wert der tag-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTag() {
                return tag;
            }

            /**
             * Legt den Wert der tag-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTag(String value) {
                this.tag = value;
            }

            /**
             * Ruft den Wert der x-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getX() {
                return x;
            }

            /**
             * Legt den Wert der x-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setX(BigDecimal value) {
                this.x = value;
            }

            /**
             * Ruft den Wert der y-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getY() {
                return y;
            }

            /**
             * Legt den Wert der y-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setY(BigDecimal value) {
                this.y = value;
            }

            /**
             * Ruft den Wert der final-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getFinal() {
                return _final;
            }

            /**
             * Legt den Wert der final-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setFinal(Object value) {
                this._final = value;
            }

            /**
             * Ruft den Wert der initial-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getInitial() {
                return initial;
            }

            /**
             * Legt den Wert der initial-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setInitial(Object value) {
                this.initial = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             */
            public short getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             */
            public void setId(short value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der name-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Legt den Wert der name-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="x" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="y" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="final" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *         &lt;element name="initial" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedByte" />
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "tag",
            "x",
            "y",
            "_final",
            "initial"
        })
        public static class State implements Statelike{

            @XmlElement(required = true)
            protected String tag;
            @XmlElement(required = true)
            protected BigDecimal x;
            @XmlElement(required = true)
            protected BigDecimal y;
            @XmlElement(name = "final")
            protected Object _final;
            protected Object initial;
            @XmlAttribute(name = "id", required = true)
            @XmlSchemaType(name = "unsignedByte")
            protected short id;
            @XmlAttribute(name = "name", required = true)
            protected String name;

            /**
             * Ruft den Wert der tag-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTag() {
                return tag;
            }

            /**
             * Legt den Wert der tag-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTag(String value) {
                this.tag = value;
            }

            /**
             * Ruft den Wert der x-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getX() {
                return x;
            }

            /**
             * Legt den Wert der x-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setX(BigDecimal value) {
                this.x = value;
            }

            /**
             * Ruft den Wert der y-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getY() {
                return y;
            }

            /**
             * Legt den Wert der y-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setY(BigDecimal value) {
                this.y = value;
            }

            /**
             * Ruft den Wert der final-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getFinal() {
                return _final;
            }

            /**
             * Legt den Wert der final-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setFinal(Object value) {
                this._final = value;
            }

            /**
             * Ruft den Wert der initial-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getInitial() {
                return initial;
            }

            /**
             * Legt den Wert der initial-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setInitial(Object value) {
                this.initial = value;
            }

            /**
             * Ruft den Wert der id-Eigenschaft ab.
             * 
             */
            public short getId() {
                return id;
            }

            /**
             * Legt den Wert der id-Eigenschaft fest.
             * 
             */
            public void setId(short value) {
                this.id = value;
            }

            /**
             * Ruft den Wert der name-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Legt den Wert der name-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

        }


        /**
         * <p>Java-Klasse f�r anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *         &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *         &lt;element name="read" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="write" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="move" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "from",
            "to",
            "read",
            "write",
            "move"
        })
        public static class Transition {

            @XmlSchemaType(name = "unsignedByte")
            protected short from;
            @XmlSchemaType(name = "unsignedByte")
            protected short to;
            @XmlElement(required = true)
            protected String read;
            @XmlElement(required = true)
            protected String write;
            @XmlElement(required = true)
            protected String move;

            /**
             * Ruft den Wert der from-Eigenschaft ab.
             * 
             */
            public short getFrom() {
                return from;
            }

            /**
             * Legt den Wert der from-Eigenschaft fest.
             * 
             */
            public void setFrom(short value) {
                this.from = value;
            }

            /**
             * Ruft den Wert der to-Eigenschaft ab.
             * 
             */
            public short getTo() {
                return to;
            }

            /**
             * Legt den Wert der to-Eigenschaft fest.
             * 
             */
            public void setTo(short value) {
                this.to = value;
            }

            /**
             * Ruft den Wert der read-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRead() {
                return read;
            }

            /**
             * Legt den Wert der read-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRead(String value) {
                this.read = value;
            }

            /**
             * Ruft den Wert der write-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWrite() {
                return write;
            }

            /**
             * Legt den Wert der write-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWrite(String value) {
                this.write = value;
            }

            /**
             * Ruft den Wert der move-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMove() {
                return move;
            }

            /**
             * Legt den Wert der move-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMove(String value) {
                this.move = value;
            }

        }

    }

}
