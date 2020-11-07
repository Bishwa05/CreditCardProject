package creditcard.model;

import java.util.Date;
import lombok.Getter;

public class CardDto
{
    @Getter
    private String cardNumber;
    @Getter
    private Date expirationDate;
    @Getter
    private String nameOfCardholder;


    public CardDto(String cardNo, Date expDate, String name){
        this.cardNumber = cardNo;
        this.expirationDate = expDate;
        this.nameOfCardholder = name;
    }
}
