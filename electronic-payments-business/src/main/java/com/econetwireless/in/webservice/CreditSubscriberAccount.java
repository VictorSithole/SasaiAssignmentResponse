//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.08.15 at 12:46:25 PM CAT 
//


package com.econetwireless.in.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creditSubscriberAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creditSubscriberAccount"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="creditRequest" type="{http://service.soap.in.econetwireless.com/}creditRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditSubscriberAccount", propOrder = {
    "creditRequest"
})
public class CreditSubscriberAccount {

    protected CreditRequest creditRequest;

    /**
     * Gets the value of the creditRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CreditRequest }
     *     
     */
    public CreditRequest getCreditRequest() {
        return creditRequest;
    }

    /**
     * Sets the value of the creditRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditRequest }
     *     
     */
    public void setCreditRequest(CreditRequest value) {
        this.creditRequest = value;
    }

}
