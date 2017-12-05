package com.madlib.controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.madlib.service.EntityService;
import com.madlib.entity.Entitie;
import com.madlib.service.EntityService;

@Controller
public class ControllerClass {
	@Autowired
	private EntityService entityserv;
	@GetMapping("addname")
	public String addthename(@RequestParam String name, @RequestParam String ids,  @RequestParam float height,  @RequestParam float weight) {
		int numb=entityserv.addname(name,ids, height, weight);
		if(numb==0) {
			return "unsuccessful.jsp";
		}
		else {
			return "success.jsp";
		}
	}
	
@GetMapping("listofnames")
	public String getlistofnames(ModelMap model) {
		List<Entitie> listofnames= entityserv.getEntitiess();
		model.addAttribute("listofnames",listofnames);
		return "listnames.jsp";
	}

@GetMapping("infoonhumans")
	public String humaninfo(ModelMap model) {
	ArrayList<Float> heightarr=entityserv.getHeightArray();
	ArrayList<Float> weightarr=entityserv.getWeightArray();
	float heightavg=entityserv.getaveragearray(heightarr);
	float weightavg=entityserv.getaveragearray(weightarr);
	model.addAttribute("heightarray", heightarr);
	model.addAttribute("weightarray",weightarr);
	model.addAttribute("weightavg",weightavg);
	model.addAttribute("heightavg",heightavg);
	return("humaninfo.jsp");
}


}