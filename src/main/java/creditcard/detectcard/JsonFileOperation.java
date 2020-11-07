package creditcard.detectcard;

import com.fasterxml.jackson.databind.ObjectMapper;
import creditcard.model.CardDto;
import java.util.ArrayList;
import java.util.List;

public class JsonFileOperation implements IoOperation
{
    public List<CardDto> readFile(String fileName){
        ObjectMapper jsonMapper = new ObjectMapper();
        List<CardDto> cardDtos = new ArrayList<>();

        return null;

    }
    public void writeFile(String filePath, List<String> response){

    }
}
