package com.utility;

import com.model.MpaaRating;
import com.model.Dvd;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DvdDaoImpl implements DvdDao {
	private List<Dvd> allDvds = new ArrayList<>();
	
	
	@Override
	public List<Dvd> getDvds() {
		return allDvds;
	}
	
	
	@Override
	public void createDvd(
			String title, 
			LocalDate releaseDate,
			MpaaRating mpaaRating, 
			String directorName,
			String studio, 
			String userNote
			) {
		Dvd newDvd = new Dvd(title, releaseDate, mpaaRating, directorName, studio, userNote);
		allDvds.add(newDvd);

		System.out.println(this.allDvds);
	}
	
	
	@Override
	public void destroyDvd(int index) {
		allDvds.remove(index);

	}
	
	
	@Override
	public void updateDvd(int index, int fieldChoice, String newValue) {
		Dvd dvd = allDvds.get(index);
	
		switch (fieldChoice) {
		case 1:
			// title
			dvd.setTitle(newValue);
			break;
		case 2:
			// release date	
			dvd.setReleaseDate(LocalDate.parse(newValue));
			break;
		case 3:
			// mpaa
			dvd.setMpaaRating(MpaaRating.valueOf(newValue));
			break;
		case 4:
			// director's name
			dvd.setDirectorName(newValue);
			break;
		case 5:
			// studio
			dvd.setStudio(newValue);
			break;
		case 6:
			// notes
			dvd.setUserNote(newValue);
		}

	}
	
	
	@Override
	public List<Dvd> searchDvds(String searchPhrase) {
		List<Dvd> searchResults = new ArrayList<>();
		
		for(Dvd dvd : allDvds) {
			if (
				dvd.getTitle().toUpperCase().contains(searchPhrase.toUpperCase())
				|| dvd.getDirectorName().toUpperCase().contains(searchPhrase.toUpperCase())
				|| dvd.getStudio().toUpperCase().contains(searchPhrase.toUpperCase())
				|| dvd.getUserNote().toUpperCase().contains(searchPhrase.toUpperCase())
			)
				searchResults.add(dvd);
		}
			
		return searchResults;
	}
	
	
	@Override
	public void saveDvds() {
		try {
			ObjectOutputStream dvdOutputStream = new ObjectOutputStream(new FileOutputStream("dvds.txt"));
			dvdOutputStream.writeObject(allDvds);
			dvdOutputStream.close();
			
			System.out.println("DVDs saved.");
		} 
		catch (IOException ioe) {
			System.out.println("File not found.");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void loadDvds() {
		try {
			ObjectInputStream dvdInputStream = new ObjectInputStream(new FileInputStream("dvds.txt"));
			allDvds = (ArrayList<Dvd>) dvdInputStream.readObject();
			dvdInputStream.close();
			
			System.out.println("DVDs loaded.");
		} 
		catch (IOException ioe) {
			// TODO Auto-generated catch block
			System.out.println("No such file found.");
		} catch (ClassNotFoundException cnfe) {
			// TODO Auto-generated catch block
			System.out.println("ArrayList not found.");
		}
	}
}
