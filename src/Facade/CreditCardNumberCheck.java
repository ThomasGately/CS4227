package Facade;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardNumberCheck {

    private String cardNumber;


    public void setCardHolder(String cardHolder) { this.cardNumber = cardNumber;}

    public String getCardNumber() {return cardNumber;}

    public boolean cardNumberCheck(String cardNumber){
        boolean valid = true;

        if(cardNumber.equals(getCardNumber())){

            Pattern pattern = Pattern.compile("^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|");

            Matcher matcher = pattern.matcher(cardNumber);

            if (!matcher.matches()) {
                valid = false;
            }
        }
        return valid;
    }

}
