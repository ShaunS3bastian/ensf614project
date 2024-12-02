package com.acmeplex.service;

import com.acmeplex.model.User;
import com.acmeplex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Fetch all users.
     *
     * @return List of all users.
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Fetch a user by ID.
     *
     * @param userID User ID to fetch.
     * @return User object if found, otherwise null.
     */
    public User getUserById(int userID) {
        return userRepository.findById(userID).orElse(null);
    }

    /**
     * Save or update a user.
     *
     * @param user User object to save.
     * @return Saved User object.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Delete a user by ID.
     *
     * @param userID User ID to delete.
     */
    public void deleteUser(int userID) {
        userRepository.deleteById(userID);
    }

    /**
     * Update details of an existing user.
     *
     * @param userID ID of the user to update.
     * @param updatedUser Updated user details.
     * @return Updated User object.
     */
    public User updateUser(int userID, User updatedUser) {
        User existingUser = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setRegistered(updatedUser.isRegistered());
        return userRepository.save(existingUser);
    }
}
