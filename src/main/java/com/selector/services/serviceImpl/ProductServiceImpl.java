package com.selector.services.serviceImpl;

import com.selector.dto.ProductDTO;
import com.selector.models.Product;
import com.selector.repositories.ProductRepository;
import com.selector.services.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
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

        return productDTO;
    }
}

