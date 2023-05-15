package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Dvd;

public class DvdLibraryView {
	Scanner scanner = new Scanner(System.in);
	
	public void listMenuOptions() {
		System.out.println("-----------------------------");
		System.out.println("[1] Add a DVD");
		System.out.println("[2] Remove a DVD");
		System.out.println("[3] Edit a DVD");
		System.out.println("[4] View all DVDs");
		System.out.println("[5] View a DVD's details");
		System.out.println("[6] Search for a DVD by title");
		System.out.println("[7] Load DVDs from file");
		System.out.println("[8] Save DVDs to file");
		System.out.println("[9] Exit");
		System.out.println("-----------------------------");
	}
	
	public void displayDvdList(List<Dvd> dvdList) {
		int counter = 1;
		
		for(Dvd dvd : dvdList) {
			System.out.println(counter + ". " + dvd.getTitle());
			counter++;
		}
	}
	
	public int requestNumberInput(String inputName) {
		System.out.print("Enter " + inputName + ": ");
		int newValue = scanner.nextInt();
		scanner.nextLine();
		System.out.println("-----------------------------");
		
		return newValue;
	}
	
	public String requestStringInput(String valueName) {
		System.out.println("Enter the "+ valueName + ": ");
		String newValue = scanner.nextLine();
		System.out.println("-----------------------------");
		
		return newValue;
	}
	
	public void displayEditOptions() {
		System.out.println("[1] Title");
		System.out.println("[2] Release date");
		System.out.println("[3] MPAA rating");
		System.out.println("[4] Director's name");
		System.out.println("[5] Studio");
		System.out.println("[6] Your notes");
	}
	
	public void displayDvdDetails(Dvd dvd) {
		System.out.println("Title: " + dvd.getTitle());
		System.out.println("Release date: " + dvd.getReleaseDate());
		System.out.println("MPAA rating: " + dvd.getMpaaRating());
		System.out.println("Director: " + dvd.getDirectorName());
		System.out.println("Studio: " + dvd.getStudio());
		System.out.println("Notes: " + dvd.getUserNote());
	}
	
	public void displaySearchResults(List<Dvd> searchResults) {
		if (searchResults.isEmpty())
			System.out.println("No matches found.");
		else {
			System.out.println(searchResults.size() + " match(es) found:");
			displayDvdList(searchResults);
		}
	}
}
