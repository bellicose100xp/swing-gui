package com.buggy;

import static com.buggy.utils.ColorUtils.*;

import com.buggy.utils.FontUtils;
import com.buggy.utils.ImageUtils;

import java.awt.*;

import javax.swing.*;

public class LocationSection extends JLayeredPane {
    private static final Integer LAYER_0 = 0;
    private static final Integer LAYER_1 = 1;

    public LocationSection() {

        /* Background */
        JPanel background = new JPanel();
        background.setBounds(0, 0, 540, 333);
        background.setBackground(LOCATION_SECTION_BACKGROUND.color());
        this.add(background, LAYER_0);

        /* Items Section Icons */
        JPanel itemsSection = new JPanel();

        // Add item icons to the frame
        String[] itemNames = {"pen.png", "shovel.png", "gun.png"};
        for (String itemName : itemNames) {
            ImageIcon icon =
                    ImageUtils.getResizedIcon("data/icons/" + itemName.toLowerCase(), 50, 50);
            JLabel itemIcon = new JLabel(icon);
            itemsSection.add(itemIcon);
        }

        itemsSection.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        itemsSection.setBounds(20, 17, 361, 64);
        itemsSection.setBackground(ITEM_ICON_BACKGROUND.color());
        this.add(itemsSection, LAYER_1);

        /* Character Section Icons */
        JPanel characterSection = new JPanel();

        // Add item icons to the frame
        String[] characters = {"nanny.png", "butler.png", "gardner.png", "man.png", "girl.png"};
        for (String character : characters) {
            ImageIcon icon =
                    ImageUtils.getResizedIcon("data/icons/" + character.toLowerCase(), 50, 50);
            JLabel itemIcon = new JLabel(icon);
            characterSection.add(itemIcon);
        }

        characterSection.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        characterSection.setBounds(20, 95, 361, 64);
        characterSection.setBackground(ITEM_ICON_BACKGROUND.color());
        this.add(characterSection, LAYER_1);

        /* Scrollable Description / Action Text / Journal Entries Area */
        JScrollPane scrollableDescriptionPane = getDescriptionScrollPane();
        this.add(scrollableDescriptionPane, LAYER_1);

        /* Journal Entries */
        ImageIcon journalIcon = ImageUtils.getResizedIcon("data/icons/journal.png", 140, 140);
        JLabel journalIconLabel = new JLabel(journalIcon);
        journalIconLabel.setBounds(381, 20, 140, 140);
        this.add(journalIconLabel, LAYER_1);

        /* Location Section JLayeredPane Bounds */
        this.setBounds(30, 240, 540, 333);
    }

    private static JScrollPane getDescriptionScrollPane() {
        JTextArea description = getDescriptionTextArea();

        // Create Scroll Pane and add description text area to scroll pane
        JScrollPane scrollableDescriptionPane = new JScrollPane();
        scrollableDescriptionPane.setBackground(ITEM_DESCRIPTION_BACKGROUND.color());
        scrollableDescriptionPane.setViewportView(description);

        // Scroll pane specific setting
        scrollableDescriptionPane.setBounds(20, 174, 502, 142);
        scrollableDescriptionPane.setBorder(BorderFactory.createEmptyBorder());
        return scrollableDescriptionPane;
    }

    private static JTextArea getDescriptionTextArea() {
        JTextArea description = new JTextArea();
        description.setText(
                """
                This is a multi-line scrollable label.
                Add as many lines as you needed.
                The text will be wrapped automatically.
                This is a multi-line scrollable label.
                Add as many lines as you needed.
                The text will be wrapped automatically.
                This is a multi-line scrollable label.
                Add as many lines as you needed.
                The text will be wrapped automatically.
                This is a multi-line scrollable label.
                Add as many lines as you needed.
                The text will be wrapped automatically.
                """);
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
}
