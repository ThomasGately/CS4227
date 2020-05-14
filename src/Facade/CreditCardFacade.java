package Facade;

public class CreditCardFacade {

    private String cardHolder;
    private String cardNumber;
    private String cvvNumber;

    NameCheck nameChecker;
    CreditCardNumberCheck cardNumberChecker;

    public CreditCardFacade(String cardHolder, String cardNumber){
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;

        nameChecker = new NameCheck();
        cardNumberChecker = new CreditCardNumberCheck();
        nameChecker.setName(cardHolder);
        cardNumberChecker.setCardHolder(cardNumber);
    }

    public String getCardHolder() {return cardHolder;}
    public String getCardNumber() {return cardNumber;}
    public String getCvvNumber() {return cvvNumber;}

    public boolean validateCreditCard(){
        boolean valid = false;

        if(nameChecker.nameCheck(getCardHolder()) && cardNumberChecker.cardNumberCheck(getCardNumber())){
            valid = true;
        }

        return valid;
    }

}
