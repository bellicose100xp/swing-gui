package com.buggy;

import com.buggy.utils.FontUtils;

import javax.swing.*;

import static com.buggy.utils.ColorUtils.*;

public class LocationDescriptionSection extends JPanel {
    private JTextArea locationDescriptionTextArea;
    public LocationDescriptionSection() {
        locationDescriptionTextArea = new JTextArea();
        locationDescriptionTextArea.setLineWrap(true);
        locationDescriptionTextArea.setLineWrap(true);
        locationDescriptionTextArea.setWrapStyleWord(true);
        locationDescriptionTextArea.setEditable(false);
        locationDescriptionTextArea.setBackground(LOCATION_DESCRIPTION_BACKGROUND.color());
        locationDescriptionTextArea.setForeground(LOCATION_DESCRIPTION_TEXT.color());
        locationDescriptionTextArea.setFont(FontUtils.DEFAULT_FONT.deriveFont(16f));
        int padding = 10;
        locationDescriptionTextArea.setBorder(
                BorderFactory.createEmptyBorder(0, padding, padding, padding));
        locationDescriptionTextArea.setBounds(0, 0, 391, 111);
        this.add(locationDescriptionTextArea);

        this.setBackground(LOCATION_DESCRIPTION_BACKGROUND.color());
        this.setBounds(586, 462, 391, 111);
    }

    public JTextArea getLocationDescriptionTextArea() {
        return locationDescriptionTextArea;
    }

    public void setText(String text) {
        locationDescriptionTextArea.setText(text);
    }
}
