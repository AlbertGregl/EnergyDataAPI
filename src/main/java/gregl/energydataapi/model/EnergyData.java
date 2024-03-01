package gregl.energydataapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "energy_data")
public class EnergyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO
}
