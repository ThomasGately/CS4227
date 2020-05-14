package Facade;

public class RegisterFacade {

    private String firstName;
    private String sureName;
    private String email;
    private String contactNumber;
    private String password;
    private String gender;

    EmailCheck emailChecker;
    PasswordCheck passwordChecker;
    NameCheck fNameChecker;
    NameCheck sNameChecker;
    ContactCheck contactChecker;

    public RegisterFacade(String fName, String sName, String emailAddress, String pass, String conNumber){
        this.firstName = fName;
        this.sureName = sName;
        this.email = emailAddress;
        this.password = pass;
        this.contactNumber = conNumber;


        emailChecker = new EmailCheck();
        passwordChecker = new PasswordCheck();
        fNameChecker = new NameCheck();
        sNameChecker = new NameCheck();
        contactChecker = new ContactCheck();
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
