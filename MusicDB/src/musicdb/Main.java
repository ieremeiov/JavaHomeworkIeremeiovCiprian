/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicdb;

import java.util.List;
import java.util.Scanner;
import model.Artist;
import model.DataSource;
import model.SongArtist;

/**
 *
 * @author Cip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DataSource datasource = new DataSource();

        if (!datasource.open()) {
            System.out.println("Can't open DataSource");
            return;
        }

        // =================================================================================================
        List<Artist> artists = datasource.queryArtists(DataSource.ORDER_BY_ASC);

        if (artists == null) {
            System.out.println("No artists");
            return;
        }

        for (Artist artist : artists) {
            System.out.println("ID: " + artist.getId() + ", Name: " + artist.getName());
        }

        // =================================================================================================
        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Pink Floyd", DataSource.ORDER_BY_ASC);

        for (String album : albumsForArtist) {
            System.out.println(album);
        }

        // =================================================================================================
//        List<SongArtist> songArtists = datasource.queryArtistsForSong("She\''s On Fire", DataSource.ORDER_BY_ASC);
        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", DataSource.ORDER_BY_ASC);

        if (songArtists == null) {
            System.out.println("Couldn't find the artist for the song ");
            return;
        }

        for (SongArtist artist : songArtists) {
            System.out.println("\nArtist name = " + artist.getArtistName()
                    + " \nAlbum name = " + artist.getAlbumName()
                    + " \nTrack = " + artist.getTrack());
        }

        // =================================================================================================
        datasource.querySongsMetadata();

        int count = datasource.getCount(DataSource.TABLE_SONGS);
        //  System.out.println("Number of songs is: " + count);

        // =================================================================================================
        // will create the view if it doesn not exist
        datasource.createViewForSongArtists();

        // =================================================================================================
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a Song Title: ");
//        String title = scanner.nextLine();
//        
//        songArtists = datasource.querySongInfoView(title);
//
//        // use .isEmpty() is a better way of checking
//        if (songArtists.isEmpty()) {
//            System.out.println("Couldn't find the artist for the song");
//            return;
//        }
//        for (SongArtist artist : songArtists) {
//            System.out.println("   <<<< FROM VIEW >>>>  Artist name: " + artist.getArtistName() + "\n\t\t\tAlbum name: "
//                    + artist.getAlbumName() + "\n\t\t\tTrack number: " + artist.getTrack());
//        }
        // =================================================================================================
        datasource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);
        datasource.insertSong("Like A Rolling Stone", "Bob Dylan", "Bob Dylan's Greatest Hits", 5);
        // =================================================================================================
        datasource.close();

    }

}
