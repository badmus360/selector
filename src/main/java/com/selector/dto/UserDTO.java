package com.selector.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Builder
@Getter
@Setter
public class UserDTO {
    private String name;

    private Set<SectorDTO> sectors;

    private Boolean terms;
}
