package gregl.energydataapi.controller;

import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.model.EnergyDataList;
import gregl.energydataapi.service.EnergyDataService;
import gregl.energydataapi.model.GetEnergyDataByYearAndMonthRequest;
import gregl.energydataapi.model.GetEnergyDataByYearAndMonthResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Endpoint
public class EnergyDataSoapEndpoint {

    private final EnergyDataService energyDataService;

    public EnergyDataSoapEndpoint(EnergyDataService energyDataService) {
        this.energyDataService = energyDataService;
    }

    @PayloadRoot(namespace = "http://gregl/soap/data.wsdl", localPart = "getEnergyDataByYearAndMonthRequest")
    @ResponsePayload
    public GetEnergyDataByYearAndMonthResponse getEnergyData(@RequestPayload GetEnergyDataByYearAndMonthRequest request) throws JAXBException, IOException, SAXException {

        List<EnergyData> energyDataList = energyDataService.getEnergyDataByYearAndMonth(request.getYear(), request.getMonth());

        GetEnergyDataByYearAndMonthResponse response = new GetEnergyDataByYearAndMonthResponse();

        EnergyDataList wrapper = new EnergyDataList();
        wrapper.setEnergyDataList(energyDataList);

        response.setEnergyDataList(wrapper);
        return response;
    }

}
