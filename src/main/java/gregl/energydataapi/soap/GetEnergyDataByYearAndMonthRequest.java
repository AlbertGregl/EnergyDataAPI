package gregl.energydataapi.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlType(name = "GetEnergyDataByYearAndMonthRequest",
        propOrder = {
                "year",
                "month"})
public class GetEnergyDataByYearAndMonthRequest {
    @XmlElement(required = true)
    protected int year;

    @XmlElement(required = true)
    protected int month;
}
