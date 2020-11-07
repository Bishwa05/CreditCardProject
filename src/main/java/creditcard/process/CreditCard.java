package creditcard.process;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

abstract class CreditCard
{
    @Getter
    @Setter
    String cardNumber;
    @Getter
    @Setter
    Date expirationDate;
    @Getter
    @Setter
    String nameOfCardholder;


    public abstract String response();

}
