package com.selector.controllers;

import com.selector.dto.SkillDTO;
import com.selector.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "*")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/products/{productId}")
    public Set<SkillDTO> getSkillsByProducts(@PathVariable Long productId) {
        return skillService.getSkillsByProduct(productId);
    }
}
