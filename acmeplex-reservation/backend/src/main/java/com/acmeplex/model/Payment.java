import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;
    
    private String email;

    @Embedded
    private CardDetail cardDetail;

    // PAY relationship (via PaymentDetail)
    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private PaymentDetail paymentDetail;

    // Constructors

    public Payment() {}

    public Payment(String email, CardDetail cardDetail) {
        this.email = email;
        this.cardDetail = cardDetail;
    }

    // Getters

    public String getPaymentID() {
        return paymentID;
    }

    public String getEmail() {
        return email;
    }

    public CardDetail getCardDetail() {
        return cardDetail;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    // Setters

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCardDetail(CardDetail cardDetail) {
        this.cardDetail = cardDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

}
