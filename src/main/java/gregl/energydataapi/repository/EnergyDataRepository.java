package gregl.energydataapi.repository;

import gregl.energydataapi.model.EnergyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnergyDataRepository extends JpaRepository<EnergyData, Long> {

}