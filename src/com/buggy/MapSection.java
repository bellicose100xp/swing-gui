package com.buggy;

import com.buggy.utils.ColorUtils;
import com.buggy.utils.FontUtils;
import com.buggy.world.Location;

import static com.buggy.utils.ColorUtils.*;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class MapSection extends JPanel {
    public MapSection() {

        Location backyard = new Location("Backyard");
        Location kitchen = new Location("Kitchen");
        Location office = new Location("Office");
        Location livingRoom = new Location("Living Room");
        Location gameRoom = new Location("Game Room");

        backyard.adjacentLocations.add(kitchen);
        kitchen.adjacentLocations.add(backyard);
        kitchen.adjacentLocations.add(office);
        office.adjacentLocations.add(kitchen);
        office.adjacentLocations.add(livingRoom);
        livingRoom.adjacentLocations.add(office);
        livingRoom.adjacentLocations.add(gameRoom);
        gameRoom.adjacentLocations.add(livingRoom);

        JLabel backyardLabel = createLocationLabel("Backyard", GAME_MAP_BACKGROUND);
        JLabel kitchenLabel = createLocationLabel("Kitchen", CURRENT_LOCATION);

        /* Add Grid Panel Labels */
        this.setLayout(new GridLayout(3, 3));

        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(kitchenLabel);
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(backyardLabel);
        this.add(new JLabel());
        this.add(new JLabel());


        int padding = 10;
        this.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        this.setBackground(GAME_MAP_BACKGROUND.color());
        this.setBounds(586, 71, 391, 391);
    }

    private static JLabel createLocationLabel(String Backyard, ColorUtils gameMapBackground) {
        JLabel backyardLabel = new JLabel(Backyard);
        backyardLabel.setFont(FontUtils.DEFAULT_FONT.deriveFont(24f));
        backyardLabel.setForeground(GAME_MAP_TEXT.color());
        backyardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backyardLabel.setVerticalAlignment(SwingConstants.CENTER);
        backyardLabel.setOpaque(true);
        backyardLabel.setBackground(gameMapBackground.color());
        backyardLabel.setBorder(new DottedBorder(GAME_MAP_TILE_BORDER.color(), 1, 3));
        return backyardLabel;
    }

    public static class DottedBorder extends AbstractBorder {
        private final Color color;
        private final int thickness;
        private final int dotSpacing;

        public DottedBorder(Color color, int thickness, int dotSpacing) {
            this.color = color;
            this.thickness = thickness;
            this.dotSpacing = dotSpacing;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(color);

            BasicStroke stroke =
                    new BasicStroke(
                            thickness,
                            BasicStroke.CAP_ROUND,
                            BasicStroke.JOIN_ROUND,
                            0,
                            new float[] {dotSpacing},
                            0);
            g2d.setStroke(stroke);

            g2d.drawRect(x, y, width - 1, height - 1);
            g2d.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(thickness, thickness, thickness, thickness);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.top = insets.left = insets.bottom = insets.right = thickness;
            return insets;
        }
    }
}
