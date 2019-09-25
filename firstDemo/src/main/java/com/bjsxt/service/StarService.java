package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Star;

public interface StarService {
	public Star selectStarById(Integer id);
	public List<Star> selectAllStar();
}
