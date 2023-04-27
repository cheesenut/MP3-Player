/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.DoubleLinkList;
import model.DoubleListnode;

/**
 *
 * @author Kasih_175314122
 */
public class MPL extends JFrame {

    private JButton nextB, prevB, playB, stopB;
    private javax.swing.JLabel title;
    private javax.swing.JLabel artist;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel time;
    private Container content;
    private DoubleListnode pointer;
    private DoubleLinkList list;
    private JFXPanel panel;
    private Media media;
    private MediaPlayer player;

    //Identified LinkList and ListNode
    public void inputData(Object data) {
        list = (DoubleLinkList) data;
        pointer = list.getHead();
    }

    public MPL() {
        panel = new JFXPanel();

        content = getContentPane();
        setTitle("Music Player");
        setBounds(400, 200, 500, 225);
        content.setLayout(null);

        //set logo
        ImageIcon imageIcon = new ImageIcon("SDL.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(90, 75, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        logo = new JLabel(imageIcon);
        logo.setBounds(10, 10, 110, 85);
        content.add(logo);
        ImageIcon iconNext = new ImageIcon("next.png");
        ImageIcon iconPrev = new ImageIcon("prev.png");
        ImageIcon iconPlay = new ImageIcon("play.png");
        ImageIcon iconStop = new ImageIcon("stop.png");
        //set title
        title = new javax.swing.JLabel();
        title.setBounds(135, 10, 200, 20);
        content.add(title);
        //set artist
        artist = new javax.swing.JLabel();
        artist.setBounds(135, 35, 200, 20);
        content.add(artist);
        
        time = new javax.swing.JLabel(" ");
        time.setBounds(135, 60, 200, 20);
        content.add(time);
        
        //Next Button
        nextB = new JButton(iconNext);
        nextB.setBounds(305, 120, 80, 40);
        nextB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton clicked = (JButton) e.getSource();
                if (pointer.getNext() != list.getHead()) {
                    //stop music
                    if (pointer.getData() != null) {
                        player.stop();
                    }
                    //mengambil data
                    pointer = pointer.getNext();
                    String artis = pointer.getData().getArtist();
                    String judul = pointer.getData().getTitle();
                    String file = pointer.getData().getFile();
                    media = new Media(new File(file).toURI().toString());
                    player = new MediaPlayer(media);

                    artist.setText(artis);
                    title.setText(judul);
                    player.play();
                    player.getOnRepeat();
                } else {
                    //stop music
                    if (pointer.getData() != null) {
                        player.stop();
                    }
                    //mengambil data
                    pointer = pointer.getNext();
                    pointer = pointer.getNext();
                    String artis = pointer.getData().getArtist();
                    String judul = pointer.getData().getTitle();
                    String file = pointer.getData().getFile();
                    media = new Media(new File(file).toURI().toString());
                    player = new MediaPlayer(media);

                    artist.setText(artis);
                    title.setText(judul);
                    player.play();
                }
            }
        }
        );

        stopB = new JButton(iconStop);
        stopB.setBounds(110, 120, 80, 40);
        stopB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JButton clicked = (JButton) ae.getSource();
                if (pointer.getData() != null) {
                    player.stop();
                   
                }
            }
        });

        playB = new JButton(iconPlay);
        playB.setBounds(205, 120, 80, 40);
        playB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JButton clicked = (JButton) ae.getSource();
                if (pointer.getNext().getPrev() != list.getHead()) {
                    //stop music
                    if (pointer.getData() != null) {
                        player.stop();
                    }
                    //mengambil data
                    pointer = pointer.getNext().getPrev();
                    String artis = pointer.getData().getArtist();
                    String judul = pointer.getData().getTitle();
                    String file = pointer.getData().getFile();
                    media = new Media(new File(file).toURI().toString());
                    player = new MediaPlayer(media);

                    artist.setText(artis);
                    title.setText(judul);
                    player.play();
                }else{
                    if (pointer.getData() != null) {
                        player.stop();
                    }
                    //mengambil data
                    pointer = pointer.getNext();
                    String artis = pointer.getData().getArtist();
                    String judul = pointer.getData().getTitle();
                    String file = pointer.getData().getFile();
                    media = new Media(new File(file).toURI().toString());
                    player = new MediaPlayer(media);

                    artist.setText(artis);
                    title.setText(judul);
                    player.play();
                }
            }
        });
        //Previous Button
        prevB = new JButton(iconPrev);
        prevB.setBounds(10, 120, 80, 40); 
        prevB.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                JButton clicked = (JButton) e.getSource();

                if (pointer.getPrev() != list.getHead()) {
                    if (pointer.getData() != null) {
                        player.stop();
                    }
                    pointer = pointer.getPrev();
                    String artis = pointer.getData().getArtist();
                    String judul = pointer.getData().getTitle();
                    String file = pointer.getData().getFile();
                    media = new Media(new File(file).toURI().toString());
                    player = new MediaPlayer(media);

                    artist.setText(artis);
                    title.setText(judul);
                    player.play();
                } else {
                    if (pointer.getData() != null) {
                        player.stop();
                    }
                    pointer = pointer.getPrev();
                    pointer = pointer.getPrev();
                    String artis = pointer.getData().getArtist();
                    String judul = pointer.getData().getTitle();
                    String file = pointer.getData().getFile();
                    media = new Media(new File(file).toURI().toString());
                    player = new MediaPlayer(media);

                    artist.setText(artis);
                    title.setText(judul);
                    player.play();
                }
            }
        }
        );
        content.add(nextB);
        content.add(stopB);
        content.add(playB);
        content.add(prevB);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
