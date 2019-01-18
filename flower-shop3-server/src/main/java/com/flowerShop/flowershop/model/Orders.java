package com.flowerShop.flowershop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrder;
	private String deliveryAddress;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date creationDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date deliveryDate;
	private int quantity;
	@Column(name = "Product_id_product")
	private int idProduct;
	@Column(name = "Client_email")
	private String clientEmail;

	public Orders() {
	}

	public Orders(int id, String deliveryAddress, Date creationDate, Date deliveryDate, int quantity, int idProduct,
			String userEmail) {
		this.idOrder = id;
		this.deliveryAddress = deliveryAddress;
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.clientEmail = userEmail;
	}

	public int getId() {
		return idOrder;
	}

	public void setId(int id) {
		this.idOrder = id;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	// @ManyToOne
	// @JoinColumn(name = "Product_idProduct")

	public int getProductId() {
		return idProduct;
	}

	public void setProductId(int idProduct) {
		this.idProduct = idProduct;
	}

	// @ManyToOne
	// @JoinColumn(name = "Client_email")

	public String getUserEmail() {
		return clientEmail;
	}

	public void setUserEmail(String user) {
		this.clientEmail = user;
	}

	@Override
	public String toString() {
		return "Orders [idOrder=" + idOrder + ", deliveryAddress=" + deliveryAddress + ", creationDate=" + creationDate
				+ ", deliveryDate=" + deliveryDate + ", quantity=" + quantity + ", idProduct=" + idProduct
				+ ", clientEmail=" + clientEmail + "]";
	}
	
}
