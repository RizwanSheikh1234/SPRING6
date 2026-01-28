package com.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Product {
	@Id
	private int id;
	private String title;
	private String category;
	private LocalDate pdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getPdate() {
		return pdate;
	}

	public void setPdate(LocalDate pdate) {
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", category=" + category + ", pdate=" + pdate + "]";
	}

}
