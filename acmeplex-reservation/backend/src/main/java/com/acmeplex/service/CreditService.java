package com.acmeplex.service;

import com.acmeplex.model.Credit;
import com.acmeplex.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    /**
     * Fetch all credits
     * @return List of Credit
     */
    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    /**
     * Fetch a credit by its ID
     * @param creditID Credit ID
     * @return Credit if found, otherwise null
     */
    public Credit getCreditById(int creditID) {
        return creditRepository.findById(creditID).orElse(null);
    }

    /**
     * Save or update a credit
     * @param credit Credit object to save
     * @return Saved Credit
     */
    public Credit saveCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    /**
     * Delete a credit by its ID
     * @param creditID Credit ID to delete
     */
    public void deleteCredit(int creditID) {
        creditRepository.deleteById(creditID);
    }

    /**
     * Fetch credits associated with a specific user
     * @param userID User ID
     * @return List of Credit for the given user
     */
    public List<Credit> getCreditsByUser(int userID) {
        return creditRepository.findByUser_UserID(userID);
    }

    /**
     * Redeem a credit by marking it as used
     * @param credit Credit object to redeem
     * @return Redeemed Credit
     */
    public Credit redeemCredit(Credit credit) {
        if (credit.getExpiryDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Credit has expired and cannot be redeemed.");
        }
        // Logic to mark credit as redeemed can be added here
        credit.setAmount(0.0); // Assuming redemption zeroes out the credit
        return creditRepository.save(credit);
    }
}
