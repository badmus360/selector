package com.selector.services;

import com.selector.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    ResponseEntity<List<CategoryDTO>> getCategories();
}
