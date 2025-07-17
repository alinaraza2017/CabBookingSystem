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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDashboard extends JFrame {
    private JPanel mainPanel;
    private JLabel welcomeLabel;
    private JButton bookRideButton;
    private JButton cancelRideButton;
    private JButton viewHistoryButton;
    private JButton logoutButton;
    private JTextArea rideHistoryArea;
    private JLabel upcomingRideLabel;
    private JLabel lastRideLabel;
    private JLabel accountStatusLabel;

    public CustomerDashboard() {
    }

    public void guiDashboard() {
        // Frame settings
        setTitle("Customer Dashboard");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(230, 230, 230));
        add(mainPanel);

        // Header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.lightGray); // Deep blue
        headerPanel.setPreferredSize(new Dimension(800, 50));

        welcomeLabel = new JLabel("Welcome to WayFare", SwingConstants.CENTER);
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        headerPanel.add(welcomeLabel, BorderLayout.CENTER);

        logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.RED);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        logoutButton.setFocusPainted(false);
        headerPanel.add(logoutButton, BorderLayout.EAST);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Sidebar
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new GridLayout(3, 1, 10, 10));
        sidebarPanel.setBackground(new Color(240, 248, 255)); // Light gray
        sidebarPanel.setPreferredSize(new Dimension(180, 500));

        bookRideButton = createSidebarButton("Book a Ride");
        cancelRideButton = createSidebarButton("Cancel Ride");
        viewHistoryButton = createSidebarButton("Ride History");

        sidebarPanel.add(bookRideButton);
        sidebarPanel.add(cancelRideButton);
        sidebarPanel.add(viewHistoryButton);

        mainPanel.add(sidebarPanel, BorderLayout.WEST);

        // Content Area
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        upcomingRideLabel = createContentLabel("Upcoming Ride: None");
        lastRideLabel = createContentLabel("Last Ride: None");
        accountStatusLabel = createContentLabel("Account Status: No ride booked");

        contentPanel.add(upcomingRideLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(lastRideLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(accountStatusLabel);
        contentPanel.add(Box.createVerticalStrut(20));

        JLabel rideHistoryLabel = new JLabel("Ride History:");
        rideHistoryLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        contentPanel.add(rideHistoryLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        rideHistoryArea = new JTextArea(10, 40);
        rideHistoryArea.setEditable(false);
        rideHistoryArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(rideHistoryArea);
        contentPanel.add(scrollPane);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Button actions
        bookRideButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(CustomerDashboard.this, "Booking ride");
            accountStatusLabel.setText("Account Status: Ride booked!");
        });

        cancelRideButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(CustomerDashboard.this, "Cancelling ride...");
            accountStatusLabel.setText("Account Status: No ride booked.");
        });

        viewHistoryButton.addActionListener(e -> 
            rideHistoryArea.setText("Ride 1: Pickup - A, Drop - B\nRide 2: Pickup - C, Drop - D")
        );

        logoutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(CustomerDashboard.this, "Logging out");
            System.exit(0);
        });

        // Make the frame visible
        setVisible(true);
    }

    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setBackground(new Color(0, 51, 102)); // Deep blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }

    private JLabel createContentLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomerDashboard gui = new CustomerDashboard();
            gui.guiDashboard();
        });
    }
}
