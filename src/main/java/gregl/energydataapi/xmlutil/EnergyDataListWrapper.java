package gregl.energydataapi.xmlutil;

import gregl.energydataapi.model.EnergyData;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "energyDataList")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class EnergyDataListWrapper {
    @XmlElement(name = "energyData")
    private List<EnergyData> energyDataList;
}
