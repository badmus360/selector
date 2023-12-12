package com.selector.services.serviceImpl;

import com.selector.dto.SkillDTO;
import com.selector.models.Skill;
import com.selector.repositories.SkillRepository;
import com.selector.services.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public Set<SkillDTO> getSkillsByProduct(String name) {

        List<Skill> skills = skillRepository.findSkillsByProductName(name);

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
