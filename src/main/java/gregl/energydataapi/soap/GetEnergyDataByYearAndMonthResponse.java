package gregl.energydataapi.soap;

import gregl.energydataapi.xmlutil.EnergyDataListWrapper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlType(name = "GetEnergyDataByYearAndMonthResponse",
        propOrder = {
                "energyDataList"
        })
public class GetEnergyDataByYearAndMonthResponse {
    @XmlElement(required = true)
    protected EnergyDataListWrapper energyDataList;
}
