package gregl.energydataapi.controller;

import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.service.EnergyDataService;
import gregl.energydataapi.soap.GetEnergyDataByYearAndMonthRequest;
import gregl.energydataapi.soap.GetEnergyDataByYearAndMonthResponse;
import gregl.energydataapi.model.EnergyDataList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class EnergyDataSoapEndpoint {

    @Value("${okta.oauth2.issuer}")
    private String NAMESPACE_URI;

    private final EnergyDataService energyDataService;

    public EnergyDataSoapEndpoint(EnergyDataService energyDataService) {
        this.energyDataService = energyDataService;
    }

    @PayloadRoot(namespace = "NAMESPACE_URI", localPart = "getEnergyDataByYearAndMonthRequest")
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
