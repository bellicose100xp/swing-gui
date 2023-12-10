package com.buggy;

import com.buggy.utils.FontUtils;

import javax.swing.*;

import static com.buggy.utils.ColorUtils.*;

public class LocationDescriptionSection extends JPanel {
    public LocationDescriptionSection() {
        JTextArea locationDescription = new JTextArea();
        locationDescription.setText(
                "The backyard is well kept, with all manner of flora lining the property  and various stone decorations sprinkled about. It looks like a comfortable place to sit in the sun with a cup of tea and a good book.");
        locationDescription.setLineWrap(true);
        locationDescription.setLineWrap(true);
        locationDescription.setWrapStyleWord(true);
        locationDescription.setEditable(false);
        locationDescription.setBackground(LOCATION_DESCRIPTION_BACKGROUND.color());
        locationDescription.setForeground(LOCATION_DESCRIPTION_TEXT.color());
        locationDescription.setFont(FontUtils.DEFAULT_FONT.deriveFont(16f));
        int padding = 10;
        locationDescription.setBorder(
                BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        locationDescription.setBounds(0, 0, 391, 111);
        this.add(locationDescription);

        this.setBackground(LOCATION_DESCRIPTION_BACKGROUND.color());
        this.setBounds(586, 462, 391, 111);
    }
}
