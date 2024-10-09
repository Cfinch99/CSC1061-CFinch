
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Main {
	static MyDoubleLinkedList<Song> playlist = new MyDoubleLinkedList<>();
	public static void main(String[] args) {
		String str = "run";
		String artName = "";
		String songName = "";
		Scanner in = new Scanner(System.in);
		
		//command list for user
		System.out.println("*Playlist Manager\n Commands: \nadd \nremove "
				+ "\ncount \nplay \nshuffle \nreverse \nquit");
		
		while(!str.equals("quit")) {
			str = in.nextLine();
			
			if(str.equals("quit")) {
				System.out.print(quitter());
			}
			
			if(str.equals("add")) {
				System.out.println("Enter artist name:");
				artName = in.nextLine();
				System.out.println("Enter song name:");
				songName = in.nextLine();
				Song newSong = new Song(artName, songName);
				playlist.add(newSong);
				}
			
			if(str.equals("remove")) {
				System.out.println("Enter artist: ");
				artName = in.nextLine();
				System.out.println("Enter song name:");
				songName = in.nextLine();
				
				for(Song song:playlist) {
					if(song.getArtist().equals(artName) && song.getTitle().equals(songName)) {
						playlist.remove(song);
					}
				}
			}
			
			if(str.equals("count")) {
				System.out.println(playlist.size());
			}
			
			if(str.equals("play")) {
				for(Song song:playlist) {
					System.out.println(song.getArtist() + " - " + song.getTitle());
				}
				
			}
			if(str.equals("shuffle")) {
				playlist = shuffle(playlist);
			}
			
			if(str.equals("reverse")) {
				playlist = playlist.reverse();
			}
			
		}

	}
	public static String quitter() {
		return "Goodbye!";
	}
	public static MyDoubleLinkedList<Song> shuffle(MyDoubleLinkedList<Song> playlist) {
		// for each song in playlist, get random index, move that song from index to the end
		int index;
		Random rand = new Random();
		for(Song song: playlist) {
			index = rand.nextInt(0, playlist.size());
			Song ShuffSong = playlist.get(index);
			playlist.remove(index);
			playlist.add(ShuffSong);
		}
		return playlist;
	}
	

}
