package gregl.energydataapi.service;

import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.repository.EnergyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyDataService {

    @Autowired
    private EnergyDataRepository energyDataRepository;

    public List<EnergyData> getAllEnergyData() {
        return energyDataRepository.findAll();
    }

    // TODO
}