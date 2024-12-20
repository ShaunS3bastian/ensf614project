package com.acmeplex.service;

import com.acmeplex.model.RegisteredUser;
import com.acmeplex.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisteredUserService {

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    /**
     * Fetch all registered users
     * 
     * @return List of RegisteredUser
     */
    public List<RegisteredUser> getAllRegisteredUsers() {
        return registeredUserRepository.findAll();
    }

    /**
     * Fetch a single registered user by ID
     * 
     * @param userID User ID to fetch
     * @return RegisteredUser if found, otherwise null
     */
    public RegisteredUser getRegisteredUserById(int userID) {
        return registeredUserRepository.findById(userID).orElse(null);
    }

    /**
     * Save or update a registered user
     * 
     * @param user RegisteredUser object to save
     * @return Saved RegisteredUser
     */
    public RegisteredUser saveRegisteredUser(RegisteredUser user) {
        return registeredUserRepository.save(user);
    }

    /**
     * Update details of an existing user
     * 
     * @param userID ID of the user to update
     * @param updatedUser Updated user details
     * @return Updated RegisteredUser
     */
    public RegisteredUser updateRegisteredUser(int userID, RegisteredUser updatedUser) {
        RegisteredUser existingUser = registeredUserRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setAddress(updatedUser.getAddress());
        existingUser.setCardDetail(updatedUser.getCardDetail());
        existingUser.setAnnualFeePaid(updatedUser.isAnnualFeePaid());
        return registeredUserRepository.save(existingUser);
    }

    /**
     * Delete a registered user by ID
     * 
     * @param userID User ID to delete
     */
    public void deleteRegisteredUser(int userID) {
        registeredUserRepository.deleteById(userID);
    }

    /**
     * Register a new user
     * 
     * @param user RegisteredUser object to register
     * @return Registered RegisteredUser
     */
    public RegisteredUser registerUser(RegisteredUser user) {
        user.setAnnualFeePaid(true); // Ensure the annual fee is marked as paid
        return registeredUserRepository.save(user);
    }

    /**
     * Authenticate a user by email and password
     * 
     * @param email Email of the user
     * @param password Password of the user
     * @return true if authenticated, false otherwise
     */
    public boolean authenticateUser(String email, String password) {
        RegisteredUser user = registeredUserRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
