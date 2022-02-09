package com.mini.Mongo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller	
public class MainController {
	
	@Autowired
	private SaleInfoService saleinfoservice;
	
	// 메인
	@RequestMapping("/")
	public ModelAndView main() {
		Map<String,Object> map = new HashMap<>();		
		List<SaleInfoDTO> list=saleinfoservice.findone("year", "2014");
		map.put("items", list);
		return new ModelAndView("main", "map", map);
	}
	
	// 연도별
	@RequestMapping("/main2014.do")
	public ModelAndView main2014() {
		Map<String,Object> map = new HashMap<>();		
		List<SaleInfoDTO> list=saleinfoservice.findone("year", "2014");
		//List<SaleInfoDTO> list=saleinfoservice.getAll();
		map.put("items", list);
		return new ModelAndView("main", "map", map);
	}
	
	@RequestMapping("/main2015.do")
	public ModelAndView main2015() {
		Map<String,Object> map = new HashMap<>();		
		List<SaleInfoDTO> list=saleinfoservice.findone("year", "2015");
		//List<SaleInfoDTO> list=saleinfoservice.getAll();
		map.put("items", list);
		return new ModelAndView("main", "map", map);
	}
	
	@RequestMapping("/main2016.do")
	public ModelAndView main2016() {
		Map<String,Object> map = new HashMap<>();		
		List<SaleInfoDTO> list=saleinfoservice.findone("year", "2016");
		//List<SaleInfoDTO> list=saleinfoservice.getAll();
		map.put("items", list);
		return new ModelAndView("main", "map", map);
	}
	
	@RequestMapping("/main2017.do")
	public ModelAndView main2017() {
		Map<String,Object> map = new HashMap<>();		
		List<SaleInfoDTO> list=saleinfoservice.findone("year", "2017");
		//List<SaleInfoDTO> list=saleinfoservice.getAll();
		map.put("items", list);
		return new ModelAndView("main", "map", map);
	}
	
	@RequestMapping("/main2018.do")
	public ModelAndView main2018() {
		Map<String,Object> map = new HashMap<>();		
		List<SaleInfoDTO> list=saleinfoservice.findone("year", "2018");
		//List<SaleInfoDTO> list=saleinfoservice.getAll();
		map.put("items", list);
		return new ModelAndView("main", "map", map);
	}
	
	@RequestMapping("/main2019.do")
	public ModelAndView main2019() {
		Map<String,Object> map = new HashMap<>();		
		List<SaleInfoDTO> list=saleinfoservice.findone("year", "2019");
		//List<SaleInfoDTO> list=saleinfoservice.getAll();
		map.put("items", list);
		return new ModelAndView("main", "map", map);
	}
	
	@RequestMapping("/main2020.do")
	public ModelAndView main2020() {
		Map<String,Object> map = new HashMap<>();		
		List<SaleInfoDTO> list=saleinfoservice.findone("year", "2020");
		//List<SaleInfoDTO> list=saleinfoservice.getAll();
		map.put("items", list);
		return new ModelAndView("main", "map", map);
	}
}
