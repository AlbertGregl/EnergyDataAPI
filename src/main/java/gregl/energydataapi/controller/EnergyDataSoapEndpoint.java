package gregl.energydataapi.controller;

import gregl.energydataapi.jaxbutil.JaxbUtil;
import gregl.energydataapi.jaxbutil.XmlSearchUtil;
import gregl.energydataapi.model.EnergyData;
import gregl.energydataapi.model.EnergyDataList;
import gregl.energydataapi.service.EnergyDataService;
import gregl.energydataapi.model.GetEnergyDataByYearAndMonthRequest;
import gregl.energydataapi.model.GetEnergyDataByYearAndMonthResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class EnergyDataSoapEndpoint {

    private static final String SCHEMA_PATH = "xsdvalidation/energyDataList.xsd";
    private static final String FILE_PATH = "src/main/resources/static/energyDataResponse.xml";

    private final EnergyDataService energyDataService;

    public EnergyDataSoapEndpoint(EnergyDataService energyDataService) {
        this.energyDataService = energyDataService;
    }

    @PayloadRoot(namespace = "http://gregl/soap/data.wsdl", localPart = "getEnergyDataByYearAndMonthRequest")
    @ResponsePayload
    public GetEnergyDataByYearAndMonthResponse getEnergyData(@RequestPayload GetEnergyDataByYearAndMonthRequest request) throws Exception {

        List<EnergyData> energyDataList = energyDataService.getEnergyDataByYearAndMonth(request.getYear(), request.getMonth());

        GetEnergyDataByYearAndMonthResponse response = new GetEnergyDataByYearAndMonthResponse();

        EnergyDataList wrapper = new EnergyDataList();
        wrapper.setEnergyDataList(energyDataList);

        response.setEnergyDataList(wrapper);

        // Task 3: marshalling the data to XML file
        JaxbUtil.marshalToFile(response, FILE_PATH);
        // searching the data using XPath expression and adjusting the date format
        XmlSearchUtil.findEnergyDataAndAdjustDate(FILE_PATH);

        // Task 4: validating the XML file against the XSD
        JaxbUtil.validateFile(FILE_PATH, SCHEMA_PATH);

        // returning the adjusted data
        return JaxbUtil.unmarshalFromFile(FILE_PATH, GetEnergyDataByYearAndMonthResponse.class);

    }

}
