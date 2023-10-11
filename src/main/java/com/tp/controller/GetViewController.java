package com.tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tp.entity.Destinations;
import com.tp.repository.DestinationsRepository;

@Controller
public class GetViewController {
	@Autowired
	private DestinationsRepository destinationsRepository;
	
	@RequestMapping(value = "/addDestination",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView returnAddDestination()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("addDestination");
	  //mv.addObject("var", "halim");
	  return mv;
	  
	}
	
	@RequestMapping(value = "/listDestination",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView returnListDestination()
	{
	  ModelAndView mv = new ModelAndView();
	  List<Destinations> destinations = destinationsRepository.findAll();
	  mv.setViewName("listDestinations");
	  mv.addObject("destinations", destinations);
	  return mv;
	 
	}
}