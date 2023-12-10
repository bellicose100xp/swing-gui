package com.buggy;

import static com.buggy.utils.ColorUtils.*;

import com.buggy.utils.ColorUtils;
import com.buggy.utils.DottedBorder;
import com.buggy.utils.FontUtils;
import com.buggy.world.Location;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class MapSection extends JPanel implements MouseListener {
    private static Location currentLocation;
    private final Map<JLabel, Location> locationLabels;
    private LocationDescriptionSection locationDescriptionSection;

    public MapSection(LocationDescriptionSection locationDescriptionSection) {
        this.locationDescriptionSection = locationDescriptionSection;

        /* Manually create all rooms */
        Location backyard = new Location("Backyard");
        backyard.description =
                "The backyard is well kept, with all manner of flora lining the property and various stone decorations sprinkled about. It looks like a comfortable place to sit in the sun with a cup of tea and a good book.";
        Location kitchen = new Location("Kitchen");
        kitchen.description =
                "The kitchen is quaint. Every cabinet has intricately carved oak-wood features and there are doilies on every surface. The few stainless steel appliances clash with the rest of the interior.";
        Location office = new Location("Office");
        office.description =
                "The office is far more plain than the rest of the house. The interior would feel oppressively corporate if it weren't for the massive window letting in copious natural light. There is a white tarp on the floor cover the spot the body was found.";
        Location livingRoom = new Location("Living Room");
        livingRoom.description =
                "The living room is a comfortable place to relax. The only furniture is a large couch, with a large TV and a large table. The TV is set to a movie, and the couch is set to a game of chess.";
        Location gameRoom = new Location("Game Room");
        gameRoom.description =
                "The game room is a comfortable place to play. There is a large table with a large TV, and a large couch. The TV is set to a game of chess, and the couch is set to a movie.";

        /* Manually set current location */
        currentLocation = kitchen;
        locationDescriptionSection.setText(currentLocation.description);

        /* Manually add adjacent rooms */
        backyard.adjacentLocations.add(kitchen);
        kitchen.adjacentLocations.add(backyard);
        kitchen.adjacentLocations.add(office);
        office.adjacentLocations.add(kitchen);
        office.adjacentLocations.add(livingRoom);
        livingRoom.adjacentLocations.add(office);
        livingRoom.adjacentLocations.add(gameRoom);
        gameRoom.adjacentLocations.add(livingRoom);

        /* Create Location Labels*/
        JLabel backyardLabel = createLocationLabel("Backyard", MAP_DEFAULT_BACKGROUND);
        JLabel kitchenLabel = createLocationLabel("Kitchen", CURRENT_LOCATION);
        JLabel officeLabel = createLocationLabel("Office", MAP_DEFAULT_BACKGROUND);
        JLabel livingRoomLabel = createLocationLabel("Living Room", MAP_DEFAULT_BACKGROUND);
        JLabel gameRoomLabel = createLocationLabel("Game Room", MAP_DEFAULT_BACKGROUND);

        /* Map of location Labels */
        locationLabels = new HashMap<>();
        locationLabels.put(backyardLabel, backyard);
        locationLabels.put(kitchenLabel, kitchen);
        locationLabels.put(officeLabel, office);
        locationLabels.put(livingRoomLabel, livingRoom);
        locationLabels.put(gameRoomLabel, gameRoom);

        /* Attach MouseListener to all labels */
        for (JLabel label : locationLabels.keySet()) {
            /* This class implements MouseListener so we're using that */
            label.addMouseListener(this);
        }

        /* Add Grid Panel Labels */
        this.setLayout(new GridLayout(3, 3));

        /* first row  */
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(gameRoomLabel);
        /* second row */
        this.add(kitchenLabel);
        this.add(officeLabel);
        this.add(livingRoomLabel);
        /* third row */
        this.add(backyardLabel);
        this.add(new JLabel());
        this.add(new JLabel());

        int padding = 10;
        this.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        this.setBackground(MAP_DEFAULT_BACKGROUND.color());
        this.setBounds(586, 71, 391, 391);
    }

    private static JLabel createLocationLabel(String location, ColorUtils gameMapBackground) {
        JLabel locationLabel = new JLabel(location);
        locationLabel.setFont(FontUtils.DEFAULT_FONT.deriveFont(16f));
        locationLabel.setForeground(GAME_MAP_TEXT.color());
        locationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        locationLabel.setVerticalAlignment(SwingConstants.CENTER);
        locationLabel.setOpaque(true);
        locationLabel.setBackground(gameMapBackground.color());
        locationLabel.setBorder(new DottedBorder(GAME_MAP_TILE_BORDER.color(), 1, 3));
        return locationLabel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel clickedLabel = (JLabel) e.getSource();
        Location clickedLocation = locationLabels.get(clickedLabel);

        if (clickedLocation == currentLocation) {
            return;
        }

        JLabel currentLocationLabel = null;

        for (var entry : locationLabels.entrySet()) {
            if (entry.getValue() == currentLocation) {
                currentLocationLabel = entry.getKey();
            }
        }

        if (currentLocationLabel == null) {
            throw new RuntimeException("Error: no JLabel found for current location");
        }

        currentLocationLabel.setBackground(MAP_DEFAULT_BACKGROUND.color());
        clickedLabel.setBackground(CURRENT_LOCATION.color());
        currentLocation = clickedLocation;

        /* Update location description */
        locationDescriptionSection.setText(currentLocation.description);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        Location location = locationLabels.get(label);

        if (currentLocation.adjacentLocations.contains(location)) {
            label.setBackground(ADJACENT_LOCATION.color());
            return;
        }

        if (location != currentLocation) {
            label.setBackground(UNREACHABLE_LOCATION.color());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JLabel label = (JLabel) e.getSource();
        Location location = locationLabels.get(label);

        if (location != currentLocation) {
            label.setBackground(MAP_DEFAULT_BACKGROUND.color());
        }
    }
}
