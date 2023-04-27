/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.DoubleLinkList;
import model.Song;
import view.MPL;

/**
 *
 * @author Kasih_175314122
 */
public class MusicPlayist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoubleLinkList list = new DoubleLinkList();        
        
        list.addFirst(new Song("Artist", "Over The Rainbow", "Over The Rainbow (Instrumental).mp3"));
        list.addFirst(new Song("Artist", "Moonlight", "01. Moonlight.mp3"));
        list.addFirst(new Song("meghan trainor", "close your eyes", "meghan trainor - close your eyes.mp3"));
        list.addLast(new Song("Tycho", "Awake", "Tycho - Awake.mp3"));
        
        MPL music = new MPL();        
        music.inputData(list);
        music.setVisible(true);        
    }
    
}
