package com.selector.repositories;

import com.selector.models.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    Sector findByName(String name);
}
