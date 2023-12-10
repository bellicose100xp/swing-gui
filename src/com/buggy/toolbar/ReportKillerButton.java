package com.buggy.toolbar;

import com.buggy.utils.FontUtils;

import javax.swing.*;

import static com.buggy.utils.ColorUtils.GAME_REPORT_BACKGROUND;
import static com.buggy.utils.ColorUtils.GAME_REPORT_TEXT;

public class ReportKillerButton extends JButton {
        public ReportKillerButton() {

            this.setText("Report Killer");
            this.setFont(FontUtils.DEFAULT_FONT.deriveFont(24f));
            this.setBackground(GAME_REPORT_BACKGROUND.color());
            this.setForeground(GAME_REPORT_TEXT.color());
            this.setBounds(600, 12, 171, 44);
            this.setFocusable(false);
            this.addActionListener( e -> {
                // Do something with the click
                System.out.println("Report Killer Button Pressed");
            });
        }


}
