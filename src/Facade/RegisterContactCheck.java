package Facade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterContactCheck {

    private String mobileNumber;

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    public boolean contactCheck(String number){
        boolean valid = true;

        if(number.equals(getMobileNumber())){

            Pattern pattern = Pattern.compile("^08[35679]\\d{7}$");

            Matcher matcher = pattern.matcher(number);

            if (!matcher.matches()) {
                valid = false;
            }
        }


        return valid;
    }
}
