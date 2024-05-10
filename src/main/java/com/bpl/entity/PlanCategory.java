package com.bpl.entity;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name="PLAN_CATEGORY01")
public class PlanCategory implements Serializable {

	@Id
	@GeneratedValue
	private Integer categoryId;
	
	private String categoryName;
	
	private String activeSw;

    private String createdBy;
    
    private String updatedBy;
    
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdDate;
    
   @Column(insertable = false)
    @UpdateTimestamp
    private LocalDate updatedDate;
}
