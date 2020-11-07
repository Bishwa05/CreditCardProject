package creditcard.detectcard;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import creditcard.model.CardDto;

import java.io.*;
import java.util.List;

public class CsvFileOperation implements IoOperation
{
    public List<CardDto> readFile(String fileName){
        File file = new File(fileName);
        try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            // create csv bean reader
            CsvToBean<CardDto> csvToBean = new CsvToBeanBuilder(reader).withType(CardDto.class).withIgnoreLeadingWhiteSpace(
                true).build();

            // convert `CsvToBean` object to list of cards
            List<CardDto> cards = csvToBean.parse();
            return cards;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    public void writeFile(){

    }
}
