package com.buggy.toolbar;

import com.buggy.utils.FontUtils;

import static com.buggy.utils.ColorUtils.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

public class HelpIconLabel extends TitleIconLabel {

    public HelpIconLabel(String iconPath, int x, int y, int width, int height) {
        super(iconPath, x, y, width, height);
    }

    public void showHelp() {
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this);
        JDialog dialog = new JDialog(parent, "Help", false);
        // dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        JTextArea helpTextArea = getHelpTextArea();
        dialog.add(helpTextArea, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close Dialog");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Close the dialog when the button is clicked
            }
        });

        dialog.add(closeButton, BorderLayout.SOUTH);
        dialog.setLocationRelativeTo(parent);
        dialog.pack(); // set dialogue size to fit textArea content
        dialog.setVisible(true);
        // JOptionPane.showMessageDialog(null, helpText, "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    private static JTextArea getHelpTextArea() {
        String helpText =
                """
                - go: Go to a room. e.g. go kitchen
                - look: Look around. e.g. look
                - inventory: Check your inventory. e.g. inventory
                - take: Take an item. e.g. take key
                - drop: Drop an item. e.g. drop key
                - help: Show this help message. e.g. help
                """;

        JTextArea helpTextArea = new JTextArea(helpText);
        int padding = 10;
        helpTextArea.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        helpTextArea.setEditable(false);
        helpTextArea.setBackground(HELP_BACKGROUND.color());
        helpTextArea.setForeground(HELP_TEXT.color());
        helpTextArea.setFont(FontUtils.DEFAULT_FONT.deriveFont(16f));
        return helpTextArea;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        showHelp();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
