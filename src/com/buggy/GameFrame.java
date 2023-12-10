package com.buggy;

import static com.buggy.utils.ColorUtils.*;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame() {
        /* Title Bar Panel */
        TitlePanel titlePanel = new TitlePanel();
        this.add(titlePanel);

        /* Player Section */
        PlayerSection playerSection = new PlayerSection();
        this.add(playerSection);

        /* Location Section */
        LocationSection locationSection = new LocationSection();
        this.add(locationSection);

        /* Location Description Section */
        LocationDescriptionSection locationDescriptionSection = new LocationDescriptionSection();
        this.add(locationDescriptionSection);

        /* Map Section */
        MapSection mapSection = new MapSection(locationDescriptionSection);
        this.add(mapSection);

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
