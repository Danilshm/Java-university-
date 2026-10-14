package songcomparator;


public class PlayListApp {

    public static void main(String[] arg) {

    	//Create a new PlayList object
        var playlist = new PlayList("My Favourites");

        //add some new Song objects
        playlist.addSong( new Song("Only Girl (In The World)", 235, "Rhianna") );
        playlist.addSong( new Song("Thinking of Me", 206, "Olly Murs") );
        playlist.addSong( new Song("Raise Your Glass", 202,"P!nk") );
        playlist.addSong( new Song("Beat it", 150,"M Jackson") );        
        playlist.addSong( new Song("Bad", 210,"M Jackson") );
        
      
        System.out.println(playlist.getTrackListings());   
        
        
        //ADD CODE HERE...
        
               
    }
}
