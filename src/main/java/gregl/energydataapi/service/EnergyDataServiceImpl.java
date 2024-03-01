package gregl.energydataapi.service;

import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.repository.EnergyDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyDataServiceImpl implements EnergyDataService{

    private final EnergyDataRepository energyDataRepository;

    public EnergyDataServiceImpl(EnergyDataRepository energyDataRepository) {
        this.energyDataRepository = energyDataRepository;
    }


    @Override
    public List<EnergyData> getAllEnergyData() {
        return energyDataRepository.findAll();
    }

    @Override
    public EnergyData getEnergyDataById(Long id) {
        return energyDataRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEnergyData(EnergyData energyData) {
        energyDataRepository.save(energyData);
    }

    @Override
    public void deleteEnergyData(Long id) {
        energyDataRepository.deleteById(id);
    }
}