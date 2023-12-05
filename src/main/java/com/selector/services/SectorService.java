package com.selector.services;

import com.selector.dto.CategoryDTO;
import com.selector.dto.ProductDTO;
import com.selector.dto.SectorDTO;
import com.selector.dto.SkillDTO;
import com.selector.models.Category;
import com.selector.models.Product;
import com.selector.models.Sector;
import com.selector.models.Skill;
import com.selector.repositories.SectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SectorService {

    @Autowired
    SectorRepository sectorRepository;

    public Set<SectorDTO> getAllSectorsWithCategoriesAndProductsAndSkills() {
        List<Sector> sectors = sectorRepository.findAll();

        return sectors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    private SectorDTO convertToDto(Sector sector) {
        SectorDTO sectorDTO = SectorDTO.builder().build();
        sectorDTO.setId(sector.getId());
        sectorDTO.setName(sector.getName());

        Set<CategoryDTO> categoryDTOS = sector.getCategories().stream()
                .map(this::convertCategoryToDto)
                .collect(Collectors.toSet());

        sectorDTO.setCategories(categoryDTOS);

        return sectorDTO;
    }

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
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());

        Set<SkillDTO> skillDTOS = product.getSkills().stream()
                .map(this::convertSkillToDto)
                .collect(Collectors.toSet());

//        productDTO.setSkills(skillDTOS);


        return productDTO;
    }

    private SkillDTO convertSkillToDto(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setName(skill.getName());

        return skillDTO;
    }

    public List<String> getAllSectors() {
        List<Sector> sectors = sectorRepository.findAll();

        return sectors.stream()
                .map(Sector::getName)
                .collect(Collectors.toList());
    }

    public Set<CategoryDTO> getCategoriesBySector(String sectorName) {
        Sector sector = sectorRepository.findByName(sectorName);
        if (sector == null) {
            // Handle the case where the sector is not found, you can throw an exception or return an empty set
            return Collections.emptySet();
        }

        return sector.getCategories().stream()
                .map(this::convertCategoryToDto)
                .collect(Collectors.toSet());
    }



}
