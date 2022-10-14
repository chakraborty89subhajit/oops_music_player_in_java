package oops_music_player;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
private String name;
private String artist;
private ArrayList<Song> songs;


public Album(String name, String artist) {
	super();
	this.name = name;
	this.artist = artist;
	this.songs = new ArrayList<Song>();
}

public Album() {
	
}

public Song findSong(String title) {
	for(Song checkedSong : songs) {
		if(checkedSong.getTitle().equals(title)) return checkedSong;
	}
	return null;
}

public boolean addSong(String title, double duration) {
	if(findSong(title)==null) {
		songs.add(new Song(title,duration));
		//System.out.println(title + "successfully added to the list");
		return true;
	}
	else {
	//	System.out.println("song with "+ title +"already present in the list");
		return false;
	}
}

public boolean addToPayList(int trackNumber,LinkedList<Song>PlayList) {
	int index= trackNumber-1;
	if (index >0 && index <= this.songs.size()) {
		PlayList.add(this.songs.get(index));
		return true;
	}
//	System.out.println("this album does not have the song of track number "+trackNumber);
	
	return false;
	
}
public boolean addToPlayList(String title, LinkedList<Song> PlayList) {
	for(Song checkedSong : this.songs) {
	if(checkedSong.getTitle().equals(title)) {
		PlayList.add(checkedSong);
		return true;
	}	
	}
	//System.out.println("there is no such song in  album");
	return false;
}
}