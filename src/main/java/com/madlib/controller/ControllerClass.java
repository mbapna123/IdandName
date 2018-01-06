package com.madlib.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.madlib.entity.Entitie;
import com.madlib.entity.MVPClass;
import com.madlib.service.EntityInterface;
import com.madlib.service.EntityService;
import com.madlib.entity.Entitie;
import com.madlib.service.EntityService;

@Controller
public class ControllerClass {
	@Autowired
	private EntityService entityserv;
//	
//	@PostConstruct
//	  public void init(){
//		entityserv.initialize();
//	  }
//	
	@GetMapping("removename")
	public void removename(@RequestParam String ids) {
		entityserv.removethename(ids);
	}
	
	@GetMapping("addname")
	public String addthename(@RequestParam String name, @RequestParam String ids,  @RequestParam String city,  @RequestParam String mvp, @RequestParam String mvp2) {
		int numb=entityserv.addname(name,ids, city, mvp,mvp2);
		if(numb==0) {
			return "unsuccessful.jsp";
		}
		else {
			return "success.jsp";
		}
	}
	
	@GetMapping("cityinfo/{city}")
	public String getlistofnames(ModelMap model, @PathVariable String city) {
		ArrayList<Integer> listcity= entityserv.infocity(city);
		model.addAttribute("listcity",listcity);
		return "listcity.jsp";
	}

@GetMapping("allinfo")
	public String getlist(ModelMap model) {
	ArrayList<Integer> listall= entityserv.info();
		model.addAttribute("listall",listall);
		return "listall.jsp";
	}

}