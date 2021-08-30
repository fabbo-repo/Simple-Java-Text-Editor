/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import views.ProcessingMenu;

/**
 *
 * @author Fabbo
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Starting...");
        
        /* Create and display the MainWindow */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcessingMenu().setVisible(true);
            }
        });
    }
}