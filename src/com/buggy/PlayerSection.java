package com.buggy;

import com.buggy.entity.Item;
import com.buggy.utils.FontUtils;
import com.buggy.utils.ImageUtils;

import static com.buggy.utils.ColorUtils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PlayerSection extends JLayeredPane {
    private static final Integer LAYER_0 = 0;
    private static final Integer LAYER_1 = 1;
    private List<Item> evidenceBag;
    private JPanel evidenceSection;
    private LocationSection locationSection;
    private JLabel scoreSection;
    private int score;

    public PlayerSection() {
        // Initialize evidence bag
        evidenceBag = new ArrayList<>();

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
        scoreSection = new JLabel("Score: " + score);
        scoreSection.setOpaque(true);
        scoreSection.setHorizontalAlignment(SwingConstants.CENTER);
        scoreSection.setVerticalAlignment(SwingConstants.CENTER);
        scoreSection.setBackground(SCORE_BACKGROUND.color());
        scoreSection.setFont(FontUtils.DEFAULT_FONT.deriveFont(24f));
        scoreSection.setForeground(SCORE_TEXT.color());
        scoreSection.setBounds(254, 9, 265, 58);
        this.add(scoreSection, LAYER_1);

        /* Evidence Section Icons */
        evidenceSection = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        // Initial items that player carries when the game starts
        renderEvidenceSection();
        evidenceSection.setBounds(20, 80, 502, 67);
        evidenceSection.setBackground(EVIDENCE_ICON_BACKGROUND.color());
        this.add(evidenceSection, LAYER_1);

        /* JLayeredPane Bounds */
        this.setBounds(30, 71, 540, 159);
    }

    private void renderEvidenceSection() {
        /* Remove any existing content */
        clearIconsFromEvidenceSection();

        /* Add content from evidence bag */
        for (Item evidence : evidenceBag) {
            ImageIcon icon =
                    ImageUtils.getResizedIcon("data/icons/" + evidence.getFilename(), 50, 50);
            JLabel evidenceIcon = new JLabel(icon);
            evidenceIcon.setToolTipText(evidence.getName());

            evidenceIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        locationSection.addItemToLocation(evidence);
                        removeItemFromEvidenceBag(evidence);
                        locationSection.getDescriptionTextArea().setText(
                                evidence.getName() + " removed to evidence bag");
                    } else {
                        String itemDescription = evidence.getDescription();
                        locationSection.getDescriptionTextArea().setText(itemDescription);
                    }
                }
            });
            evidenceSection.add(evidenceIcon);
        }
    }

    public void addItemToEvidenceBag(Item item) {
        evidenceBag.add(item);
        renderEvidenceSection();
    }

    private void removeItemFromEvidenceBag(Item item) {
        evidenceBag.remove(item);
        renderEvidenceSection();
    }

    public void clearIconsFromEvidenceSection() {
        evidenceSection.removeAll();
        evidenceSection.revalidate();
        evidenceSection.repaint();
    }

    public LocationSection getLocationSection() {
        return locationSection;
    }

    public void setLocationSection(LocationSection locationSection) {
        this.locationSection = locationSection;
    }

    public List<Item> getEvidenceBag() {
        return evidenceBag;
    }

    public void setEvidenceBag(List<Item> evidenceBag) {
        this.evidenceBag = evidenceBag;
    }

    public void incrementScore(int value) {
        score += value;
        scoreSection.setText("Score: " + score);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
