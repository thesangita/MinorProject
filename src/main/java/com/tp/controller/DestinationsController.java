package com.tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tp.entity.Destinations;
import com.tp.service.DestinationsService;

@Controller
public class DestinationsController {
	
	@Autowired
	private DestinationsService destinationsService;
	
	@GetMapping("/listDestinations.html")
	public String showExampleView(Model model)
	{
		List<Destinations> destinations = destinationsService.getAllDestinations();
		model.addAttribute("destinations", destinations);
		return "/listDestinations.html";
	}
    @GetMapping("/")
    public String showAdddestination()
    {
    	
    	return "/addDestination.html";
    }
    
    @PostMapping("/addD")
    public String saveDestination(@RequestParam("destName") String destName,@RequestParam("destType") String destType, @RequestParam("imageLocation") String imageLocation,@RequestParam("imageDescription") String imageDescription,@RequestParam("popularityScore") float popularityScore,@RequestParam("stateAndUTName") String stateAndUTName,@RequestParam("file") MultipartFile file)
    {
    	destinationsService.saveDestinations(destName,destType,imageLocation,imageDescription,popularityScore,stateAndUTName,file);
    	return "redirect:/listProducts.html";
    }
    
    @GetMapping("/deleteDestination/{id}")
    public String deleteDestination(@PathVariable("id") Long id)
    {
    	
    	destinationsService.deleteDestinationById(id);
    	return "redirect:/listDestinations.html";
    }
    
    @PostMapping("/changeName")
    public String changeDname(@RequestParam("id") Long id,
    		@RequestParam("newDname") String name)
    {
    	destinationsService.chageDestinationName(id, name);
    	return "redirect:/listDestinations.html";
    }
    
}