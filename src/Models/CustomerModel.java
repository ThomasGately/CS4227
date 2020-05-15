package Models;

public class CustomerModel implements IModel{

    private int userID;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private int phone;
    private int loyaltyLevel;
    private int membership_type;

    public CustomerModel() {

    }

    public int getUserID(String password, String firstName, String lastName, String emailAddress, int phone) {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getLoyaltyLevel() {
        return loyaltyLevel;
    }

    public void setLoyaltyLevel(int loyaltyLevel) {
        this.loyaltyLevel = loyaltyLevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getMembership_type() {
        return membership_type;
    }

    public void setMembership_type(int membership_type) {
        this.membership_type = membership_type;
    }

    @Override
    public String toString() {
        return "'" +
                userName + "', '" +
                password + "', '" +
                firstName + "', '" +
                lastName + "', '" +
                address + "', '" +
                emailAddress + "', '" +
                phone + "', '" +
                loyaltyLevel + "', '" +
                membership_type + "'";
    }
}
