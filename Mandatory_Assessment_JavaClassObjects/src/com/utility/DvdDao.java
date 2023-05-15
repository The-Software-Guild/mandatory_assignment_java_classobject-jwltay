package com.utility;

import java.time.LocalDate;
import java.util.List;

import com.model.MpaaRating;
import com.model.Dvd;

public interface DvdDao {
	public List<Dvd> getDvds();
	public void createDvd(String title, 
			LocalDate releaseDate,
			MpaaRating mpaaRating, 
			String directorName,
			String studio, 
			String userNote
			);
	public void destroyDvd(int index);
	public void updateDvd(int index, int fieldChoice, String newValue);
	public List<Dvd> searchDvds(String searchPhrase);
	public void saveDvds();
	public void loadDvds();
}
