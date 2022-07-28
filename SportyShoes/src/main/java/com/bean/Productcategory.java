package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Component
public class Productcategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryid;
	private String categoryname;
}
