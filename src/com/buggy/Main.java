package com.buggy;

import com.buggy.entity.Item;
import com.buggy.entity.Character;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /* Create all items */
        String[] items = {"key", "fingerprint", "knife", "pen", "shovel", "gun"};
        for (String itemName : items) {
            new Item(itemName, "Just a simple " + itemName, itemName + ".png");
        }

        /* Create all characters */
        String[] characters = {"nanny", "butler", "gardner", "man", "girl"};
        for (String characterName : characters) {
            Character character = new Character(characterName, "Just a simple " + characterName,
                    characterName + ".png");
            character.setDialogue("My name is " + characterName);
        }

        /* Display Splash Screen */
        SplashScreen splashScreen = new SplashScreen();

        /* Sleep for 3 Seconds */
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }

        /* Remove Splash Screen */
        splashScreen.dispose();

        /* Display Main Game */
        /* This is a thread-way of performing swing updates */
        SwingUtilities.invokeLater(GameFrame::new);
    }
}
