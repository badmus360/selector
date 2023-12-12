package com.selector.services.service;

import com.selector.dto.SkillDTO;

import java.util.Set;

public interface SkillService {

    Set<SkillDTO> getSkillsByProduct(String name);
}
