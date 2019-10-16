package com.mycompany.hibernate_inheritance.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Savings Account")
public class SavingsAccount extends Account {

	private int minBalance;
	private int interest;

	public SavingsAccount(String name, String bankName, int balance, int minBalance, int interest) {
		super(name, bankName, balance);
		this.minBalance = minBalance;
		this.interest = interest;
	}

}
