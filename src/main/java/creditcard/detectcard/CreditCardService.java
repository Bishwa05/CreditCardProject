package creditcard.detectcard;

import creditcard.model.CardDto;
import creditcard.process.AmexCard;
import creditcard.process.DiscoverCard;
import creditcard.process.MasterCard;
import creditcard.process.VisaCard;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Component
public class CreditCardService
{

    public Context getContext(String extension){
        Context ctx = null;

        if("json".equals(extension)){
            ctx = new Context(new JsonFileOperation());
        } else if("xml".equals(extension)) {
            ctx = new Context(new XmlFileOperation());
        } else if("csv".equals(extension)){
            ctx = new Context(new CsvFileOperation());
        }
        return ctx;
    }
    public List<CardDto> checkAndReadFile(String filePath){

        String extension = filePath.substring(
            filePath.lastIndexOf(".")+1);
        Context ctx = getContext(extension);
        if(ctx != null) {
            return ctx.readFile(filePath);
        }
        else {
            return null;
        }
    }

    public void writeToFile(String filePath, List<String> data) throws Exception{

        String extension = filePath.substring(
            filePath.lastIndexOf(".")+1);
        Context ctx = getContext(extension);
        if(ctx != null) {
            ctx.writeFile(filePath, data);
        }
    }

    public List<String> processCards(List<CardDto> cardsDto){
        List<String> result = new ArrayList<>();

        for(CardDto c : cardsDto){
            String cardNo = c.getCardNumber();

            System.out.println("Hello"+ c);
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
                String res = c.getCardNumber()+"$"+"Invalid Card";
                result.add(res);
            }
        }
        return result;
    }
}
