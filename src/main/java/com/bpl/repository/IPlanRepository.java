package com.bpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpl.entity.Plan;

public interface IPlanRepository extends JpaRepository<Plan, Integer> {

}
