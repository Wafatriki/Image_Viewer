package es.ulpgc.dis;

import es.ulpgc.dis.control.CommandManager;
import es.ulpgc.dis.service.ImageFileReader;
import es.ulpgc.dis.view.ImageDisplayPanel;
import es.ulpgc.dis.view.MainFrame;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}

        ImageDisplayPanel imagePanel = new ImageDisplayPanel(new ImageFileReader("images").read());
        CommandManager commandManager = new CommandManager(imagePanel);
        MainFrame mainFrame = new MainFrame(imagePanel, commandManager);
        mainFrame.setVisible(true);
    }
}
