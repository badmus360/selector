package com.selector.controllers;


import com.selector.dto.CategoryDTO;
import com.selector.services.service.CategoryService;
import com.selector.services.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories/{sectorName}")
    public Set<CategoryDTO> getCategoriesBySector(@PathVariable String sectorName) {

        return categoryService.getCategoriesBySector(sectorName);
    }
}
