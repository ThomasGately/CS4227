package Facade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameCheck {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean nameCheck(String name){
        boolean valid = true;

        if(name.equals(getName())){

            Pattern pattern = Pattern.compile("[a-zA-Z]*");

            Matcher matcher = pattern.matcher(name);

            if (!matcher.matches()) {
                valid = false;
            }
        }


        return valid;
    }
}
