package com.selector.services;

import com.selector.dto.SkillDTO;
import com.selector.models.Skill;
import com.selector.repositories.ProductRepository;
import com.selector.repositories.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;

    public Set<SkillDTO> getSkillsByProduct(Long productId) {

        List<Skill> skills = skillRepository.findSkillsByProductId(productId);

        return skills.stream()
                .map(this::convertSkillToDto)
                .collect(Collectors.toSet());
    }

    private SkillDTO convertSkillToDto(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setName(skill.getName());

        return skillDTO;
    }
}
