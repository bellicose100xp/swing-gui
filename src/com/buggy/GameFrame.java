package com.buggy;

import static com.buggy.utils.ColorUtils.*;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        /* Title Bar Panel */
        TitlePanel titlePanel = new TitlePanel();
        this.add(titlePanel);

        /* Player Section */
        JLayeredPane playerSection = new PlayerSection();
        this.add(playerSection);

        /* Location Section */
        JLayeredPane locationSection = new LocationSection();
        this.add(locationSection);

        /* Map Section */
        MapSection mapSection = new MapSection();
        this.add(mapSection);

        /* Location Description Section */
        JPanel locationDescriptionSection = new LocationDescriptionSection();
        this.add(locationDescriptionSection);

        /* Game Frame Specific Settings */
        this.setTitle("Search For A Killer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 625);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(GAME_BACKGROUND.color());
    }
}
