package com.pickyourtrail.service;

import java.util.List;

public interface PickYourTrailService {

	public List<String> fetchMovieTitle(String partialName);

	public String fetchMovieTitleStrings(String partialName);

}
