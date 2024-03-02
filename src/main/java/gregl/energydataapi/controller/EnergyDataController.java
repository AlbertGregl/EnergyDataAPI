package gregl.energydataapi.controller;

import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.service.EnergyDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class EnergyDataController {
    private final EnergyDataService energyDataService;

    public EnergyDataController(EnergyDataService energyDataService) {
        this.energyDataService = energyDataService;
    }

    @GetMapping("/public")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getPublic() {
        return "This is public API -> No Auth Required";
    }

    @GetMapping("/private")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String getPrivate() {
        return "This is private API -> Auth Required";
    }

    @GetMapping("/index")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<EnergyData> getAllEnergyData() {
        return energyDataService.getAllEnergyData();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public EnergyData getEnergyDataById(@PathVariable Long id) {
        return energyDataService.getEnergyDataById(id);
    }

    @PostMapping("/save")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public EnergyData saveEnergyData(@RequestBody EnergyData energyData) {
        energyDataService.saveEnergyData(energyData);
        return energyData;
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public EnergyData updateEnergyData(@PathVariable Long id, @RequestBody EnergyData energyData) {
        EnergyData existing = energyDataService.getEnergyDataById(id);
        existing.setDtm(energyData.getDtm());
        existing.setMIP(energyData.getMIP());
        existing.setSolar_MW(energyData.getSolar_MW());
        existing.setSolar_capacity_mwp(energyData.getSolar_capacity_mwp());
        existing.setSolar_installedcapacity_mwp(energyData.getSolar_installedcapacity_mwp());
        existing.setWind_MW(energyData.getWind_MW());
        existing.setSS_Price(energyData.getSS_Price());
        existing.setBoa_MWh(energyData.getBoa_MWh());
        existing.setDA_Price(energyData.getDA_Price());
        energyDataService.saveEnergyData(existing);
        return existing;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Void deleteEnergyData(@PathVariable Long id) {
        energyDataService.deleteEnergyData(id);
        return null;
    }

}
