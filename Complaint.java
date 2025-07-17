/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

/**
 *
 * @author DELL
 */
//import java.io.*;
//import java.util.ArrayList;
//
//public class Complaint implements Serializable {
//    private int customerID;  // The customer who made the complaint
//    private String complaintText;
//    private static final String COMPLAINT_FILE = "complaints.txt"; 
//
//    // Constructor
//    public Complaint(int customerID, String complaintText) {
//        this.customerID = customerID;
//        this.complaintText = complaintText;
//    }
//
//    // Getters and Setters
//    public int getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(int customerID) {
//        this.customerID = customerID;
//    }
//
//    public String getComplaintText() {
//        return complaintText;
//    }
//
//    public void setComplaintText(String complaintText) {
//        this.complaintText = complaintText;
//    }
//
//    public String viewComplaint(){
//        return "Customer ID: " +customerID+"Complaint: " +complaintText;
//        
//    }
//    @Override
//    public void saveToFile(){
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COMPLAINT_FILE, true))) {
//            oos.writeObject(this);
//            System.out.println("Complaint saved to file.");
//        } catch (IOException e) {
//            System.err.println("Error saving complaint: " + e.getMessage());
//        }
//    }
//
//    
//    @Override
//    public ArrayList<Complaint> readFromFile() {
//        ArrayList<Complaint> complaints = new ArrayList<>();
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(COMPLAINT_FILE))) {
//            while (true) {
//                try {
//                    Complaint complaint= (Complaint) ois.readObject();
//                    complaints.add(complaint);
//                } catch (EOFException e) {
//                    break; // End of file reached
//                }
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            System.err.println("Error loading ratings: " + e.getMessage());
//        }
//        return complaints;
//    }
//}
