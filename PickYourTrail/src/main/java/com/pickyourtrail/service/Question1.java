package com.pickyourtrail.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.web.client.RestTemplate;

public class Question1 {

	private final RestTemplate restTemplate = new RestTemplate();
	String movieDBUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title=";

	private List<String> getAllMovieTiles(String movieName) {
		List<String> moviesList = new ArrayList<>();
		List<MovieDetailsVO> movieDetails = new ArrayList<>();
		try {
			movieDBUrl += movieName;
			MovieResponeVO respone = restTemplate.getForObject(movieDBUrl, MovieResponeVO.class);
			if (null != respone) {
				movieDetails.addAll(respone.getData());
				if (respone.getTotal_pages() > 1) {
					for (int i = 2; i <= respone.getTotal_pages(); i++) {
						movieDBUrl += "&page=" + i;
						MovieResponeVO respone1 = restTemplate.getForObject(movieDBUrl, MovieResponeVO.class);
						if (null != respone1) {
							movieDetails.addAll(respone1.getData());
						}
					}
				}

			}
			moviesList = movieDetails.stream().map(movie -> movie.getTitle()).collect(Collectors.toList());
			Collections.sort(moviesList);
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		return moviesList;
	}

	public static void main(String[] args) {
		Question1 q = new Question1();
		Scanner sc = new Scanner(System.in);
		String movieName = sc.next();
		List<String> movieTitles = q.getAllMovieTiles(movieName);
		movieTitles.forEach(System.out::println);
		sc.close();
	}
}
