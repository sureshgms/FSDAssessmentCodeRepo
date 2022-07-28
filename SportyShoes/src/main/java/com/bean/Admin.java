package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Admin {
	
	@Id
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;

}
