package com.selector.controllers;

import com.selector.dto.SkillDTO;
import com.selector.services.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/skill")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/products/{name}")
    public Set<SkillDTO> getSkillsByProducts(@PathVariable String name) {

        return skillService.getSkillsByProduct(name);
    }
}
