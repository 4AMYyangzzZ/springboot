package com.bjsxt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.bjsxt.dao.MessageDao;
import com.bjsxt.dao.UserDao;
import com.bjsxt.pojo.Message;
import com.bjsxt.pojo.User;
import com.bjsxt.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private UserDao userDao;
	
	//查询最新的个性签名
	@Override
	public Message selectMsgLast(Integer uid) {
		//实现动态查询并分页排序
		Sort sort = new Sort(Direction.DESC,"date");
		Pageable pageable = PageRequest.of(0, 3, sort);
		List<Predicate> p=new ArrayList<Predicate>();
		Page<Message> findAll = messageDao.findAll(new Specification<Message>() {
			
			@Override
			public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				p.add(criteriaBuilder.equal(root.get("user").get("id"), uid));
				return criteriaBuilder.and(p.toArray(new Predicate[] {}));
			}
		},pageable);
		
		List<Message> list = findAll.getContent();
		 if(list.size()>0) {
			 return list.get(0);
		 }
		return null;
	}
	
	//查询历史签名，并分页
	@Override
	public List<Message> selectPreviousMsg(Integer uid,Integer page ,Integer rows) {
		// TODO Auto-generated method stub
		Sort sort = new Sort(Direction.DESC,"date");
		Pageable pageable = PageRequest.of(page,rows, sort);
		Page<Message> pageList= messageDao.findAll(pageable);
		List<Message> list = pageList.getContent();
		return list;
	}
	
	@Override
	public Message updateMsgById(Integer id, String message) {
		Optional<Message> optional = messageDao.findById(id);
		Message msg = optional.get();
		msg.setContent(message);
		try {
			return messageDao.save(msg);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
