package com.bjsxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.service.StarService;

@Controller
public class StarController {
	@Autowired
	private StarService starService;
	
//	@RequestMapping("/")
//	public String selectStarById(Model model) {
//		model.addAttribute("star", starService.selectStarById(1));
//		return "index";
//	}
	
	@RequestMapping("/")
	public String selectAllStars(Model model) {
		model.addAttribute("stars", starService.selectAllStar());
		return "index";
	}
}
