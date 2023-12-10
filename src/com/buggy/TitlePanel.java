package com.buggy;

import com.buggy.utils.FontUtils;
import com.buggy.utils.ImageUtils;

import static com.buggy.utils.ColorUtils.*;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;

public class TitlePanel extends JPanel {
    public TitlePanel() {

        /* Game Title */
        JLabel title = new JLabel("Search For A Killer");
        Font customTitleFont = FontUtils.registerCustomTitleFont();
        Font titleFont = customTitleFont.deriveFont(Font.PLAIN, 48);
        title.setFont(titleFont);
        title.setForeground(GAME_TITLE_TEXT.color());
        title.setBounds(80, 10, 431, 49);
        this.add(title);

        /* Report Killer Button */
        JButton reportKiller = new JButton("Report Killer");
        reportKiller.setFont(FontUtils.DEFAULT_FONT.deriveFont(24f));
        reportKiller.setBackground(GAME_REPORT_BACKGROUND.color());
        reportKiller.setForeground(GAME_REPORT_TEXT.color());
        reportKiller.setBounds(600, 12, 171, 44);
        reportKiller.setFocusable(false);
        this.add(reportKiller);

        /* Help Icon */
        JLabel helpLabel = createTitleBarIconLabel("data/icons/help.png", 789, 9, 50, 50);
        this.add(helpLabel);

        /* Volume Icon */
        JLabel volumeLabel = createTitleBarIconLabel("data/icons/volume.png", 856, 9, 50, 50);
        this.add(volumeLabel);

        /* Exit Icon */
        JLabel exitLabel = createTitleBarIconLabel("data/icons/exit.png", 924, 9, 50, 50);
        this.add(exitLabel);

        /* Title Panel Specific Settings */
        this.setLayout(null);
        this.setBounds(0, 0, 1000, 65);
        this.setBackground(GAME_BACKGROUND.color());
    }

    public JLabel createTitleBarIconLabel(String path, int x, int y, int width, int height) {
        ImageIcon icon = ImageUtils.getResizedIcon(path, width, height);
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setBounds(x, y, width, height);
        return iconLabel;
    }


}
