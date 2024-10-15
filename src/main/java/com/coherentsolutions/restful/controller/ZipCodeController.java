// File: ZipCodeController.java
package com.coherentsolutions.restful.controller;

import com.coherentsolutions.restful.model.ZipCode;
import com.coherentsolutions.restful.repository.ZipCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/zip-codes")
public class ZipCodeController {

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    // Get Available Zip Codes
    @GetMapping
    public ResponseEntity<List<ZipCode>> getAvailableZipCodes() {
        List<ZipCode> zipCodes = zipCodeRepository.findAll();
        return ResponseEntity.ok(zipCodes);
    }

    // Add New Zip Codes
    @PostMapping("/expand")
    public ResponseEntity<List<ZipCode>> addZipCodes(@RequestBody List<String> zipCodes) {
        for (String code : zipCodes) {
            if (!zipCodeRepository.existsByCode(code)) {
                ZipCode zipCode = new ZipCode();
                zipCode.setCode(code);
                zipCodeRepository.save(zipCode);
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
