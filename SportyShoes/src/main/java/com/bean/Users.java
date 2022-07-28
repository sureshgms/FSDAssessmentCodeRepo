package com.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="userid")
	private int userId;
	@Column(name="emailid")
	private String emailId;
	@Column(name="password")
	private String password;
	
	@OneToMany(targetEntity = PurchaseOrders.class, cascade = CascadeType.ALL)
	@JoinColumn(name="userid", referencedColumnName = "userid")
	private List<PurchaseOrders> poList;

}
