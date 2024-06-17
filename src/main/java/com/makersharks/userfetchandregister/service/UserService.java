package com.makersharks.userfetchandregister.service;

import com.makersharks.userfetchandregister.exception.UserAlreadyExistsException;
import com.makersharks.userfetchandregister.exception.UserNotFoundException;
import com.makersharks.userfetchandregister.model.User;
import com.makersharks.userfetchandregister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Method to register a new user
    public User registerUser(User user) {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserAlreadyExistsException("User already exists with username: " + user.getUsername());
        }
        return userRepository.save(user);
    }

    // Method to fetch a user by username
    public Optional<User> fetchUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findById(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username)));
    }
}
