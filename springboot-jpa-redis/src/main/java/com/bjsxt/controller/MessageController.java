package com.bjsxt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bjsxt.pojo.Message;
import com.bjsxt.pojo.User;
import com.bjsxt.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	@RequestMapping("/")
	public String selectMsgLast(HttpSession session,Model model) {
		User user =(User) session.getAttribute("user");
		System.out.println(messageService.selectMsgLast(1).getContent());
		model.addAttribute("msg", messageService.selectMsgLast(1));
		return "message";
	}
	
	@RequestMapping("/history")
	public String selectPreviousMsg(@RequestParam(defaultValue="0")Integer page,@RequestParam(defaultValue="3") Integer rows,Model model,HttpSession session) {
		User user =(User) session.getAttribute("user");
		model.addAttribute("msgs", messageService.selectPreviousMsg(user.getId(), page, rows));
		return "history";
	}
	
	@RequestMapping("/update")
	public String updateMsgById(Integer id,String msg,Model model) {
		Message message = messageService.updateMsgById(id, msg);
		model.addAttribute("msg", message);
		return "message";
	}
	
}
