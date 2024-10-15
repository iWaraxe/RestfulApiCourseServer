// File: ZipCodeRepository.java
package com.coherentsolutions.restful.repository;

import com.coherentsolutions.restful.model.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZipCodeRepository extends JpaRepository<ZipCode, Long> {
    Optional<ZipCode> findByCode(String code);

    boolean existsByCode(String code);
}
