package com.tutorial.hibernate.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(catalog = "PUBLIC")
public class Item {

	private Integer id;
	private String name;
	private List<ProductItem> productItems = new LinkedList<ProductItem>();

	public Item() {
	}

	@Id
	@Column(name = "item_id", nullable = false)
	@GeneratedValue(strategy = SEQUENCE)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy="pk.item", cascade = {
			CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public List<ProductItem> getProductItems() {
		return this.productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}
}
