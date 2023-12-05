package com.selector.services;

import com.selector.dto.ProductDTO;
import com.selector.models.Category;
import com.selector.models.Product;
import com.selector.repositories.CategoryRepository;
import com.selector.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Set<ProductDTO> getProductsByCategory(Long categoryId) {

        List<Product> products = productRepository.findProductsByCategoryId(categoryId);
        return products.stream()
                .map(this::convertProductToDto)
                .collect(Collectors.toSet());
    }

    private ProductDTO convertProductToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());

        // Map other fields as needed

        return productDTO;
    }
}

