package creditcard.detectcard;

import creditcard.model.CardDto;
import creditcard.process.AmexCard;
import creditcard.process.DiscoverCard;
import creditcard.process.MasterCard;
import creditcard.process.VisaCard;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CreditCardController
{
    private final CreditCardService service;

    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public void processCardJson(@RequestParam("filePath") String filePath){

    try {
        List<CardDto> cards = service.checkAndReadFile(filePath);

        printCards(cards);

        List<String> responseDetail = service.processCards(cards);

        service.writeToFile(filePath, responseDetail);
    } catch (Exception e){
        e.printStackTrace();
    }


    }


    public static void printCards(List<CardDto> cards){
        for(CardDto c : cards){
            System.out.println(c);
        }
    }

}
