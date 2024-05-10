package com.bpl.rest;

import java.util.List;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bpl.constants.AppConstants;
import com.bpl.entity.Plan;
import com.bpl.props.AppProperties;
import com.bpl.service.IPlanService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class PlanOperationController {

	
	private IPlanService planService;
	
	private Map<String,String> messages;
	
	public PlanOperationController(IPlanService planService ,AppProperties properties) {
		this.planService=planService;
		this.messages=properties.getMessages();
	}
	
             @PostMapping("/save")
	     public  ResponseEntity<String> savePlan(@RequestBody Plan plan){
	           	boolean isSaved=planService.savePlan(plan);
	                String responseMsg=AppConstants.EMPTY_STR;
               	if(isSaved) {
	                    responseMsg=messages.get(AppConstants.PLAN_SAVE_SUCC);
                         }else {
                        	responseMsg=messages.get( AppConstants.PLAN_SAVE_FAIL );
                    }

              return new ResponseEntity<String>(responseMsg,HttpStatus.CREATED);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?> getPlanCategories(){
		Map<Integer,String> categories=planService.getPlanCategories();
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}
	
	
	@GetMapping("/allplan")
	public ResponseEntity<?> showAllPlan(){
		List<Plan> planList=planService.showAllPlan();
		return new ResponseEntity<>(planList,HttpStatus.OK);
	}
	
	@GetMapping("/plan/{id}")
	public ResponseEntity<?> editPlan(@PathVariable Integer id){
		Plan plan=planService.getPlanById(id);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePlan(@RequestBody Plan plan){
		boolean isUpdated=planService.updatePlan(plan);
		String responseMsg=AppConstants.EMPTY_STR;
		if(isUpdated) {
			responseMsg=messages.get( AppConstants.PLAN_UPDATE_SUCC );
		}else {
			responseMsg=messages.get( AppConstants.PLAN_UPDATE_FAIL );
		}
		
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePlanById(@PathVariable Integer id){
		boolean isDeleted=planService.deletePlanById(id);
		String responseMsg=AppConstants.EMPTY_STR;
		if(isDeleted) {
			responseMsg=messages.get( AppConstants.PLAN_DELETE_SUCC );
		}else {
			responseMsg=messages.get( AppConstants.PLAN_DELETE_FAIL );
		}
		
		return new ResponseEntity<>(responseMsg,HttpStatus.OK);
	}
	
	@PutMapping("/soft/{id}/{status}")
	public ResponseEntity<?> planStatusChange(@PathVariable Integer id, @PathVariable String status){
		
		boolean isStatusChanged=planService.planStatusChange(id, status);
		
		String msg=AppConstants.EMPTY_STR;
		
		if (isStatusChanged) {
			msg=messages.get(AppConstants.PLAN_STATUS_CHANGE_SUCC );
		}else {
			msg=messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL );
		}
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}

}
