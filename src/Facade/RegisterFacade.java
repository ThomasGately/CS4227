package Facade;

public class RegisterFacade {

    private String firstName;
    private String sureName;
    private String email;
    private String contactNumber;
    private String password;
    private String gender;

    LoginEmailCheck emailChecker;
    LoginPasswordCheck passwordChecker;
    RegisterNameCheck fNameChecker;
    RegisterNameCheck sNameChecker;
    RegisterContactCheck contactChecker;

    public RegisterFacade(String fName, String sName, String emailAddress, String pass, String conNumber){
        this.firstName = fName;
        this.sureName = sName;
        this.email = emailAddress;
        this.password = pass;
        this.contactNumber = conNumber;


        emailChecker = new LoginEmailCheck();
        passwordChecker = new LoginPasswordCheck();
        fNameChecker = new RegisterNameCheck();
        sNameChecker = new RegisterNameCheck();
        contactChecker = new RegisterContactCheck();
        emailChecker.setEmail(email);
        passwordChecker.setPassword(password);
        fNameChecker.setName(firstName);
        sNameChecker.setName(sureName);
        contactChecker.setMobileNumber(conNumber);
    }
    public String getFirstName(){return firstName;}
    public String getSureName(){return  sureName;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public String getContactNumber(){return contactNumber;}


    public boolean register(){
        boolean valid = false;

        if(emailChecker.emailCheck(getEmail()) && passwordChecker.passwordCheck(getPassword()) && fNameChecker.nameCheck(getFirstName()) && sNameChecker.nameCheck(getSureName()) && contactChecker.contactCheck(getContactNumber())){

            valid = true;
        }
        //We need to check with the database as well

        return valid;
    }
}
