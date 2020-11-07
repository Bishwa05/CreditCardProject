package creditcard.process;

import lombok.Getter;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.Date;

public class DiscoverCard extends CreditCard
{
    @Getter
    private String cardType;

    public DiscoverCard(String cardNumber, Date expirationDate, String nameOfCardholder){
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.nameOfCardholder = nameOfCardholder;
        this.cardType = "Discover";
    }

    public String response(){
        return cardNumber + "$$"+ cardType;
    }

}
