package com.bjsxt.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bjsxt.pojo.Star;
import com.bjsxt.service.StarService;
@Service
public class StarServiceImpl implements StarService {
	
	//根据id查询star
	@Override
	public Star selectStarById(Integer id) {
		// TODO Auto-generated method stub
		Star star=new Star();
		star.setId(id);
		star.setName("jack");
		return star;
	}
	//hello world
	//查询所有的star
	@Override
	public List<Star> selectAllStar() {
		// TODO Auto-generated method stub
		List<Star> list=new ArrayList<>();
		for (int i = 0; i <5; i++) {
			Star star=new Star();
			star.setId(i+1);
			star.setName("star"+i+1);
			list.add(star);
		}
		return list;
	}

}
