package com.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name="purchaseorders")
public class PurchaseOrders {
	
	@Id
	@GeneratedValue

	private int orderid;
	private int userid;
	private int productid;
	private float amount;
	private Date orderdate;

}
