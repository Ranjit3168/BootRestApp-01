package com.bpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpl.entity.PlanCategory;

public interface ICategoryRepository extends JpaRepository<PlanCategory, Integer> {

}
