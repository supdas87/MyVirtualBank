package com.demo.virtualbank.models;

import java.math.BigDecimal;

public class User {

	private Integer userId;
	private String userName;
	private BigDecimal totalAmount;

	public User(Integer userId, String userName, BigDecimal totalAmount) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.totalAmount = totalAmount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
