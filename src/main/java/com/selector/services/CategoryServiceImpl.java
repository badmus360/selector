package com.selector.services;

import com.selector.dto.CategoryDTO;
import com.selector.models.Category;
import com.selector.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ResponseEntity<List<CategoryDTO>> getCategories() {

        List<Category> category = categoryRepository.findAll();

        return null;
    }
}
