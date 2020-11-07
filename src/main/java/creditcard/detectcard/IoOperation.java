package creditcard.detectcard;

import creditcard.model.CardDto;

import java.util.List;

interface IoOperation
{
    List<CardDto> readFile(String fileName);
    void writeFile(String filePath, List<String> response) throws Exception;
}
