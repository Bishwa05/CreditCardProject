package creditcard.process;

import lombok.Getter;

import java.util.Date;

public class AmexCard extends CreditCard
{
    @Getter
    private String cardType;

    public AmexCard(String cardNumber, Date expirationDate, String nameOfCardholder){
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.nameOfCardholder = nameOfCardholder;
        this.cardType = "Discover";
    }

    public String response(){
        return cardNumber + "$$"+ cardType;
    }
}
