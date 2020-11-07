package creditcard.detectcard;

import creditcard.model.CardDto;

import java.util.List;

public class Context
{
    private IoOperation ioOperation;

    public Context(IoOperation io){
        this.ioOperation = io;
    }

    public List<CardDto> readFile(String fileName){
        return ioOperation.readFile(fileName);
    }
}
