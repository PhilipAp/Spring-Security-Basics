package com.sec.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class UserInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Size(max=50)
	private String username;
	
	@Size(max=30)
	private String country;
	
	private Short enabled;
	
	@Size(max=100)
	private String fullname;
	
	@Size(max=800)
	@NotNull
	private String passkey;
	
	@Size(max=50)
	private String role;
	
	
	 
}
