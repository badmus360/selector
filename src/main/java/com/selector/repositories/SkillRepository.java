package com.selector.repositories;

import com.selector.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    @Query(value = "SELECT * FROM skills s WHERE s.product_name = :name", nativeQuery = true)
    List<Skill> findSkillsByProductName(@Param("name") String name);
}
