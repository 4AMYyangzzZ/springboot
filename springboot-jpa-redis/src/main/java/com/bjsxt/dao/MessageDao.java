package com.bjsxt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bjsxt.pojo.Message;

public interface MessageDao extends JpaRepository<Message, Integer> ,JpaSpecificationExecutor<Message>{

}
