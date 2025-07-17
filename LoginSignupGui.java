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

public class LoginSignupGui extends JFrame {
    private JPanel mainPanel;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField nameField;
    private JTextField signupPhoneField;
    private JTextField signupEmailField;

    private JButton loginButton;
    private JButton signupButton;
    private JButton switchToSignupButton;
    private JButton switchToLoginButton;
    private JRadioButton adminRadio;
    private JRadioButton customerRadio;
    private JRadioButton driverRadio;
    private JRadioButton adminloginRadio;
    private JRadioButton customerloginRadio;
    private JRadioButton driverloginRadio;
    private ButtonGroup roleGroup;
    private ButtonGroup rolesGroup;

    public LoginSignupGui() {
        
    }
    
    public void loginsignup(){
        setTitle("WayFare - Login/Signup");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen

        // Main panel with CardLayout for switching between Login and Signup
        mainPanel = new JPanel(new CardLayout());

        // Login Panel
        JPanel loginPanel = createPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title for Login
        JLabel loginTitle = createTitleLabel("WayFare - Login");
        emailField = createTextField();
        phoneField = createTextField();
        adminloginRadio = createRadioButton("Admin");
        customerloginRadio = createRadioButton("Customer");
        driverloginRadio = createRadioButton("Driver");
        roleGroup = new ButtonGroup();
        roleGroup.add(adminloginRadio);
        roleGroup.add(customerloginRadio);
        roleGroup.add(driverloginRadio);
        loginButton = createButton("Login");
        switchToSignupButton = createButton("Switch to Signup");

        // Centering login panel components
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(loginTitle, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        loginPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        loginPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        loginPanel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        loginPanel.add(phoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;

        // Create and add the rolePanel (for radio buttons)
        JPanel rolePanel = createRolePanel(adminloginRadio, customerloginRadio, driverloginRadio);
        loginPanel.add(rolePanel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        loginPanel.add(loginButton, gbc);

        gbc.gridx = 1;
        loginPanel.add(switchToSignupButton, gbc);

        // Signup Panel
        JPanel signupPanel = createPanel();
        signupPanel.setLayout(new GridBagLayout());

        // Title for Signup
        JLabel signupTitle = createTitleLabel("WayFare - Signup");
        adminRadio = createRadioButton("Admin");
        customerRadio = createRadioButton("Customer");
        driverRadio = createRadioButton("Driver");
        rolesGroup = new ButtonGroup();
        rolesGroup.add(adminRadio);
        rolesGroup.add(customerRadio);
        rolesGroup.add(driverRadio);
        nameField = createTextField();
        signupEmailField = createTextField();
        signupPhoneField = createTextField();
        signupButton = createButton("Signup");
        switchToLoginButton = createButton("Switch to Login");

        // Adding components to Signup Panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        signupPanel.add(signupTitle, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        signupPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        signupPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        signupPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        signupPanel.add(signupEmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        signupPanel.add(new JLabel("Phone:"), gbc);

        gbc.gridx = 1;
        signupPanel.add(signupPhoneField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        signupPanel.add(createRolePanel(adminRadio, customerRadio, driverRadio), gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        signupPanel.add(signupButton, gbc);

        gbc.gridx = 1;
        signupPanel.add(switchToLoginButton, gbc);

        // Add panels to Main Panel
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(signupPanel, "Signup");

        // Add Main Panel to Frame
        add(mainPanel);

        // Action Listeners for Switching Panels
        switchToSignupButton.addActionListener(e -> switchPanel("Signup"));
        switchToLoginButton.addActionListener(e -> switchPanel("Login"));
        loginButton.addActionListener(e -> handleLogin());
        signupButton.addActionListener(e -> handleSignup());
    }

    private void switchPanel(String panelName) {
        CardLayout cl = (CardLayout) mainPanel.getLayout();
        cl.show(mainPanel, panelName);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY); // Light gray background
        return panel;
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBackground(Color.WHITE); // White background for text fields
        return textField;
    }

    private JRadioButton createRadioButton(String text) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("Arial", Font.PLAIN, 14));
        radioButton.setBackground(Color.BLACK);
        radioButton.setForeground(Color.WHITE);
        return radioButton;
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(0, 51, 102));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    private JPanel createRolePanel(JRadioButton... buttons) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        for (JRadioButton button : buttons) {
            panel.add(button);
        }
        return panel;
    }

    private void handleLogin() {
        String emailString = emailField.getText();
        String phoneString = phoneField.getText();

        try {
            // Convert String to Email and Phone objects
            Email email = new Email(emailString);
            Phone phone = new Phone(phoneString);

            if (adminloginRadio.isSelected()) {
                Admin admin = new Admin(phone, email);
                admin.login(email, phone);
                JOptionPane.showMessageDialog(this, "Welcome Back to Admin Dashboard!");
                DriverCarManagementGUI dd = new DriverCarManagementGUI();
                dd.displayCarManageGUI();
                this.dispose();
            } else if (customerloginRadio.isSelected()) {
                Customer customer = new Customer(phone, email);
                customer.login(email, phone);
                JOptionPane.showMessageDialog(this, "Welcome Back to Customer Dashboard!");
                CustomerDashboard cd = new CustomerDashboard();
                cd.guiDashboard();
                this.dispose();
                
            } else if (driverloginRadio.isSelected()) {
            Driver driver = new Driver(phone, email);
                driver.login(email, phone);
                JOptionPane.showMessageDialog(this, "Welcome Back to Driver Dashboard!");
                DriverDetailsGUI d = new DriverDetailsGUI(driver);
                d.drivergui(driver);
                this.dispose();
                
            } else {
                JOptionPane.showMessageDialog(this, "Please select a role!");
            }
        } catch (IllegalArgumentException e) {
            // Handle invalid email or phone input
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage());
        }
    }

    private void handleSignup() {
        String name = nameField.getText();
        String emailString = signupEmailField.getText();
        String phoneString = signupPhoneField.getText();

        try {
            Email email = new Email(emailString);
            Phone phone = new Phone(phoneString);

            if (adminRadio.isSelected()) {
                Admin admin = new Admin(name, phone, email);
                admin.signup(email, phone, name);
                JOptionPane.showMessageDialog(this, "Welcome Back to Admin Dashboard!");
                DriverCarManagementGUI dd = new DriverCarManagementGUI();
                dd.displayCarManageGUI();
                this.dispose();
            } else if (customerRadio.isSelected()) {
                Customer customer = new Customer(name, phone, email);
                customer.signup(email, phone, name);
                JOptionPane.showMessageDialog(this, "Welcome Back to Customer Dashboard!");
                CustomerDashboard cd = new CustomerDashboard();
                cd.guiDashboard();
                this.dispose();
            } else if (driverRadio.isSelected()) {
                Driver driver = new Driver(name, phone, email);
                driver.signup(email, phone, name);
                JOptionPane.showMessageDialog(this, "Welcome to Driver Dashboard!");
                DriverDetailsGUI dd = new DriverDetailsGUI(driver);
                dd.setVisible(true);  // Make the driver details window visible
                this.dispose(); // Close the Login/Signup window
            } else {
                JOptionPane.showMessageDialog(this, "Please select a role!");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Invalid input: " + e.getMessage());
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginSignupGui gui = new LoginSignupGui();
            gui.setVisible(true);
        });
    }
}
