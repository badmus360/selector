package com.selector.controllers;

import com.selector.dto.ProductDTO;
import com.selector.services.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/categories/{name}")
    public Set<ProductDTO> getProductsByCategory(@PathVariable String name) {
        return productService.getProductsByCategory(name);
    }
}
