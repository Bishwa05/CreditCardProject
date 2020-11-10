package creditcard.process;

import lombok.Getter;

import java.util.Date;

public class VisaCard extends CreditCard
{
    @Getter
    private String cardType;

    public VisaCard(String cardNumber, Date expirationDate, String nameOfCardholder){
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.nameOfCardholder = nameOfCardholder;
        this.cardType = "Visa";
    }

    public String response(){
        return cardNumber + "$"+ cardType;
    }
}
