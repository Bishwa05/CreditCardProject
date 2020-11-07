package creditcard.process;

import lombok.Getter;

import java.util.Date;

public class MasterCard extends CreditCard
{
    @Getter
    private String cardType;

    public MasterCard(String cardNumber, Date expirationDate, String nameOfCardholder){
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.nameOfCardholder = nameOfCardholder;
        this.cardType = "Discover";
    }

    public String response(){
        return cardNumber + "$$"+ cardType;
    }
}
