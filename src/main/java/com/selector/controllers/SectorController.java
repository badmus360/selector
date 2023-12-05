package com.selector.controllers;

import com.selector.dto.CategoryDTO;
import com.selector.dto.SectorDTO;
import com.selector.dto.UserDTO;
import com.selector.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/sectors")
@CrossOrigin(origins = "*")
public class SectorController {

    @Autowired
    SectorService sectorService;

//    @GetMapping("/info")
//    public ResponseEntity<Set<SectorDTO>> getAllSectorsWithDetails() {
//        Set<SectorDTO> sectors = sectorService.getAllSectorsWithCategoriesAndProductsAndSkills();
//        return new ResponseEntity<>(sectors, HttpStatus.OK);
//    }

    @GetMapping("/info")
    public List<String> getAllSectors() {
        return sectorService.getAllSectors();
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitFormData(@RequestBody UserDTO userData) {
        // Process and save user data
        // You can access user data using userData.getName(), userData.getSector(), etc.
        // Implement saving to the database or any other necessary actions.
        return ResponseEntity.ok("Form submitted successfully!");
    }

    @GetMapping("/categories/{sectorName}")
    public Set<CategoryDTO> getCategoriesBySector(@PathVariable String sectorName) {
        System.out.println(sectorName);
        return sectorService.getCategoriesBySector(sectorName);
    }
}
