package com.bpl.service;

import java.util.List;
import java.util.Map;

import com.bpl.entity.Plan;

public interface IPlanService {
	// public String registerPlan(Plan plan);
	public Map<Integer, String> getPlanCategories();

	public boolean savePlan(Plan plan);

	public List<Plan> showAllPlan();

	public Plan getPlanById(Integer planId);

	public boolean updatePlan(Plan plan);

	public boolean deletePlanById(Integer planId);

	public boolean planStatusChange(Integer planId, String activeSw);
}
