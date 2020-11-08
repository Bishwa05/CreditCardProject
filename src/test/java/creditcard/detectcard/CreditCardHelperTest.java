package creditcard.detectcard;

import creditcard.model.CardDto;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;





@WebMvcTest(CreditCardService.class)
public class CreditCardHelperTest
{

    @MockBean
    private CreditCardService service;

//    @BeforeEach
//    public void setUp(){


//        CardDto c6 = new CardDto("545678658907123", new Date(), "Master Card");
//        CardDto c7 = new CardDto("525678658907123", new Date(), "Master Card");
//        CardDto c8 = new CardDto("52567865890712389", new Date(), "Invalid Card");
//        CardDto c9 = new CardDto("3956786589071235", new Date(), "Invalid Card");
////        cards.add(c1);
////        cards.add(c2);
////        cards.add(c3);
////        cards.add(c4);
////        cards.add(c5);
////        cards.add(c6);
////        cards.add(c7);
////        cards.add(c8);
////        cards.add(c9);
//
//    }

    @Test
    public void isAmexCardTest() throws Exception {
        List<CardDto> cards = new ArrayList<>();
        CardDto c1 = new CardDto("345678658907123", new Date(), "AmexCard");
        CardDto c2 = new CardDto("375678658907123", new Date(), "Amex Card");
        cards.add(c1);
        cards.add(c2);



        List<String> result = new ArrayList<>();
        result.add("345678658907123"+"$$"+"AmericanExpress");
        result.add("375678658907123"+"$$"+"AmericanExpress");


        CreditCardService service2= new CreditCardService();
        List<String>result2 = service2.processCards(cards);

        Assertions.assertTrue(!result2.isEmpty());

        for(int i =0; i<result.size(); i++)
        Assertions.assertEquals(result.get(i), result2.get(i));

    }


    @Test
    public void isDiscoverCardTest() throws Exception {
        List<CardDto> cards = new ArrayList<>();
        CardDto c1 = new CardDto("6011786589071233", new Date(), "Discover Card");
        cards.add(c1);

        List<String> result = new ArrayList<>();
        result.add("6011786589071233"+"$$"+"Discover");


        CreditCardService service2= new CreditCardService();
        List<String>result2 = service2.processCards(cards);

        Assertions.assertTrue(!result2.isEmpty());

        for(int i =0; i<result.size(); i++)
            Assertions.assertEquals(result.get(i), result2.get(i));

    }

    @Test
    public void isVisaCardTest() throws Exception {
        List<CardDto> cards = new ArrayList<>();
        CardDto c1 = new CardDto("4356786589071", new Date(), "Visa Card");
        CardDto c2 = new CardDto("4353678658907123", new Date(), "Visa Card");
        cards.add(c1);
        cards.add(c2);



        List<String> result = new ArrayList<>();
        result.add("4356786589071"+"$$"+"Visa");
        result.add("4353678658907123"+"$$"+"Visa");


        CreditCardService service2= new CreditCardService();
        List<String>result2 = service2.processCards(cards);

        Assertions.assertTrue(!result2.isEmpty());

        for(int i =0; i<result.size(); i++)
            Assertions.assertEquals(result.get(i), result2.get(i));

    }

    @Test
    public void isMasterCardTest() throws Exception {
        List<CardDto> cards = new ArrayList<>();
        CardDto c1 = new CardDto("5456786589071233", new Date(), "Master Card");
        CardDto c2 = new CardDto("5256786589071234", new Date(), "Master Card");
        cards.add(c1);
        cards.add(c2);



        List<String> result = new ArrayList<>();
        result.add("5456786589071233"+"$$"+"MasterCard");
        result.add("5256786589071234"+"$$"+"MasterCard");


        CreditCardService service2= new CreditCardService();
        List<String>result2 = service2.processCards(cards);

        Assertions.assertTrue(!result2.isEmpty());

        for(int i =0; i<result.size(); i++)
            Assertions.assertEquals(result.get(i), result2.get(i));

    }


    @Test
    public void isInvalidCardTest() throws Exception {
        List<CardDto> cards = new ArrayList<>();
        CardDto c1 = new CardDto("52567865890712389", new Date(), "Invalid Card");
        CardDto c2 = new CardDto("3956786589071235", new Date(), "Invalid Card");
        cards.add(c1);
        cards.add(c2);



        List<String> result = new ArrayList<>();
        result.add("52567865890712389"+"$$"+"Invalid Card");
        result.add("3956786589071235"+"$$"+"Invalid Card");


        CreditCardService service2= new CreditCardService();
        List<String>result2 = service2.processCards(cards);

        Assertions.assertTrue(!result2.isEmpty());

        for(int i =0; i<result.size(); i++)
            Assertions.assertEquals(result.get(i), result2.get(i));

    }

}
