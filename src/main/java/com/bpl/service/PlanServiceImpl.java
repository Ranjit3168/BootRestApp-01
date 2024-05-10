package com.bpl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpl.entity.Plan;
import com.bpl.entity.PlanCategory;
import com.bpl.repository.ICategoryRepository;
import com.bpl.repository.IPlanRepository;

@Service("planService")
public class PlanServiceImpl implements IPlanService {

	@Autowired
	private IPlanRepository planRepo;
	
	@Autowired
	private ICategoryRepository catRepo;
	
//	@Override
//	public String registerPlan(Plan plan) {
//		Integer idVal=planRepo.save(plan).getPlanId();
//		return "plan Saved With Id Val"+idVal;
//	}
	

	@Override
	public Map<Integer, String> getPlanCategories() {
		
		List<PlanCategory> categories=catRepo.findAll();
		Map<Integer,String> categorymap=new HashMap<Integer, String>();
		categories.forEach(category->
             categorymap.put(category.getCategoryId(), category.getCategoryName()));
		
		return categorymap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		 Plan saved = planRepo.save(plan);
	 return saved != null ;
	}

	@Override
	public List<Plan> showAllPlan() {
		List<Plan> planList=planRepo.findAll();
		return planList;
	}

	@Override
	public Plan getPlanById(Integer planId) {
	Optional<Plan> plan=planRepo.findById(planId);
	if(plan.isPresent()) {
		return plan.get();
	    }
	  return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		  planRepo.save(plan);
		return  plan.getPlanId() != null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		
		boolean status=false;
		try {
			planRepo.deleteById(planId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String activeSw) {
		Optional<Plan> getId = planRepo.findById(planId);
		if(getId.isPresent()) {
		Plan plan=getId.get();
		plan.setActiveSw(activeSw);
		planRepo.save(plan);
		return true;
		}
		return false;
	}

	

}
