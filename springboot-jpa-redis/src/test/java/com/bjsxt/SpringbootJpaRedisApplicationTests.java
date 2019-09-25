package com.bjsxt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import com.bjsxt.dao.MessageDao;
import com.bjsxt.pojo.Message;
import com.bjsxt.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaRedisApplicationTests {
	
	@Autowired
	private MessageDao messageDao;
	
	@Test
	public void contextLoads() {
		System.out.println("初始化数据库");
	}
	
	@Test
	public void testSelect() {
		Sort sort = new Sort(Direction.DESC,"date");
		Pageable pageable = PageRequest.of(0, 3, sort);
		List<Predicate> p=new ArrayList<Predicate>();
		Page<Message> findAll = messageDao.findAll(new Specification<Message>() {
			
			@Override
			public Predicate toPredicate(Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				p.add(criteriaBuilder.equal(root.get("user").get("id"), 1));
				return criteriaBuilder.and(p.toArray(new Predicate[] {}));
			}
		},pageable);
		
		List<Message> list = findAll.getContent();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			Message message = list.get(i);
			System.out.print(message.getId()+"/t"+message.getContent()+"/t"+message.getDate()+"/t");
			User user = message.getUser();
			System.out.println(user.getId()+"/t"+user.getUsername()+"/t"+user.getPassword());
		}
	}
	
	@Test
	public void testUpdate() {
		Message message=new Message();
		User user = new User();
		user.setId(1);
		message.setUser(user);
		message.setContent("hello2");
		messageDao.save(message);
	}
	

}
