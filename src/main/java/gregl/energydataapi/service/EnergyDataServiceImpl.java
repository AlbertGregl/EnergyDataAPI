package gregl.energydataapi.service;

import jakarta.transaction.Transactional;

import gregl.energydataapi.fileutil.CsvUtil;
import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.repository.EnergyDataRepository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class EnergyDataServiceImpl implements EnergyDataService {

    // database connection and batch size configuration
    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;
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

    @Override
    @Transactional
    public void parseAndSaveEnergyData(String filePath) {
        try {
            List<EnergyData> dataList = CsvUtil.parseEnergyData(filePath);

            for (int i = 0; i < dataList.size(); i += batchSize) {
                List<EnergyData> batchList = dataList.subList(i, Math.min(dataList.size(), i + batchSize));
                energyDataRepository.saveAll(batchList);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EnergyData> getEnergyDataByYearAndMonth(int year, int month) {
        return energyDataRepository.findByYearAndMonth(year, month);
    }

}