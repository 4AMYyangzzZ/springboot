package com.bjsxt.service.impl;
//hello github
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bjsxt.pojo.Star;
import com.bjsxt.service.StarService;
@Service
public class StarServiceImpl implements StarService {

	@Override
	public Star selectStarById(Integer id) {
		// TODO Auto-generated method stub
		Star star=new Star();
		star.setId(id);
		star.setName("jack");
		return star;
	}

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
