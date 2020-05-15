package Facade;

import Models.CustomerModel;

public class LoginFacade {

    private String email;
    private String password;
    private String message;

    EmailCheck emailChecker;
    PasswordCheck passwordChecker;

    public LoginFacade(String newEmail, String newPassword){
        this.email = newEmail;
        this.password = newPassword;

        emailChecker = new EmailCheck();
        passwordChecker = new PasswordCheck();
        emailChecker.setEmail(email);
        passwordChecker.setPassword(password);
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    public boolean login(){
        boolean valid = false;
        if (emailChecker.emailCheck(getEmail()) && passwordChecker.passwordCheck(getPassword())) {

            valid = true;
        }

        return valid;
    }

    public CustomerModel toModel(CustomerModel item) {

        item.setEmailAddress(getEmail());
        item.setPassword(getPassword());
        return item;
    }
}
