/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopprojfinal;

/**
 *
 * @author DELL
 */
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class DriverTracking extends JFrame {
    private WebView webView;
    private final Timer timer = new Timer();
    private final JFXPanel jfxPanel = new JFXPanel();

    public DriverTracking() {
        setTitle("Driver Tracking");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(jfxPanel, BorderLayout.CENTER);
        
        // Initialize JavaFX WebView in Swing
        Platform.runLater(this::initializeWebView);

        // Refresh the WebView every 10 seconds
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> refreshWebView());
            }
        }, 0, 10000); // 10000ms = 10 seconds
    }

    private void initializeWebView() {
        webView = new WebView();
        webView.getEngine().setJavaScriptEnabled(true);
        jfxPanel.setScene(new Scene(webView));
        showTrackingMap();
    }

    private void showTrackingMap() {
        webView.getEngine().load("https://cabrtapi.wckd.pk/showTrackingMap");
    }

    private void refreshWebView() {
        showTrackingMap(); // Reload the page with updated values
    }
public static void main(String[] args){
    SwingUtilities.invokeLater(() -> {
            DriverTracking trackingApp = new DriverTracking();
            trackingApp.setVisible(true);
        });
}
}