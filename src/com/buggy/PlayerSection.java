package com.buggy;

import com.buggy.utils.FontUtils;
import com.buggy.utils.ImageUtils;

import static com.buggy.utils.ColorUtils.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerSection extends JLayeredPane {
    private static final Integer LAYER_0 = 0;
    private static final Integer LAYER_1 = 1;

    public PlayerSection() {

        /* Background */
        JPanel background = new JPanel();
        background.setBounds(0, 0, 540, 159);
        background.setBackground(PLAYER_SECTION_BACKGROUND.color());
        this.add(background, LAYER_0);

        /* Player Title */
        JLabel playerTitle = new JLabel("Detective");
        playerTitle.setHorizontalAlignment(SwingConstants.CENTER);
        playerTitle.setVerticalAlignment(SwingConstants.CENTER);
        playerTitle.setForeground(PLAYER_HEADING_TEXT.color());
        playerTitle.setFont(FontUtils.DEFAULT_FONT.deriveFont(36f));
        playerTitle.setBounds(18, 9, 223, 63);
        this.add(playerTitle, LAYER_1);

        /* Score Section */
        JLabel scoreSection = new JLabel("Score: 0");
        scoreSection.setOpaque(true);
        scoreSection.setHorizontalAlignment(SwingConstants.CENTER);
        scoreSection.setVerticalAlignment(SwingConstants.CENTER);
        scoreSection.setBackground(SCORE_BACKGROUND.color());
        scoreSection.setFont(FontUtils.DEFAULT_FONT.deriveFont(24f));
        scoreSection.setForeground(SCORE_TEXT.color());
        scoreSection.setBounds(254, 9, 265, 58);
        this.add(scoreSection, LAYER_1);

        /* Evidence Section Icons */
        JPanel evidenceSection = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        String[] evidenceNames = {"Key.png", "Fingerprint.png", "Knife.png"};
        for (String evidenceName : evidenceNames) {
            ImageIcon icon = ImageUtils.getResizedIcon("data/icons/" + evidenceName.toLowerCase(), 50, 50);
            JLabel evidenceIcon = new JLabel(icon);
            evidenceSection.add(evidenceIcon);
        }

        evidenceSection.setBounds(20, 80, 502, 67);
        evidenceSection.setBackground(EVIDENCE_ICON_BACKGROUND.color());
        this.add(evidenceSection, LAYER_1);

        /* JLayeredPane Bounds */
        this.setBounds(30, 71, 540, 159);

    }
}
