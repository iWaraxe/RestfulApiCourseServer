// File: UserRepository.java
package com.coherentsolutions.restful.repository;

import com.coherentsolutions.restful.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods

    // Find users older than a certain age
    List<User> findByAgeGreaterThan(Integer age);

    // Find users younger than a certain age
    List<User> findByAgeLessThan(Integer age);

    // Find users by sex
    List<User> findBySex(String sex);

    // Check for duplicate name and sex
    boolean existsByNameAndSex(String name, String sex);
}
