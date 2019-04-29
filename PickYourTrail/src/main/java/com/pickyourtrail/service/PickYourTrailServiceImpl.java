package com.pickyourtrail.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service("pickYourTrailService")
public class PickYourTrailServiceImpl implements PickYourTrailService {

	private final RestTemplate restTemplate = new RestTemplate();
	private String movieDBUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";
	@Override
	public List<String> fetchMovieTitle(String movieName) {
		List<String> moviesList = new ArrayList<>();
		List<MovieDetailsVO> movieDetails = new ArrayList<>();
		try {
			String movieUrl = movieDBUrl + movieName;
			MovieResponeVO respone = restTemplate.getForObject(movieUrl, MovieResponeVO.class);
			if (null != respone) {
				movieDetails.addAll(respone.getData());
				if (respone.getTotal_pages() > 1) {
					for (int i = 2; i <= respone.getTotal_pages(); i++) {
						movieUrl += "&page=" + i;
						MovieResponeVO respone1 = restTemplate.getForObject(movieUrl, MovieResponeVO.class);
						if (null != respone1) {
							movieDetails.addAll(respone1.getData());
						}
					}
				}

			}
			moviesList = movieDetails.stream().map(movie -> movie.getTitle()).collect(Collectors.toList());
			Collections.sort(moviesList);
			String opt = "";
			for(String name: moviesList) {
				opt+=name+"\n";
			}
			
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		return moviesList;
	}
	@Override
	public String fetchMovieTitleStrings(String movieName) {
		String opt = "";
		List<String> moviesList = new ArrayList<>();
		List<MovieDetailsVO> movieDetails = new ArrayList<>();
		try {
			String movieUrl = movieDBUrl + movieName;
			MovieResponeVO respone = restTemplate.getForObject(movieUrl, MovieResponeVO.class);
			if (null != respone) {
				movieDetails.addAll(respone.getData());
				if (respone.getTotal_pages() > 1) {
					for (int i = 2; i <= respone.getTotal_pages(); i++) {
						movieUrl += "&page=" + i;
						MovieResponeVO respone1 = restTemplate.getForObject(movieUrl, MovieResponeVO.class);
						if (null != respone1) {
							movieDetails.addAll(respone1.getData());
						}
					}
				}

			}
			moviesList = movieDetails.stream().map(movie -> movie.getTitle()).collect(Collectors.toList());
			Collections.sort(moviesList);
			
			for(String name: moviesList) {
				opt+=name+"\n";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input");
		}
		return opt;
	}

}
