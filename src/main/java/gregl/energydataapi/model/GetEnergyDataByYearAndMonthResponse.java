//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.07 at 03:40:00 PM CET 
//


package gregl.energydataapi.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="energyDataList" type="{http://gregl/soap/data.wsdl}EnergyDataList"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "energyDataList"
})
@XmlRootElement(name = "getEnergyDataByYearAndMonthResponse")
public class GetEnergyDataByYearAndMonthResponse {

    @XmlElement(required = true)
    protected EnergyDataList energyDataList;

    /**
     * Gets the value of the energyDataList property.
     * 
     * @return
     *     possible object is
     *     {@link EnergyDataList }
     *     
     */
    public EnergyDataList getEnergyDataList() {
        return energyDataList;
    }

    /**
     * Sets the value of the energyDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnergyDataList }
     *     
     */
    public void setEnergyDataList(EnergyDataList value) {
        this.energyDataList = value;
    }

}