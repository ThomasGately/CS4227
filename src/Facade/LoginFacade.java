package Facade;

public class LoginFacade {

    private String email;
    private String password;
    private String message;

    LoginEmailCheck emailChecker;
    LoginPasswordCheck passwordChecker;

    public LoginFacade(String newEmail, String newPassword){
        this.email = newEmail;
        this.password = newPassword;

        emailChecker = new LoginEmailCheck();
        passwordChecker = new LoginPasswordCheck();
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

}
