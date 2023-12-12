package com.selector.repositories;

import com.selector.models.Category;
import com.selector.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products p WHERE p.category_name = :name", nativeQuery = true)
    List<Product> findProductsByCategoryName(@Param("name") String name);
}
