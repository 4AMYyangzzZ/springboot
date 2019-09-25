package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Message;

public interface MessageService {
	//查询最新的个性签名
	Message selectMsgLast(Integer uid);
	//查询历史签名，并分页
	List<Message> selectPreviousMsg(Integer uid,Integer page,Integer rows);
	//根据个性签名的id，修改个性签名
	public Message updateMsgById(Integer id,String message);
}
