package creditcard.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.Getter;

public class CardDto
{
    @Getter
    @CsvBindByPosition(position = 0)
    private String cardNumber;
    @Getter
    @CsvDate(value = "MM/dd/yyyy")
    @CsvBindByPosition(position = 1)
    private Date expirationDate;

    @Getter
    @CsvBindByPosition(position = 2)
    private String nameOfCardholder;

   // SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    // This default constructor used by opencsv to create object after reading from file.
    public CardDto(){

    }
    public CardDto(String cardNo, Date expDate, String name){
        this.cardNumber = cardNo;
        this.expirationDate = expDate;
        this.nameOfCardholder = name;
    }

    @Override public String toString ()
    {
        return "CardDto{" + "cardNumber='" + cardNumber + '\'' + ", expirationDate="
            + expirationDate + ", nameOfCardholder='" + nameOfCardholder + '\'' + '}';
    }
}
