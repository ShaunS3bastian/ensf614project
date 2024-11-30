import jakarta.persistence.*;

@Embeddable
public class CardDetail {

    private String cardNumber;
    private String cardName;
    private String securityCode;
    private String expiryDate;

    // Constructors
    public CardDetail() {}

    public CardDetail(String cardNumber, String cardName, String securityCode, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.securityCode = securityCode;
        this.expiryDate = expiryDate;
    }

    // Getters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    // Setters
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

}
