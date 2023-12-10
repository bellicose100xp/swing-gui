package com.buggy.toolbar;

import com.buggy.utils.ImageUtils;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class TitleIconLabel extends JLabel implements MouseListener {
    private String iconPath;
    private int x;
    private int y;
    private int width;
    private int height;

    public TitleIconLabel(String iconPath, int x, int y, int width, int height) {
        this.iconPath = iconPath;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        ImageIcon icon = ImageUtils.getResizedIcon(iconPath, width, height);
        this.setIcon(icon);
        this.setBounds(x, y, width, height);
        this.addMouseListener(this);
    }
}
