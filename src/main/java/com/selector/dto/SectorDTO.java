package com.selector.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SectorDTO {
    private Long id;

    private String name;

    private Set<CategoryDTO> categories;
}