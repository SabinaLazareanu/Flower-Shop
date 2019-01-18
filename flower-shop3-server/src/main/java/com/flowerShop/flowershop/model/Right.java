package com.flowerShop.flowershop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Right {

	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String right;

	public Right(int id, String right) {
		this.id = id;
		this.right = right;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}
}
