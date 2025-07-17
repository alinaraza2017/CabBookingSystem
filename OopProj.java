/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

//anna munir
package com.mycompany.oopprojfinal;

/**
 *
 * @author annam sc
 */

import javax.swing.SwingUtilities;

public class OopProj {
    public static void main(String[] args){
    
        
        
    SwingUtilities.invokeLater(() -> {
            DashBoardMain trackingApp = new DashBoardMain();
            trackingApp.setVisible(true);
        });
    }
}