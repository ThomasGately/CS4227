package Facade;

public class PasswordCheck {

    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public boolean passwordCheck(String passwordToCheck){
        boolean valid = true;

        if(passwordToCheck.equals(getPassword())){

            if(passwordToCheck.length() < 8){
                valid = false;
            }
        }

        String upperCase = "(.*[A-Z].*)";

        if(!passwordToCheck.matches(upperCase)){
            valid = false;
        }
        String lowerCase = "(.*[a-z].*)";
        if(!passwordToCheck.matches(lowerCase)){
            valid = false;
        }
        String numbers = "(.*[0-9].*)";
        if(!passwordToCheck.matches(numbers)){
            valid = false;
        }

        return valid;

    }
}
