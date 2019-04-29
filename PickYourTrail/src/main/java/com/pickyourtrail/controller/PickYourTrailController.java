package com.pickyourtrail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pickyourtrail.service.PickYourTrailService;

@RestController
@RequestMapping("/pickYourTrail")
public class PickYourTrailController {
	
	@Autowired
	PickYourTrailService pickYourTrailService;
	
	@GetMapping(path = "/getMovieTitles",produces = {MediaType.APPLICATION_JSON_VALUE})
	public String fetchMovieTitles1(@RequestParam(value = "name") String name){
		String movieTiles =pickYourTrailService.fetchMovieTitleStrings(name);
		return movieTiles;
	}
	
	@GetMapping(path = "/getMovieTitlesList",produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<String> fetchMovieTitles(@RequestParam(value = "name") String name){
		List<String> movieTiles =pickYourTrailService.fetchMovieTitle(name);
		return movieTiles;
	}

	
	
}
