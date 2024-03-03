package gregl.energydataapi.fileutil;


import gregl.energydataapi.model.EnergyData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvUtil {

    public static List<EnergyData> parseEnergyData(String filePath) throws IOException {
        List<EnergyData> dataList = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found at " + filePath);
        }

        try (Reader in = new FileReader(file)) {
            CSVFormat format = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build();
            Iterable<CSVRecord> records = format.parse(in);

            for (CSVRecord record : records) {
                EnergyData data = new EnergyData();

                ZonedDateTime zdt = ZonedDateTime.parse(record.get("dtm"), DateTimeFormatter.ISO_DATE_TIME);
                Date date = Date.from(zdt.toInstant());
                data.setDtm(date);

                data.setMIP(record.get("MIP").isEmpty() ? null : new BigDecimal(record.get("MIP")));
                data.setSolar_MW(record.get("Solar_MW").isEmpty() ? null : new BigDecimal(record.get("Solar_MW")));
                data.setSolar_capacity_mwp(record.get("Solar_capacity_mwp").isEmpty() ? null : new BigDecimal(record.get("Solar_capacity_mwp")));
                data.setSolar_installedcapacity_mwp(record.get("Solar_installedcapacity_mwp").isEmpty() ? null : new BigDecimal(record.get("Solar_installedcapacity_mwp")));
                data.setWind_MW(record.get("Wind_MW").isEmpty() ? null : new BigDecimal(record.get("Wind_MW")));
                data.setSS_Price(record.get("SS_Price").isEmpty() ? null : new BigDecimal(record.get("SS_Price")));
                data.setBoa_MWh(record.get("boa_MWh").isEmpty() ? null : new BigDecimal(record.get("boa_MWh")));
                data.setDA_Price(record.get("DA_Price").isEmpty() ? null : new BigDecimal(record.get("DA_Price")));

                dataList.add(data);
            }
        }
        return dataList;
    }
}
