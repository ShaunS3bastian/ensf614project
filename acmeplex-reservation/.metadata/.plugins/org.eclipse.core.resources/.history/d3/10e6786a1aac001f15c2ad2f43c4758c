package com.acmeplex.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role; // Possible values: "ROLE_USER", "ROLE_ADMIN"
    private String name;
    private String email;
    private String password; // Encrypted
    private boolean isRegisteredUser;

    private String address; // Optional for ordinary users
    private String creditCardInfo; // Optional for ordinary users
    private LocalDateTime accountExpiry; // For Registered Users

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRegisteredUser() {
        return isRegisteredUser;
    }

    public void setRegisteredUser(boolean registeredUser) {
        isRegisteredUser = registeredUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(String creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public LocalDateTime getAccountExpiry() {
        return accountExpiry;
    }

    public void setAccountExpiry(LocalDateTime accountExpiry) {
        this.accountExpiry = accountExpiry;
    }
}
