package com.study.unittesting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

	@Id
	private int id;
	private String name;
	private int price;
	private int quantity;
	
	@Transient
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Item() {
		
	}
	
	public Item(int id, String name, int price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantidade() {
		return quantity;
	}

	public void setQuantidade(int quantidade) {
		this.quantity = quantidade;
	}

	public String toString() {
		return String.format("Item[%d %s %d %d]", id, name, price, quantity);
	}
}
