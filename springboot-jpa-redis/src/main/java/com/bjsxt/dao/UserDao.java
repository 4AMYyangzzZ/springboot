package com.bjsxt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bjsxt.pojo.User;

public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
