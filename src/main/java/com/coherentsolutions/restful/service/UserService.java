// File: UserService.java
package com.coherentsolutions.restful.service;

import com.coherentsolutions.restful.exception.DuplicateResourceException;
import com.coherentsolutions.restful.exception.ResourceNotFoundException;
import com.coherentsolutions.restful.model.User;
import com.coherentsolutions.restful.model.ZipCode;
import com.coherentsolutions.restful.repository.UserRepository;
import com.coherentsolutions.restful.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    // Create User
    public User createUser(User user) {
        // Check for duplicate name and sex
        if (userRepository.existsByNameAndSex(user.getName(), user.getSex())) {
            throw new DuplicateResourceException("User with the same name and sex already exists.");
        }

        // Validate zip code
        if (user.getZipCode() != null) {
            ZipCode zipCode = zipCodeRepository.findByCode(user.getZipCode().getCode())
                    .orElseThrow(() -> new ResourceNotFoundException("Zip code not found."));
            user.setZipCode(zipCode);
        }

        return userRepository.save(user);
    }

    // Get Users with Filtering
    public List<User> getUsers(Integer olderThan, Integer youngerThan, String sex) {
        if (olderThan != null) {
            return userRepository.findByAgeGreaterThan(olderThan);
        } else if (youngerThan != null) {
            return userRepository.findByAgeLessThan(youngerThan);
        } else if (sex != null) {
            return userRepository.findBySex(sex);
        } else {
            return userRepository.findAll();
        }
    }

    // Update User
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        // Update fields
        if (userDetails.getName() != null) user.setName(userDetails.getName());
        if (userDetails.getSex() != null) user.setSex(userDetails.getSex());
        if (userDetails.getAge() != null) user.setAge(userDetails.getAge());

        // Handle zip code
        if (userDetails.getZipCode() != null) {
            ZipCode zipCode = zipCodeRepository.findByCode(userDetails.getZipCode().getCode())
                    .orElseThrow(() -> new ResourceNotFoundException("Zip code not found."));
            user.setZipCode(zipCode);
        }

        return userRepository.save(user);
    }

    // Delete User
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        userRepository.delete(user);
    }

}
