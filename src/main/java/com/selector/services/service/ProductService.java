package com.selector.services.service;

import com.selector.dto.ProductDTO;

import java.util.Set;

public interface ProductService {

    Set<ProductDTO> getProductsByCategory(String name);

}
