package com.mycompany.hibernate_inheritance.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Current Account")

public class CurrentAccount extends Account {
	private int minBalance;

	public CurrentAccount(String name, String bankName, int balance, int minBalance) {
		super(name, bankName, balance);
		this.minBalance = minBalance;
	}

}
