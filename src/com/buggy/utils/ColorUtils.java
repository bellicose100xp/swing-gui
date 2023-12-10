package com.buggy.utils;

import java.awt.*;

public enum ColorUtils {
    // Game Frame and Toolbar
    GAME_BACKGROUND(11, 31, 28),
    GAME_TITLE_TEXT(255, 92, 93),
    GAME_REPORT_BACKGROUND(2, 89, 81),
    GAME_REPORT_TEXT(4, 191, 173),

    // Player Section
    PLAYER_SECTION_BACKGROUND(122, 87, 0),
    PLAYER_HEADING_TEXT(235, 190, 84),
    SCORE_BACKGROUND(255, 226, 153),
    SCORE_TEXT(64, 20, 16),
    EVIDENCE_ICON_BACKGROUND(255, 206, 90),

    // Location Section
    LOCATION_SECTION_BACKGROUND(34, 64, 47),
    ITEM_ICON_BACKGROUND(64, 115, 100),
    CHARACTER_ICON_BACKGROUND(64, 115, 100),
    ITEM_DESCRIPTION_BACKGROUND(64, 115, 100),
    ITEM_TEXT(201, 240, 209),

    // Map Section
    GAME_MAP_BACKGROUND(39, 75, 89),
    GAME_MAP_TEXT(255, 255, 255),
    GAME_MAP_TILE_BORDER(255, 255, 255),
    CURRENT_LOCATION(0, 104, 55),
    ADJACENT_LOCATION(235, 190, 84),
    BLOCKED_LOCATION(232, 77, 47),

    // Location Description Section
    LOCATION_DESCRIPTION_BACKGROUND(39, 75, 89),
    LOCATION_DESCRIPTION_TEXT(139, 187, 217);

    private final Color color;

    ColorUtils(int red, int green, int blue) {
        this.color = new Color(red, green, blue);
    }

    public Color color() {
        return color;
    }
}
