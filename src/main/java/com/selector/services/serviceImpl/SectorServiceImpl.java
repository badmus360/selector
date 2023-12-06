package com.selector.services.serviceImpl;

import com.selector.dto.CategoryDTO;
import com.selector.dto.ProductDTO;
import com.selector.dto.SkillDTO;
import com.selector.models.Category;
import com.selector.models.Product;
import com.selector.models.Sector;
import com.selector.models.Skill;
import com.selector.repositories.SectorRepository;
import com.selector.services.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;
    private CategoryDTO convertCategoryToDto(Category category) {

        category.getProducts().stream()
                .map(this::convertProductToDto)
                .collect(Collectors.toSet());

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        categoryDTO.setId(category.getId());

        return categoryDTO;
    }

    private ProductDTO convertProductToDto(Product product) {

        product.getSkills().stream()
                .map(this::convertSkillToDto)
                .collect(Collectors.toSet());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());

        return productDTO;
    }

    private SkillDTO convertSkillToDto(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setName(skill.getName());

        return skillDTO;
    }

    @Override
    public List<String> getAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();

        return sectors.stream()
                .map(Sector::getName)
                .collect(Collectors.toList());
    }
}
