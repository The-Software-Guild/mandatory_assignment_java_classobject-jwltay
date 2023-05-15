package com.controller;

import java.time.LocalDate;

import com.model.MpaaRating;
import com.utility.DvdDaoImpl;
import com.view.DvdLibraryView;

public class DvdController {
	private DvdDaoImpl utility = new DvdDaoImpl();
	private DvdLibraryView view = new DvdLibraryView();
	
	public void addDvd() {
		String newTitle = view.requestStringInput("title");
		String newReleaseDate = view.requestStringInput("release date (in yyyy-mm-dd format)");
		String newMpaaRating = view.requestStringInput("MPAA rating (choose from G, PG, PG13, R, NC17)1");
		String newDirectorName = view.requestStringInput("director's name");
		String newStudio = view.requestStringInput("studio name");
		String newNotes = view.requestStringInput("user notes");
		
		LocalDate formattedReleaseDate = LocalDate.parse(newReleaseDate);
		MpaaRating formattedMpaaRating = MpaaRating.valueOf(newMpaaRating);
		
		utility.createDvd(newTitle, formattedReleaseDate, formattedMpaaRating, newDirectorName, newStudio, newNotes);
	}
	
	public void listDvds() {
		view.displayDvdList(utility.getDvds());
	}
	
	public void removeDvd() {
		int index = view.requestNumberInput("index of the DVD to remove") - 1;
		utility.destroyDvd(index);
	}
	
	public void editDvd() {
		int index = view.requestNumberInput("index of the DVD to edit") - 1;
		view.displayEditOptions();
		int fieldChoice = view.requestNumberInput("index of the field to edit");
		String newValue = view.requestStringInput("new value");
		
		utility.updateDvd(index, fieldChoice, newValue);
	}
	
	public void showDvdDetails() {
		int index = view.requestNumberInput("index of the DVD to view") - 1;

		view.displayDvdDetails(utility.getDvds().get(index));
	}
	
	public void searchDvds() {
		String keyword = view.requestStringInput("search keyword");
		
		view.displaySearchResults(utility.searchDvds(keyword));
	}
	
	public void getDvds() {
		utility.loadDvds();
	}
	
	public void setDvds() {
		utility.saveDvds();
	}
}

