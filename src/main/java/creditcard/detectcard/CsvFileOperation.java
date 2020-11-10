package creditcard.detectcard;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import creditcard.model.CardDto;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CsvFileOperation implements IoOperation
{
    public List<CardDto> readFile(String fileName){
        File file = new File(fileName);
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            // create csv bean reader
            CsvToBean<CardDto> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CardDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build();

            // convert `CsvToBean` object to list of cards
            List<CardDto> cards = csvToBean.parse();
            return cards;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    public void writeFile(String filePath, List<String> response) throws Exception{

        String path = filePath.substring(0, filePath.lastIndexOf("."));
        String extension = filePath.substring(filePath.lastIndexOf("."));
        String time = Calendar.getInstance().getTime().toString();
        String newFilePath = path+time+extension;

        CSVWriter csvWriter = new CSVWriter(new FileWriter(newFilePath));
        for(String row : response){
            String [] arr = row.split("[$]");
            System.out.println(arr[1]+":::::::"+arr[0]);
            csvWriter.writeNext(arr);
        }
        csvWriter.close();
    }
}
