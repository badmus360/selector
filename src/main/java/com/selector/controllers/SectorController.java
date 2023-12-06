package com.selector.controllers;

import com.selector.dto.CategoryDTO;
import com.selector.services.service.SectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/sectors")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class SectorController {


    private final SectorService sectorService;

    @GetMapping("/info")
    public List<String> getAllSectors() {
        return sectorService.getAllSectors();
    }
}
