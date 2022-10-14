package oops_music_player;


import java.util.*;

public class Main {
	private static ArrayList<Album> albums = new ArrayList<>();
public static void main(String args[]) {
	
	
	
	Album album= new Album("Album1","ac/dc");
	
	album.addSong("tnt", 4.5);
	album.addSong("Highway to hell", 3.5);
	album.addSong("ThunderStruck", 5.0);
	
        albums.add(album);

	 album= new Album("Album2","Eminem");
	
	album.addSong("rap god", 4.5);
	album.addSong("mocking bird", 3.5);
	album.addSong("not afread", 5.0);
	
	albums.add(album);
	
	LinkedList<Song> playList_1= new LinkedList<>();
	
	albums.get(0).addToPlayList("tnt", playList_1);
	albums.get(0).addToPlayList("Highway to hell", playList_1);
	albums.get(1).addToPlayList("ThunderStruck", playList_1);
	albums.get(1).addToPlayList("rap god", playList_1);
	
	play(playList_1);
}
private static void play(LinkedList<Song> playlist) {
	Scanner sc = new Scanner(System.in);
	boolean quit = false;
	boolean forword = true;
	ListIterator<Song> listIterator = playlist.listIterator();
	
	if (playlist.size()==0) {
		System.out.println("this playlist have no song/s");
	}
	else {
		System.out.println("now playing"+listIterator.next().toString());
		printMenu();
	}
	while(!quit) {
		int action = sc.nextInt();
		sc.nextLine();
		
		switch(action) {
		case 0: 
			System.out.println("playlist complete");
			quit= true;
			break;
			
		case 1:
			if(!forword) {
				if(listIterator.hasNext()) {
					listIterator.next();
				}
				forword= true;
			}
		if (listIterator.hasNext()) {
			System.out.println("now playing "+listIterator.next().toString());
		}else {
			System.out.println("riched to the end of the playlist, no song to play");
			forword= false;
		}
		break;
		case 2:
			if(forword) {
				if(listIterator.hasPrevious()) {
					System.out.println("now playing"+listIterator.previous().toString());
				}else {
					System.out.println("we are playing the first song");
					forword= false;
				}
				}
				break;
				case 3:
					if (forword) {
						if(listIterator.hasPrevious()) {
							System.out.println("now playing "+listIterator.previous().toString());
							forword= false;
						}else {
							System.out.println("we are at the start of the list");
						}
					}
					else {
						if (listIterator.hasNext()) {
							System.out.println("now playing"+listIterator.next().toString());
						forword= true;
						}else {
							System.out.println("we are at the end of the list");
						}
					}
					
					break;
				case 4:
					printList(playlist);
					break;
				case 5:
					printMenu();
					break;
				case 6:
					if(playlist.size()>0) {
						listIterator.remove();
						if(listIterator.hasNext()) {
							System.out.println("now playing "+listIterator.next().toString());
						//forword= true;
						}else {
							if (listIterator.hasPrevious()) {
								System.out.println("now palying "+listIterator.previous().toString());
							}
						}
					}
					break;
			}		
			}
		
	}


public static void printMenu() {
	
	System.out.println("avialable options\n press ");
	System.out.println("0- to quit\n"+
	                    "1-to play next song\n"+
	                    "2-to play privious song\n"+
	                    "3-to replay current song\n"+
	                    "4-to list of all song/s\n"+
	                    "5-to print the avialable options\n"+
	                    "6-to delete current song from our playlist\n");
}
private static void printList(LinkedList<Song>playList) {
	Iterator<Song> iterator = playList.iterator();
	System.out.println("+++++++++++++++++++++++++");
	while(iterator.hasNext()) {
		System.out.println(iterator.next());
	}
	System.out.println("+++++++++++++++++++++++++");
}
}
