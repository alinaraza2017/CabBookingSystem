/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DriverDetailsGUI extends JFrame {

    private JLabel detailsLabel = new JLabel();

    // Constructor that accepts a Driver object
    public DriverDetailsGUI(Driver driver) {
        drivergui(driver);
    }

    public void drivergui(Driver driver) {
        setTitle("Driver Details");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Set the layout of the main frame to BorderLayout
        setLayout(new BorderLayout());

        // Create a header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 51, 102)); // Deep blue color
        headerPanel.setPreferredSize(new Dimension(500, 50));

        JLabel titleLabel = new JLabel("Driver Details", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Bold and larger font
        headerPanel.add(titleLabel);

        add(headerPanel, BorderLayout.NORTH);

        // Create a panel for the details with padding
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        detailsPanel.setBackground(Color.lightGray); // Light gray background

        // Add driver details as formatted labels
        detailsPanel.add(createDetailLabel("Name", driver.getName()));
        detailsPanel.add(createDetailLabel("Email", driver.getEmail()));
        detailsPanel.add(createDetailLabel("Phone", driver.getPhone()));
        detailsPanel.add(createDetailLabel("Vehicle", driver.getVehicle()));
        detailsPanel.add(createDetailLabel("Rating", driver.getRating()));

        add(detailsPanel, BorderLayout.CENTER);

        // Set the GUI visible
        setVisible(true);
    }

    // Helper method to create a formatted detail label
    private JLabel createDetailLabel(String fieldName, Object value) {
        JLabel label = new JLabel("<html><b>" + fieldName + ":</b> " + value + "</html>");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Add padding between labels
        return label;
    }

    // Method to update driver details dynamically
    public void updateDriverDetails(String name, String email, String phone, String vehicle, String rating) {
        // Implement logic to update the display if needed
    }

    // Method to load driver details from the file
    public void loadDriverDetails() {
        ArrayList<Driver> drivers = readFromFileGUI(); // Get driver details from file

        if (drivers != null && !drivers.isEmpty()) {
            Driver driver = drivers.get(0); // Assuming the first driver in the list
            System.out.println("Loaded Driver: " + driver.getName());
            
            // Update GUI with driver details
        } else {
            JOptionPane.showMessageDialog(this, "No driver data found.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    // Method to read driver data from file
    private ArrayList<Driver> readFromFileGUI() {
        ArrayList<Driver> driverList=new Driver().driverHandler.readFromFile();
         // Using the Driver class's method to read data
        return driverList;
    }

    // Main method to launch the GUI application
    public static void main(String[] args) {
        Driver testDriver = new Driver("John Doe", new Phone("12345678906"), new Email("johndoe@example.com"));
        testDriver.setVehicle(new Vehicle());
        testDriver.setRating(new Rating());

        SwingUtilities.invokeLater(() -> new DriverDetailsGUI(testDriver));
    }
}
