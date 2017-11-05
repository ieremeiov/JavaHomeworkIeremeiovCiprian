/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cip
 */
public class DataSource {

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:"
            + "C:\\Users\\Cip\\Documents\\NetBeansProjects\\JavaHomeworkIeremeiovCiprian\\MusicDB\\" + DB_NAME;

    public static final String DOT = ".";
    public static final String COMMA = ", ";
    public static final String EQUALS = " = ";
    public static final String INNER_JOIN = " INNER JOIN ";
    public static final String ON = " ON ";
    public static final String WHERE = " WHERE ";
    public static final String ORDER_BY = " ORDER BY ";
    public static final String NOCASE = " COLLATE NOCASE ";
    //===============================================================================================

//    public static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONGS_ID = 1;
    public static final int INDEX_SONGS_TRACK = 2;
    public static final int INDEX_SONGS_TITLE = 3;
    public static final int INDEX_SONGS_ALBUM = 4;

    //===============================================================================================
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    //===============================================================================================
    public static final String QUERY_ALBUMS_BY_ARTISTS_START
            = "SELECT " + TABLE_ALBUMS + DOT + COLUMN_ALBUM_NAME + " FROM " + TABLE_ALBUMS
            + INNER_JOIN + TABLE_ARTISTS + ON + TABLE_ALBUMS + DOT + COLUMN_ALBUM_ARTIST
            + EQUALS + TABLE_ARTISTS + DOT + COLUMN_ARTIST_ID + WHERE + TABLE_ARTISTS + DOT + COLUMN_ARTIST_NAME + EQUALS + "'";
    public static final String QUERY_ALBUMS_BY_ARTISTS_SORT = ORDER_BY + TABLE_ALBUMS + DOT + COLUMN_ALBUM_NAME
            + NOCASE;

    public static final String QUERY_ARTIST_FOR_SONG_START = "SELECT " + TABLE_ARTISTS + DOT + COLUMN_ARTIST_NAME + COMMA
            + TABLE_ALBUMS + DOT + COLUMN_ALBUM_NAME + COMMA + TABLE_SONGS + DOT + COLUMN_SONG_TRACK + " FROM " + TABLE_SONGS
            + INNER_JOIN + TABLE_ALBUMS + ON + TABLE_SONGS + DOT + COLUMN_SONG_ALBUM + EQUALS + TABLE_ALBUMS + DOT
            + COLUMN_ALBUM_ID + INNER_JOIN + TABLE_ARTISTS + ON + TABLE_ALBUMS + DOT + COLUMN_ALBUM_ARTIST + EQUALS
            + TABLE_ARTISTS + DOT + COLUMN_ARTIST_ID + WHERE + TABLE_SONGS + DOT + COLUMN_SONG_TITLE + EQUALS + "'";
    public static final String QUERY_ARTIST_FOR_SONG_SORT = ORDER_BY + TABLE_ARTISTS + DOT + COLUMN_ARTIST_NAME + COMMA
            + TABLE_ALBUMS + DOT + COLUMN_ALBUM_NAME + NOCASE;

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW + " AS SELECT "
            + TABLE_ARTISTS + DOT + COLUMN_ARTIST_NAME + COMMA + TABLE_ALBUMS + DOT + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM
            + COMMA + TABLE_SONGS + DOT + COLUMN_SONG_TRACK + COMMA + TABLE_SONGS + DOT + COLUMN_SONG_TITLE + " FROM " + TABLE_SONGS
            + INNER_JOIN + TABLE_ALBUMS + ON + TABLE_SONGS + DOT + COLUMN_SONG_ALBUM + EQUALS + TABLE_ALBUMS + DOT
            + COLUMN_ALBUM_ID + INNER_JOIN + TABLE_ARTISTS + ON + TABLE_ALBUMS + DOT + COLUMN_ALBUM_ARTIST + EQUALS
            + TABLE_ARTISTS + DOT + COLUMN_ARTIST_ID + ORDER_BY + TABLE_ARTISTS + DOT + COLUMN_ARTIST_NAME + COMMA
            + TABLE_ALBUMS + DOT + COLUMN_ALBUM_NAME + COMMA + TABLE_SONGS + DOT + COLUMN_SONG_TRACK;

    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME + COMMA + COLUMN_SONG_ALBUM + COMMA
            + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + WHERE + COLUMN_SONG_TITLE + EQUALS + "'";

    // ? is a single value
    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + COMMA + COLUMN_SONG_ALBUM + COMMA
            + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + WHERE + COLUMN_SONG_TITLE + EQUALS + "?";
    //===============================================================================================
    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + "(" + COLUMN_ARTIST_NAME + ")"
            + "VALUES(?)";
    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS + "(" + COLUMN_ALBUM_NAME + COMMA
            + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";
    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS + "(" + COLUMN_SONG_TRACK + COMMA + COLUMN_SONG_TITLE
            + COMMA + COLUMN_SONG_ALBUM + ") VALUES(?, ?, ?)";
    // === == == == === === == == == === == == == === == === === = === === === === == == == == == == == == === 
    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " + TABLE_ARTISTS + WHERE
            + COLUMN_ARTIST_NAME + EQUALS + "?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " + TABLE_ALBUMS + WHERE
            + COLUMN_ALBUM_ARTIST + EQUALS + "?";
    //===============================================================================================

    private Connection connection;
    private PreparedStatement querySongInfoView;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    public boolean open() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = connection.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);

            insertIntoArtists = connection.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = connection.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = connection.prepareStatement(INSERT_SONGS);

            queryArtist = connection.prepareStatement(QUERY_ARTIST);
            queryAlbum = connection.prepareStatement(QUERY_ALBUM);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if (querySongInfoView != null) {
                querySongInfoView.close();
            }
            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }
            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if (insertIntoSongs != null) {
                insertIntoArtists.close();
            }
            if (queryArtist != null) {
                queryArtist.close();
            }
            if (queryAlbum != null) {
                queryAlbum.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close connection " + e.getMessage());
        }
    }

    public List<Artist> queryArtists(int sortOrder) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");

        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC ");
            } else {
                sb.append("ASC ");
            }
        }

        try (Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(sb.toString())) {

            List<Artist> artists = new ArrayList<>();

            while (results.next()) {
                Artist artist = new Artist();
//                artist.setId(results.getInt(COLUMN_ARTIST_ID));
//                artist.setName(results.getString(COLUMN_ARTIST_NAME));
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {

//        StringBuilder sb = new StringBuilder(" SELECT ");
//        sb.append(TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME);
//        sb.append(" FROM " + TABLE_ALBUMS);
//        sb.append("\n INNER JOIN " + TABLE_ARTISTS);
//        sb.append(" ON " + TABLE_ALBUMS);
//        sb.append("." + COLUMN_ALBUM_ARTIST);
//        sb.append(" = ");
//        sb.append(TABLE_ARTISTS + "." + COLUMN_ARTIST_ID);
//        sb.append("\n WHERE ");
//        sb.append(TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME);
//        sb.append(" = '");
//        sb.append(artistName + "' ");
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_BY_ARTISTS_START);
        sb.append(artistName);
        sb.append("'");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUMS_BY_ARTISTS_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC ");
            } else {
                sb.append("ASC ");
            }
        }

        System.out.println("SQL Statement: \n" + sb.toString());

        try (Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(sb.toString())) {

            List<String> albums = new ArrayList<>();

            while (results.next()) {
                albums.add(results.getString(1));
            }

            return albums;

        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songName, int sortOrder) {

        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);

        sb.append(songName);
        sb.append("'");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ARTIST_FOR_SONG_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        System.out.println("SQL Statement: " + sb.toString());

        try (Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(sb.toString())) {

            List<SongArtist> songArtists = new ArrayList<>();

            while (results.next()) {
                SongArtist songArtist = new SongArtist();

                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));

                songArtists.add(songArtist);
            }

            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed... " + e.getMessage());
            return null;
        }

    }

    public void querySongsMetadata() {

        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();
            int numColums = meta.getColumnCount();

            for (int i = 1; i <= numColums; i++) {
                System.out.format("Column %d in the songs table is named %s\n", i, meta.getColumnName(i));
            }

        } catch (SQLException e) {
            System.out.println("Query failed... " + e.getMessage());
        }

    }

    public int getCount(String table) {

//        String sql = "SELECT COUNT(*) AS count, MIN(_id) AS min_id FROM " + table;
        String sql = "SELECT COUNT(*) AS count FROM " + table;

        try (Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery(sql)) {

//            int count = results.getInt(1);
//            int min = results.getInt(2);
            int count = results.getInt("count");
//            int min = results.getInt("min_id");

            System.out.format("Count = %d\n", count);

            return count;
        } catch (SQLException e) {
            System.out.println("Query failed... " + e.getMessage());
            return -1;
        }

    }

    public boolean createViewForSongArtists() {

        try (Statement statement = connection.createStatement()) {

            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            System.out.println(CREATE_ARTIST_FOR_SONG_VIEW);
            System.out.println("View created");

            return true;

        } catch (SQLException e) {
            System.out.println("Create View failed... " + e.getMessage());
            return false;
        }

    }

    public List<SongArtist> querySongInfoView(String title) {

        try {
            querySongInfoView.setString(1, title);
            ResultSet results = querySongInfoView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();

            while (results.next()) {

                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));

                songArtists.add(songArtist);

            }

            return songArtists;

        } catch (SQLException e) {
            System.out.println("Query failed... " + e.getMessage());
            return null;
        }

    }

    private int insertArtist(String name) throws SQLException {

        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();

        if (results.next()) {
            return results.getInt(1);
        } else {
            // Insert the artist because it is not in the table
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist!");
            }

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist!");
            }

        }

    }

    private int insertAlbum(String name, int artistId) throws SQLException {

        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();

        if (results.next()) {
            return results.getInt(1);
        } else {
            // Insert the album because it is not in the table
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album!");
            }

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album!");
            }

        }

    }

    public void insertSong(String title, String artist, String album, int track) {

        try {

            // we make a Transaction: will Commit manually later
            connection.setAutoCommit(false);

            // if we use a Savepoint
            // Savepoint save = connection.setSavepoint();
            // we can later call connection.rollback(save); 
            int artistId = insertArtist(artist);
            int albumId = insertAlbum(album, artistId);

            // if first argument is too large, throws ArrayIndexOutOfBounds exception
            // should perform rollback, because we will catch all Exceptions
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            int affectedRows = insertIntoSongs.executeUpdate();

            if (affectedRows == 1) {
                connection.commit();
            } else {
                throw new SQLException("The song insertion failed!");
            }
            // !!!
            // will catch all exceptions (like .setInt, setString methods ArrayIndexOutOfBounds)
        } catch (Exception e) {
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing Rollback!");
                connection.rollback();
            } catch (SQLException e2) {
                System.out.println("Oh boy! Cannot rollback!!! " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default committing behaviour! ");
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
        }

    }

//    public List<Artist> queryArtists() {
//
//        Statement statement = null;
//        ResultSet results = null;
//
//        try {
//            statement = connection.createStatement();
//            results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);
//
//            List<Artist> artists = new ArrayList<>();
//
//            while (results.next()) {
//                Artist artist = new Artist();
//                artist.setId(results.getInt(COLUMN_ARTIST_ID));
//                artist.setName(results.getString(COLUMN_ARTIST_NAME));
//                artists.add(artist);
//            }
//
//            return artists;
//
//        } catch (SQLException e) {
//            System.out.println("Query failed " + e.getMessage());
//            return null;
//        } finally {
//            try {
//                if (results != null) {
//                    results.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Error closing ResultSet: " + e.getMessage());
//            }
//            try {
//                if (statement != null) {
//                    statement.close();
//                }
//            } catch (SQLException e) {
//                System.out.println("Error closing Statement: " + e.getMessage());
//            }
//        }
//    }
}
