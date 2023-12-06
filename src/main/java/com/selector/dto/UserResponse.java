package com.selector.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String sector;
    private String category;
    private String product;
    private String skill;
    private boolean terms;
}
