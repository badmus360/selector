package com.selector.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sectors", indexes = @Index(columnList = "name"))
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "sector", cascade = CascadeType.ALL)
    private Set<Category> categories;
}
