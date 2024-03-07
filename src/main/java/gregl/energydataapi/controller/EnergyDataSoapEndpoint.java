package gregl.energydataapi.controller;

import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.service.EnergyDataService;
import gregl.energydataapi.soap.GetEnergyDataByYearAndMonthRequest;
import gregl.energydataapi.soap.GetEnergyDataByYearAndMonthResponse;
import gregl.energydataapi.model.EnergyDataList;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class EnergyDataSoapEndpoint {

    private final EnergyDataService energyDataService;

    public EnergyDataSoapEndpoint(EnergyDataService energyDataService) {
        this.energyDataService = energyDataService;
    }

    @PayloadRoot(namespace = "http://gregl/soap/data.wsdl", localPart = "getEnergyDataByYearAndMonthRequest")
    @ResponsePayload
    public GetEnergyDataByYearAndMonthResponse getEnergyData(@RequestPayload GetEnergyDataByYearAndMonthRequest request) {
        GetEnergyDataByYearAndMonthResponse response = new GetEnergyDataByYearAndMonthResponse();
        List<EnergyData> energyDataList = energyDataService.getEnergyDataByYearAndMonth(request.getYear(), request.getMonth());

        EnergyDataList energyDataListWrapper = new EnergyDataList();
        energyDataListWrapper.setEnergyDataList(energyDataList);

        response.setEnergyDataList(energyDataListWrapper);
        return response;
    }

}
