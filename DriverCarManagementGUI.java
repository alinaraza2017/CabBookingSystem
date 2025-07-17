/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DriverCarManagementGUI {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel viewDriversPanel;
    private JTextArea driverListArea;
    private JButton viewDriversButton;
    private JScrollPane scrollPane;
    private JButton viewRatingsButton;
    private JTextArea ratingsArea;
    private JPanel viewRatingsPanel;
    private JScrollPane ratingsScrollPane;
    private JPanel topDriversPanel;
    private JTextArea topDriversArea;
    private JButton viewTopDriversButton;
    private JPanel removeDriverPanel;
    private JLabel removeDriverLabel;
    private JTextField removeDriverField;
    private JButton removeDriverButton;
    private JScrollPane topDriversScrollPane;

    DriverCarManagementGUI() {
    }

    public void displayCarManageGUI() {
        Admin admin = new Admin("Admin", new Phone("12341234567"), new Email("admin@gmail.com"));
        frame = new JFrame("Driver and Car Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        Font font = new Font("Segoe UI", Font.PLAIN, 16);
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 18));
        tabbedPane.setBackground(Color.LIGHT_GRAY);
        tabbedPane.setForeground(new Color(0, 51, 102));

        // 'View Drivers' Tab
        viewDriversPanel = new JPanel(new BorderLayout());
        viewDriversPanel.setBackground(Color.LIGHT_GRAY);

        driverListArea = new JTextArea();
        driverListArea.setEditable(false);
        driverListArea.setFont(font);
        scrollPane = new JScrollPane(driverListArea);

        viewDriversButton = new JButton("View Drivers");
        viewDriversButton.setFont(font);
        viewDriversButton.setBackground(new Color(0, 51, 102));
        viewDriversButton.setForeground(Color.WHITE);
        viewDriversButton.setFocusPainted(false);
        viewDriversButton.setPreferredSize(new Dimension(150, 50));
        viewDriversButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverListArea.setText("");
                try {
                    DriverHandler driverHandler = new DriverHandler();
                    ArrayList<Driver> driverList = driverHandler.readFromFile();

                    if (driverList != null && !driverList.isEmpty()) {
                        for (Driver driver : driverList) {
                            driverListArea.append(driver.toString() + "\n");
                        }
                    } else {
                        driverListArea.append("No drivers found.\n");
                    }
                } catch (Exception ex) {
                    driverListArea.append("Error retrieving drivers: " + ex.getMessage() + "\n");
                }
            }
        });

        viewDriversPanel.add(scrollPane, BorderLayout.CENTER);
        viewDriversPanel.add(viewDriversButton, BorderLayout.SOUTH);
        tabbedPane.addTab("View Drivers", viewDriversPanel);

        // 'View Driver Ratings' Tab
        viewRatingsPanel = new JPanel(new BorderLayout());
        viewRatingsPanel.setBackground(new Color(230, 230, 230));

        ratingsArea = new JTextArea();
        ratingsArea.setEditable(false);
        ratingsArea.setFont(font);
        ratingsScrollPane = new JScrollPane(ratingsArea);

        viewRatingsButton = new JButton("View Driver Ratings");
        viewRatingsButton.setFont(font);
        viewRatingsButton.setBackground(new Color(0, 51, 102));
        viewRatingsButton.setForeground(Color.WHITE);
        viewRatingsButton.setFocusPainted(false);
        viewRatingsButton.setPreferredSize(new Dimension(200, 50));
        viewRatingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ratingsArea.setText("");
                StringBuilder ratingsText = new StringBuilder("Driver Ratings \n");
                DriverHandler driver = new DriverHandler();
                ArrayList<Driver> d = driver.readFromFile();
                for (Driver drivers : d) {
                    ratingsText.append("Driver: ").append(drivers.getName()).append(" Rating: ")
                            .append(drivers.getRating()).append("\n");
                }
                ratingsArea.setText(ratingsText.toString());
            }
        });

        viewRatingsPanel.add(ratingsScrollPane, BorderLayout.CENTER);
        viewRatingsPanel.add(viewRatingsButton, BorderLayout.SOUTH);
        tabbedPane.addTab("View Driver Ratings", viewRatingsPanel);

        // 'Top Drivers' Tab
        topDriversPanel = new JPanel(new BorderLayout());
        topDriversPanel.setBackground(new Color(230, 230, 230));

        topDriversArea = new JTextArea();
        topDriversArea.setEditable(false);
        topDriversArea.setFont(font);
        topDriversScrollPane = new JScrollPane(topDriversArea);

        viewTopDriversButton = new JButton("View Top Drivers");
        viewTopDriversButton.setFont(font);
        viewTopDriversButton.setBackground(new Color(0, 51, 102));
        viewTopDriversButton.setForeground(Color.WHITE);
        viewTopDriversButton.setFocusPainted(false);
        viewTopDriversButton.setPreferredSize(new Dimension(200, 50));
        viewTopDriversButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                topDriversArea.setText("");
                admin.displayTopDrivers();
            }
        });

        topDriversPanel.add(topDriversScrollPane, BorderLayout.CENTER);
        topDriversPanel.add(viewTopDriversButton, BorderLayout.SOUTH);
        tabbedPane.addTab("Top Drivers", topDriversPanel);

        // 'Remove Driver' Tab
        removeDriverPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        removeDriverPanel.setBackground(new Color(230, 230, 230));

        removeDriverLabel = new JLabel("Driver Name:");
        removeDriverLabel.setFont(font);

        removeDriverField = new JTextField();
        removeDriverField.setFont(font);
        removeDriverField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        removeDriverButton = new JButton("Remove Driver");
        removeDriverButton.setFont(font);
        removeDriverButton.setBackground(new Color(0, 51, 102));
        removeDriverButton.setForeground(Color.WHITE);
        removeDriverButton.setFocusPainted(false);
        removeDriverButton.setPreferredSize(new Dimension(200, 50));
        removeDriverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String driverName = removeDriverField.getText();
                boolean isRemoved = admin.removeDriver(driverName);

                if (isRemoved) {
                    JOptionPane.showMessageDialog(frame, driverName + " has been removed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    removeDriverField.setText(""); // Clear the text field
                    // Refresh the View Drivers tab
                    refreshDriverList();
                    refreshDriverRatings();
                    refreshTopDrivers();
                } else {
                    JOptionPane.showMessageDialog(frame, driverName + " could not be found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeDriverPanel.add(removeDriverLabel);
        removeDriverPanel.add(removeDriverField);
        removeDriverPanel.add(removeDriverButton);
        tabbedPane.addTab("Remove Driver", removeDriverPanel);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
        private void refreshDriverList() {
        driverListArea.setText("");
        try {
            DriverHandler driverHandler = new DriverHandler();
            ArrayList<Driver> driverList = driverHandler.readFromFile();

            if (driverList != null && !driverList.isEmpty()) {
                for (Driver driver : driverList) {
                    driverListArea.append(driver.toString() + "\n");
                }
            } else {
                driverListArea.append("No drivers found.\n");
            }
        } catch (Exception ex) {
            driverListArea.append("Error retrieving drivers: " + ex.getMessage() + "\n");
        }
    }

    private void refreshDriverRatings() {
        ratingsArea.setText("");
        StringBuilder ratingsText = new StringBuilder(" Driver Ratings \n");
        DriverHandler driver = new DriverHandler();
        ArrayList<Driver> d = driver.readFromFile();
        for (Driver drivers : d) {
            ratingsText.append("Driver: ").append(drivers.getName()).append(", Rating: ")
                    .append(drivers.getRating()).append("\n");
        }
        ratingsArea.setText(ratingsText.toString());
    }

    private void refreshTopDrivers() {
        topDriversArea.setText("");
        Admin admin = new Admin("Admin", new Phone("12341234567"), new Email("admin@gmail.com"));
        admin.displayTopDrivers(); // Ensure this updates the topDriversArea
    }
}

