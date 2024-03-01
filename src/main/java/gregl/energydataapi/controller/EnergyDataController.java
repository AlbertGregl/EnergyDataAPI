package gregl.energydataapi.controller;

import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.service.EnergyDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/energydata")
public class EnergyDataController {
    private final EnergyDataService energyDataService;

    public EnergyDataController(EnergyDataService energyDataService) {
        this.energyDataService = energyDataService;
    }

    @GetMapping("allData")
    public ResponseEntity<List<EnergyData>> getAllEnergyData() {
        List<EnergyData> data = energyDataService.getAllEnergyData();
        return ResponseEntity.ok(data);
    }
}
