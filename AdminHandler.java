/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

/**
 *
 * @author DELL
 */
import java.io.*;
public class AdminHandler extends FileHandlerCM implements Serializable {
    private static final String filename="adminfile.txt";
    
    public AdminHandler(){
        super(filename);
    }
}
