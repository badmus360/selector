package com.selector.services.service;

import com.selector.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Set<CategoryDTO> getCategoriesBySector(String sectorName);
}
