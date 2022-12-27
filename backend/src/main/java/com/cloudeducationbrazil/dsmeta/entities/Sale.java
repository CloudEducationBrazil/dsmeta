package com.cloudeducationbrazil.dsmeta.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_sales")
public class Sale {
	// INSERT INTO tb_sales(seller_name,visited,deals,amount,date) VALUES ('Kal-El',168,92,6299.0,'2021-12-28');
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String sellerName;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	public Sale() {}

	public Sale(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDate date) {
		this.id = id;
		this.sellerName = sellerName;
		this.visited = visited;
		this.deals = deals;
		this.amount = amount;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", sellerName=" + sellerName + ", visited=" + visited + ", deals=" + deals
				+ ", amount=" + amount + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, date, deals, id, sellerName, visited);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(date, other.date)
				&& Objects.equals(deals, other.deals) && Objects.equals(id, other.id)
				&& Objects.equals(sellerName, other.sellerName) && Objects.equals(visited, other.visited);
	}
}
