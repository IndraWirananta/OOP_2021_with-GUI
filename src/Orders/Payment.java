package Orders;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Payment implements Serializable {

    private Date paymentDate;
    private int id;
    private String cardNumber;

    public Payment(int id, String date, String cardNumber) {
        SimpleDateFormat dateFormatOfStringInDB = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = null;
        try {
            d1 = dateFormatOfStringInDB.parse(date);
        } catch (ParseException e) {
            System.out.println(e);
        }

        this.paymentDate = d1;
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
