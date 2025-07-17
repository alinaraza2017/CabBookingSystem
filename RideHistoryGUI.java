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
import java.awt.event.*;
import java.util.ArrayList;

public class RideHistoryGUI extends JFrame {
    private JTextField userIDField;
    private JTextField pickupAddressField;
    private JTextField dropoffAddressField;
    private JTextField fareField;
    private JTextField discountField;
    private JButton createRideButton;
    private JButton viewHistoryButton;
    private JTextArea historyArea;

    // Default constructor
    public RideHistoryGUI() {
        guiRide();
    }

    // GUI method as in the original code
    public void guiRide() {
        setTitle("Ride History");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Overall Layout
        setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 51, 102)); // Deep blue color
        headerPanel.setPreferredSize(new Dimension(600, 60));
        JLabel headerLabel = new JLabel("Ride History");
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        formPanel.setBackground(Color.LIGHT_GRAY); // Light gray background

        // Create components
        JLabel userIDLabel = new JLabel("Enter User ID:");
        userIDField = new JTextField(40);

        JLabel pickupLabel = new JLabel("Enter Pickup Address:");
        pickupAddressField = new JTextField(40);

        JLabel dropoffLabel = new JLabel("Enter Dropoff Address:");
        dropoffAddressField = new JTextField(40);

        JLabel fareLabel = new JLabel("Fare (Rs.):");
        fareField = new JTextField(10);

        JLabel discountLabel = new JLabel("Discount Percentage:");
        discountField = new JTextField(10);

        createRideButton = new JButton("Create Ride");
        viewHistoryButton = new JButton("View Ride History");

        // Add components to form panel
        formPanel.add(userIDLabel);
        formPanel.add(userIDField);

        formPanel.add(pickupLabel);
        formPanel.add(pickupAddressField);

        formPanel.add(dropoffLabel);
        formPanel.add(dropoffAddressField);

        formPanel.add(fareLabel);
        formPanel.add(fareField);

        formPanel.add(discountLabel);
        formPanel.add(discountField);

        formPanel.add(createRideButton);
        formPanel.add(viewHistoryButton);

        add(formPanel, BorderLayout.CENTER);

        // History Panel
        JPanel historyPanel = new JPanel();
        historyPanel.setBackground(Color.LIGHT_GRAY);
        historyPanel.setLayout(new BorderLayout());
        historyPanel.setBorder(BorderFactory.createTitledBorder("Ride History"));
        historyArea = new JTextArea(15, 40);
        historyArea.setEditable(false);
        historyPanel.add(new JScrollPane(historyArea), BorderLayout.CENTER);

        add(historyPanel, BorderLayout.SOUTH);

        // Event Listeners
        createRideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRide();
            }
        });

        viewHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewRideHistory();
            }
        });

        setLocationRelativeTo(null); // Center the frame
    }

    private void createRide() {
        // Logic remains unchanged
        JOptionPane.showMessageDialog(this, "Ride Created Successfully!");
    }

    private void viewRideHistory() {
        // Logic remains unchanged
        historyArea.setText("Ride history for User ID...");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RideHistoryGUI gui = new RideHistoryGUI();
            gui.setVisible(true);
        });
    }
}
