/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.text.*;
/**
 *
 * @author maria
 */

public class ProcessingMenu extends JFrame{
    public ProcessingMenu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500,300,550,400);
        ProcessingPanel lamina = new ProcessingPanel();
        this.add(lamina);
        this.setVisible(true);
    }
}

class ProcessingPanel extends JPanel{
    public ProcessingPanel(){
        setLayout(new BorderLayout());
        
        JPanel laminaMenu = new JPanel();
        
        JMenuBar barra = new JMenuBar();
        
        font = new JMenu("Fuente");
        style = new JMenu("Estilo");
        size = new JMenu("Tamaño");

        //-------------------------------------------------
        
        configura_menu("Arial","fuente","Arial",9,10);
        configura_menu("Courier","fuente","Courier",9,10);
        configura_menu("Verdana","fuente","Verdana",9,10);
        
        configura_menu("Bold","estilo","",Font.BOLD,10);
        configura_menu("Italic","estilo","",Font.ITALIC,10);
        
        configura_menu("12","tamaño","",9,12);
        configura_menu("16","tamaño","",9,16);
        configura_menu("20","tamaño","",9,20);
        configura_menu("24","tamaño","",9,24);
        
        //-------------------------------------------------
        
        barra.add(font);
        barra.add(style);
        barra.add(size);
        
        laminaMenu.add(barra);
        
        add(laminaMenu,BorderLayout.NORTH);
        
        
        area = new JTextPane();
        
        add(area,BorderLayout.CENTER);
        
    }
    
    public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam){
        JMenuItem elem_menu = new JMenuItem(rotulo);
        
        if(menu.equals("fuente")) {
            font.add(elem_menu);
            
            if(tipo_letra.equals("Arial")){
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra","Arial"));
            } else if(tipo_letra.equals("Courier")){
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra","Courier"));
            } else if(tipo_letra.equals("Verdana")){
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra","Verdana"));
            }
            
        } else if(menu.equals("estilo")){
            style.add(elem_menu); 
            
            if(estilos==Font.BOLD){
                elem_menu.addActionListener(new StyledEditorKit.BoldAction());
            } else if(estilos==Font.ITALIC){
                elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
            }
            
        } else if(menu.equals("tamaño")){
            size.add(elem_menu); 
            
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño",tam));
        }
    }
    
    JTextPane area;
    JMenu font, style, size;
    Font letters;
}