package com.bjsxt.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String username;
	@Column
	private String password;
	@OneToMany(mappedBy="user",fetch=FetchType.EAGER)
	private List<Message> list=new ArrayList<>();
}
