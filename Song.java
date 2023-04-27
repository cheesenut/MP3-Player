/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
   * @author Kasih_175314122
 */
public class Song {

    private String artist;
    private String title;
    private String file;
    
    Song(){
        
    }
    public Song(String artist, String title, String file){
        this.artist = artist;
        this.title = title;
        this.file = file;
    }
    
    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Song)) {
            return false;
        }
        Song song = (Song) other;
        return song.getTitle().equals(title)
                && song.getArtist().equals(artist);
    }

    @Override
    public String toString() {
        return String.format("\"%s\" (%s) by %s on \"%s\"", title, artist);
    }
}
