package es.ulpgc.dis.view;

import es.ulpgc.dis.control.CommandManager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final ImageDisplayPanel imagePanel;
    private final CommandManager commandManager;

    public MainFrame(ImageDisplayPanel imagePanel, CommandManager commandManager) {
        this.imagePanel = imagePanel;
        this.commandManager = commandManager;
        deployUI();
    }

    private void deployUI() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel);
        this.add(toolBar(), BorderLayout.SOUTH);
    }

    private JMenuBar toolBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        menuBar.add(prevButton());
        menuBar.add(nextButton());
        return menuBar;
    }

    private JButton nextButton() {
        JButton nextButton = new JButton(">");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.addActionListener(e -> commandManager.getCommand("Next").execute());
        return nextButton;
    }

    private JButton prevButton() {
        JButton prevButton = new JButton("<");
        prevButton.setFont(new Font("Arial", Font.BOLD, 20));
        prevButton.addActionListener(e -> commandManager.getCommand("Prev").execute());
        return prevButton;
    }
}
