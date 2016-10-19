package com.rohit.order.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
// @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Item implements Serializable {

	private static final long serialVersionUID = 6317823099522224486L;

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "itemDescription")
	private String itemDescription;

	@Column(name = "itemPrice")
	private long itemPrice;

	@Column(name = "itemCategory")
	private String itemCategory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public long getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(long itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

}
