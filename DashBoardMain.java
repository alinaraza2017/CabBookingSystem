/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

/**
 *
 * @author DELL
 */
import javax.swing.*;
import java.awt.*;

public class DashBoardMain extends JFrame {
    public DashBoardMain() {
        // Setting up the frame
        setTitle("Main Dashboard");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Creating main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.lightGray); // Sea green background

        // Welcome message
        JLabel welcomeLabel = new JLabel("Welcome to WayFare", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(Color.WHITE);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE); // Same background as main panel

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(e -> System.exit(0)); // Exits the program

        // Next button
        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.setBackground(new Color(0, 51, 102));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> {
            // Navigate to Login/Signup GUI
            LoginSignupGui lsg = new LoginSignupGui();
            lsg.loginsignup();
            lsg.setVisible(true);
            dispose(); // Close the main dashboard
        });

        // Adding buttons to panel
        buttonPanel.add(exitButton);
        buttonPanel.add(nextButton);

        // Adding components to main panel
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adding main panel to frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Launch the main dashboard
        SwingUtilities.invokeLater(() -> {
            DashBoardMain dashboard = new  DashBoardMain();
            dashboard.setVisible(true);
        });
    }
}