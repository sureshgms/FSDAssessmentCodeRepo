package com.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productid;
	private String productname;

	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categoryid", insertable = true) 
	private Productcategory pcategory;
	
	@OneToMany(targetEntity = PurchaseOrders.class, cascade = CascadeType.ALL)
	@JoinColumn(name="userid", referencedColumnName = "productid")
	private List<PurchaseOrders> poList;
	
}
