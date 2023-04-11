package com.klinnovations.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue
	private Integer pid;
	
	@Size(min=3, max=15, message="size should be between 3 to 15")
	@NotBlank(message="Name is Mandatory")
	private String name;
	
	@NotNull(message="Price is Mandatory")
	@Positive(message="Price Should be Positive")
	private Double price;
	
	@NotNull(message="Quantity is Mandatory")
	@Positive(message="Quantity should be Positive")
	private Integer quantity;

}
