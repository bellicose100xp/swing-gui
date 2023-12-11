package com.buggy;

import javax.swing.*;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon image = new ImageIcon("data/splash_screen/splash.jpg");
        JLabel label = new JLabel(image);
        this.getContentPane().add(label);
        this.setSize(999, 600);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SplashScreen();
    } // end main() method
}
