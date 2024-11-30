package com.acmeplex.model;
import jakarta.persistence.*;

@Entity
public class RegisteredUser extends User {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean annualFeePaid;

    @Embedded
    private Address address;

    @Embedded
    private CardDetail cardDetail;

    // Constructors
    
    public RegisteredUser() {}

    public RegisteredUser(String email, String password, String firstName, String lastName, boolean annualFeePaid, Address address, CardDetail cardDetail) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualFeePaid = annualFeePaid;
        this.address = address;
        this.cardDetail = cardDetail;
    }

    // Getters

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAnnualFeePaid() {
        return annualFeePaid;
    }

    public Address getAddress() {
        return address;
    }

    public CardDetail getCardDetail() {
        return cardDetail;
    }

    // Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAnnualFeePaid(boolean annualFeePaid) {
        this.annualFeePaid = annualFeePaid;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCardDetail(CardDetail cardDetail) {
        this.cardDetail = cardDetail;
    }
}
