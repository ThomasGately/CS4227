package Facade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginEmailCheck {

    private String email;

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public boolean emailCheck(String email){
        boolean valid = true;
        if(email.equals(getEmail())){

            if (email != null){
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                        "[a-zA-Z0-9_+&*-]+)*@" +
                        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                        "A-Z]{2,7}$";

                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);
                if(!matcher.matches()){
                    valid = false;
                }
            }
        }

        else{
            valid = false;
        }
        return valid;
    }
}
