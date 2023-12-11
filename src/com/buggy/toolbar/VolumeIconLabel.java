package com.buggy.toolbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VolumeIconLabel extends TitleIconLabel {
    private JDialog volumeDialog;
    private JSlider volumeSlider;
    private boolean skipNextVolumeClickEvent;

    public VolumeIconLabel(String iconPath, int x, int y, int width, int height) {
        super(iconPath, x, y, width, height);
    }

    private void createVolumeDialogue() {
        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this);

        /* Create volume Dialogue */
        volumeDialog = new JDialog(parent, "Volume Control", false);
        volumeDialog.setSize(200, 60);
        volumeDialog.setAlwaysOnTop(true);
        volumeDialog.setLocationRelativeTo(parent);
        volumeDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        volumeDialog.setUndecorated(true);

        // Dismiss Volume Dialog when the window is deactivated (e.g. clicked outside)
        volumeDialog.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        volumeDialog.setVisible(false);
                        skipNextVolumeClickEvent = true;

                        // If you dismissed the volume window by not clicking the volume icon
                        // You don't have to double-click the volume icon to show the window again
                        Thread setSkipNextVolumeClickEventToFalseThread =
                                new Thread(
                                        () -> {
                                            try {
                                                Thread.sleep(300);
                                            } catch (InterruptedException ignored) {
                                                System.out.println("Error: Sleep Interrupted");
                                            }

                                            skipNextVolumeClickEvent = false;
                                        });

                        setSkipNextVolumeClickEventToFalseThread.start();
                    }
                });

        volumeSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        volumeSlider.setMajorTickSpacing(20);
        volumeSlider.setMinorTickSpacing(5);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintLabels(true);
        volumeSlider.addChangeListener(e -> handleVolumeChange(volumeSlider.getValue()));
        volumeDialog.setContentPane(volumeSlider);
    }

    private void handleVolumeChange(int value) {
        System.out.println("Volume level changed to " + value);
    }

    private void showVolumeDialogue() {
        // If the volume window was closed by WindowDeactivateListener,
        // we don't need to take any action
        if (skipNextVolumeClickEvent) {
            skipNextVolumeClickEvent = false;
            return;
        }

        if (volumeDialog == null) {
            createVolumeDialogue();
        }

        // Position volume dialog below volume icon
        int x = this.getX();
        int y = this.getY();
        int width = this.getWidth();
        int height = this.getHeight();

        int centerX = x + width / 2;
        int centerY = y + height / 2;

        volumeDialog.setLocation(centerX - 100, centerY + height + 10);

        volumeDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        showVolumeDialogue();
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
