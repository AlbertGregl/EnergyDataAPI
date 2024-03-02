package gregl.energydataapi.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "energy_tab")
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@XmlRootElement
public class EnergyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dtm", nullable = false)
    private Date dtm;

    @Column(name = "MIP")
    private BigDecimal MIP;

    @Column(name = "Solar_MW")
    private BigDecimal Solar_MW;

    @Column(name = "Solar_capacity_mwp")
    private BigDecimal Solar_capacity_mwp;

    @Column(name = "Solar_installedcapacity_mwp")
    private BigDecimal Solar_installedcapacity_mwp;

    @Column(name = "Wind_MW")
    private BigDecimal Wind_MW;

    @Column(name = "SS_Price")
    private BigDecimal SS_Price;

    @Column(name = "boa_MWh")
    private BigDecimal boa_MWh;

    @Column(name = "DA_Price")
    private BigDecimal DA_Price;


    public EnergyData(Date dtm, BigDecimal MIP, BigDecimal Solar_MW, BigDecimal Solar_capacity_mwp, BigDecimal Solar_installedcapacity_mwp, BigDecimal Wind_MW, BigDecimal SS_Price, BigDecimal boa_MWh, BigDecimal DA_Price) {
        this.dtm = dtm;
        this.MIP = MIP;
        this.Solar_MW = Solar_MW;
        this.Solar_capacity_mwp = Solar_capacity_mwp;
        this.Solar_installedcapacity_mwp = Solar_installedcapacity_mwp;
        this.Wind_MW = Wind_MW;
        this.SS_Price = SS_Price;
        this.boa_MWh = boa_MWh;
        this.DA_Price = DA_Price;
    }

}
