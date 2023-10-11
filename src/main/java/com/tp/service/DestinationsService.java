package com.tp.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.tp.entity.Destinations;
import com.tp.repository.DestinationsRepository;

import org.springframework.stereotype.Service;

@Service
public class DestinationsService {
	@Autowired
	private DestinationsRepository destinationsRepository;
	
	public void  saveDestinations(String destName, String destType, String imageLocation, String imageDescription, float popularityScore, String stateAndUTName,MultipartFile file)
	{
		Destinations destination = new Destinations();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			destination.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		destination.setDestName(destName);
		destination.setDestType(destType);
		destination.setImageDescription(imageDescription);
		destination.setImageLocation(imageLocation);
		destination.setPopularityScore(popularityScore);
		destination.setStateAndUTName(stateAndUTName);
        
		destinationsRepository.save(destination);
	}
	public List<Destinations> getAllDestinations()
	{
		return destinationsRepository.findAll();
	}
    public void deleteDestinationById(Long id)
    {
    	destinationsRepository.deleteById(id);
    }
    public void chageDestinationName(Long id ,String name)
    {
    	Destinations destination = new Destinations();
    	destination = destinationsRepository.findById(id).get();
    	destination.setDestName(name);;
    	destinationsRepository.save(destination);    
    }
}