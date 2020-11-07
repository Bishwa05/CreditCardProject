package creditcard.detectcard;

import creditcard.model.CardDto;
import creditcard.process.AmexCard;
import creditcard.process.DiscoverCard;
import creditcard.process.MasterCard;
import creditcard.process.VisaCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardService
{
    public List<CardDto> checkAndReadFile(String filePath){

        String extension = filePath.substring(
            filePath.lastIndexOf("."));

        if("json".equals(extension)){
            Context ctx = new Context(new JsonFileOperation());
            return ctx.readFile(filePath);
        } else if("xml".equals(extension)) {
            Context ctx = new Context(new XmlFileOperation());
            return ctx.readFile(filePath);
        } else if("csv".equals(extension)){
            Context ctx = new Context(new CsvFileOperation());
            return ctx.readFile(filePath);
        }
        return null;
    }

    public List<String> processCards(List<CardDto> cardsDto){
        List<String> result = new ArrayList<>();

        for(CardDto c : cardsDto){
            String cardNo = c.getCardNumber();

            boolean cardFound = false;
            if(cardNo.length() ==16){
                int sec = cardNo.charAt(1) -48;
                String first4Digit = cardNo.substring(0,4);
                if(cardNo.charAt(0) == '5' &&
                    (sec>1 && sec<5)){
                    String resp = new MasterCard(cardNo, c.getExpirationDate(), c.getNameOfCardholder()).response();
                    result.add(resp);
                    cardFound= true;
                } else if(cardNo.charAt(0)=='4'){
                    String resp = new VisaCard(cardNo, c.getExpirationDate(), c.getNameOfCardholder()).response();
                    result.add(resp);
                    cardFound= true;
                } else if("6011".equals(first4Digit)){
                    String resp = new DiscoverCard(cardNo, c.getExpirationDate(), c.getNameOfCardholder()).response();
                    result.add(resp);
                    cardFound= true;
                }

            }else if(cardNo.length() == 15){
                int sec = cardNo.charAt(1) -48;
                if(cardNo.charAt(0)=='3' && (sec ==4|| sec == 7)){
                    String resp = new AmexCard(cardNo, c.getExpirationDate(), c.getNameOfCardholder()).response();
                    result.add(resp);
                    cardFound= true;
                }

            } else if(cardNo.length() == 13 && cardNo.charAt(0)=='4'){
                String resp = new VisaCard(cardNo, c.getExpirationDate(), c.getNameOfCardholder()).response();
                result.add(resp);
                cardFound= true;
            }

            if(!cardFound){
                String res = c.getCardNumber()+"$$"+"Invalid Card";
                result.add(res);
            }
        }
        return result;
    }
}
