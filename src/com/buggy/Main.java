package com.buggy;

import com.buggy.entity.Item;
import com.buggy.utils.FontUtils;

import javax.swing.*;

public class Main {
        public static void main(String[] args) {
            /* Create all items */
            String[] items = {"key", "fingerprint", "knife", "pen", "shovel", "gun"};
            for (String itemName : items) {
                new Item(itemName, "Just a simple " + itemName, itemName + ".png");
            }


            /* This is a thread-way of performing swing updates */
            SwingUtilities.invokeLater(GameFrame::new);
        }
}
