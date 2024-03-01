package gregl.energydataapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "energy_tab")
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EnergyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dtm", nullable = false)
    private LocalDateTime dtm;

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


}
