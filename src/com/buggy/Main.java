package com.buggy;

import com.buggy.utils.FontUtils;

import javax.swing.*;

public class Main {
        public static void main(String[] args) {
            /* This is a thread-way of performing swing updates */
            SwingUtilities.invokeLater(GameFrame::new);
        }
}
