package gregl.energydataapi.service;

import gregl.energydataapi.model.EnergyData;

import java.util.List;

public interface EnergyDataService {
    List<EnergyData> getAllEnergyData();
    EnergyData getEnergyDataById(Long id);
    void saveEnergyData(EnergyData energyData);
    void deleteEnergyData(Long id);

    void parseAndSaveEnergyData(String filePath);

    List<EnergyData> getEnergyDataByYearAndMonth(int year, int month);
}
