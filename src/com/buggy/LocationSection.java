package com.buggy;

import static com.buggy.utils.ColorUtils.*;

import com.buggy.entity.Character;
import com.buggy.entity.Item;
import com.buggy.utils.FontUtils;
import com.buggy.utils.ImageUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class LocationSection extends JLayeredPane {
    private static final Integer LAYER_0 = 0;
    private static final Integer LAYER_1 = 1;
    private PlayerSection playerSection;
    private List<Item> items;
    private JPanel itemsSection;
    private List<Character> characters;
    private JPanel getCharacterSection;
    private JPanel characterSection;
    private JTextArea descriptionTextArea;

    public LocationSection(PlayerSection playerSection) {
        /* Get a reference to player section */
        this.playerSection = playerSection;

        // Initialize items array
        items = new ArrayList<>();

        /* Background */
        JPanel background = new JPanel();
        background.setBounds(0, 0, 540, 333);
        background.setBackground(LOCATION_SECTION_BACKGROUND.color());
        this.add(background, LAYER_0);

        /* Items Section Icons */
        itemsSection = new JPanel();
        itemsSection.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        itemsSection.setBounds(20, 17, 361, 64);
        itemsSection.setBackground(ITEM_ICON_BACKGROUND.color());

        // Add all items to the items list
        // Ideally this should be per location, but for testing purposes,
        // we're adding all available items here
        items.addAll(Item.itemsMap.values());

        // Render initial icons for the items in the items section
        renderItemSection(itemsSection, items);
        this.add(itemsSection, LAYER_1);

        /* Character Section */
        characterSection = createCharacterSection();
        this.add(characterSection, LAYER_1);

        /* Scrollable Description / Action Text / Journal Entries Area */
        JScrollPane scrollableDescriptionPane = getDescriptionScrollPane();
        this.add(scrollableDescriptionPane, LAYER_1);

        /* Journal Entries */
        ImageIcon journalIcon = ImageUtils.getResizedIcon("data/icons/journal.png", 140, 140);
        JLabel journalIconLabel = new JLabel(journalIcon);
        journalIconLabel.setToolTipText("Evidence Journal");
        journalIconLabel.setBounds(381, 20, 140, 140);
        journalIconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showJournalEntries();
            }
        });
        this.add(journalIconLabel, LAYER_1);

        /* Location Section JLayeredPane Bounds */
        this.setBounds(30, 240, 540, 333);
    }

    private JPanel createCharacterSection() {
        JPanel characterSection = new JPanel();
        characterSection.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        characterSection.setBounds(20, 95, 361, 64);
        characterSection.setBackground(ITEM_ICON_BACKGROUND.color());

        // Add character icons to the frame
        renderCharacterSection(characterSection);

        return characterSection;
    }

    private void renderCharacterSection(JPanel characterSection) {
        for (Character character : Character.characterMap.values()) {
            ImageIcon icon = ImageUtils.getResizedIcon("data/icons/" + character.getFilename().toLowerCase(), 50, 50);
            JLabel characterIconLabel = new JLabel(icon);
            characterIconLabel.setToolTipText(character.getName());
            characterSection.add(characterIconLabel);

            characterIconLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        String dialogue = character.getDialogue();
                        descriptionTextArea.setText(dialogue);
                    } else {
                        String characterDescription = character.getDescription();
                        descriptionTextArea.setText(characterDescription);
                    }
                }
            });
        }
    }

    private void showJournalEntries() {
        int idx = 1;
        descriptionTextArea.setText("");
        for (Item evidence : playerSection.getEvidenceBag()) {
            descriptionTextArea.append(idx++ + ". " + evidence.getName() + " - " + evidence.getDescription() + "\n");
        }
    }

    private void renderItemSection(JPanel itemsSection, List<Item> items) {
        clearPanel(itemsSection);
        for (Item item : items) {
            ImageIcon icon = ImageUtils.getResizedIcon("data/icons/" + item.getFilename().toLowerCase(), 50, 50);
            JLabel label = new JLabel(icon);
            label.setToolTipText(item.getName());
            // Mouse click listener
            // Single Click: show description
            // Double Click: add item to evidence bag and remove from location
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        playerSection.addItemToEvidenceBag(item);
                        removeItemsFromLocation(item);
                        descriptionTextArea.setText(item.getName() + " added to evidence bag");
                    } else {
                        String itemDescription = item.getDescription();
                        descriptionTextArea.setText(itemDescription);
                    }
                }
            });
            itemsSection.add(label);
        }
    }

    public void removeItemsFromLocation(Item item) {
        items.remove(item);
        renderItemSection(itemsSection, items);
    }

    public void addItemToLocation(Item item) {
        items.add(item);
        renderItemSection(itemsSection, items);
    }

    public void clearPanel(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    private JScrollPane getDescriptionScrollPane() {
        descriptionTextArea = createDescriptionTextArea();

        // Create Scroll Pane and add description text area to scroll pane
        JScrollPane scrollableDescriptionPane = new JScrollPane();
        scrollableDescriptionPane.setBackground(ITEM_DESCRIPTION_BACKGROUND.color());
        scrollableDescriptionPane.setViewportView(descriptionTextArea);

        // Scroll pane specific setting
        scrollableDescriptionPane.setBounds(20, 174, 502, 142);
        scrollableDescriptionPane.setBorder(BorderFactory.createEmptyBorder());
        return scrollableDescriptionPane;
    }

    private JTextArea createDescriptionTextArea() {
        JTextArea description = new JTextArea();
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setEditable(false);
        description.setBackground(ITEM_DESCRIPTION_BACKGROUND.color());
        description.setForeground(ITEM_TEXT.color());
        description.setFont(FontUtils.DEFAULT_FONT.deriveFont(16f));
        int padding = 10;
        description.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        description.setBounds(5, 5, 502, 142);
        return description;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(JTextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }
}


