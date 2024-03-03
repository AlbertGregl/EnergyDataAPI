package gregl.energydataapi.repository;

import gregl.energydataapi.model.EnergyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnergyDataRepository extends JpaRepository<EnergyData, Long> {

    @Query("SELECT e FROM EnergyData e WHERE FUNCTION('YEAR', e.dtm) = :year AND FUNCTION('MONTH', e.dtm) = :month")
    List<EnergyData> findByYearAndMonth(@Param("year") int year, @Param("month") int month);
}