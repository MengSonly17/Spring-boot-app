package com.setec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.setec.entities.Booked;
import com.setec.repos.BookedRepos;
import com.setec.telegrambot.MyTelegramBot;

@Controller
public class MyController {
	
	
//	http://localhost:9091/
	
	@Autowired
	private BookedRepos bookedrepos;
	
	
	
	@GetMapping({"/","/home"})
	public String home(Model mode) {
		Booked book = new Booked();
		
		mode.addAttribute("booked",book);
		return "index";
	}
	
	@GetMapping({"/about"})
	public String about(Model mode) {
		return "about";
	}
	
	@GetMapping({"/service"})
	public String service(Model mode) {
		return "service";
	}
	
	@GetMapping({"/menu"})
	public String menu(Model mode) {
		return "menu";
	}
	
	@GetMapping({"/reservation"})
	public String reservation(Model mode) {
		Booked book = new Booked();
		
		mode.addAttribute("booked",book);
		return "reservation";
	}
	
	@GetMapping({"/testimonial"})
	public String testimonial(Model mode) {
	
		
		return "testimonial";
	}
	
	@GetMapping({"/contact"})
	public String contact(Model mode) {
		return "contact";
	}
	
	@Autowired
	private MyTelegramBot bot;
	
	@PostMapping({"/success"})
	public String success(Model mode,@ModelAttribute Booked booked) {
		
		bookedrepos.save(booked);
		
		mode.addAttribute("message","Form submitted successfully and saved!");
		
		System.out.println(bot);
		 
		bot.message(booked);
		
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
}
