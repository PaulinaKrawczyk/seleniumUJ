package selenium.test.automation.utils.data;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import selenium.test.automation.utils.files.FileHelper;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataReader {
    public Object[][] readVersionData(String fileName) {
        Object[][] data = null;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(new FileHelper().getResourceFilePath(fileName)));
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            data = new Object[(int) csvReader.getLinesRead()][];

            String[] dataRecord;
            String[] nextRecord;
            int i = 0;
            while ((nextRecord = csvReader.readNext()) != null) {
                dataRecord = new String[2];
                dataRecord[0] = nextRecord[0];
                dataRecord[1] = nextRecord[1];
                data[i] = dataRecord;
                i++;
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return data;
    }
}


