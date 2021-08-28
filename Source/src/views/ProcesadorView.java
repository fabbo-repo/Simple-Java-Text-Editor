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
public class ProcesadorView {
    public static void main(String[] args) {
        MenuProcesador marco = new MenuProcesador();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MenuProcesador extends JFrame{
    public MenuProcesador(){
        setBounds(500,300,550,400);
        LaminaProcesador lamina = new LaminaProcesador();
        add(lamina);
        setVisible(true);
    }
}
class LaminaProcesador extends JPanel{
    public LaminaProcesador(){
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
        
        switch(menu) {
            case "fuente": font.add(elem_menu); break;
            case "estilo": style.add(elem_menu); break;
            case "tamaño": size.add(elem_menu); break;
            default: break;
        }
        
        elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
    }
    
    private class Gestiona_Eventos implements ActionListener{

        String tipo_texto, menu;
        int estilo_letra, tamagno_letra;
        
        Gestiona_Eventos(String elemento, String texto2, int estilo2, int tam_letra) {
            tipo_texto = texto2;
            estilo_letra = estilo2;
            tamagno_letra = tam_letra;
            menu = elemento;
        }
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
            area.setFont(new Font(tipo_texto,estilo_letra,tamagno_letra));
        }
        
    }
    
    JTextPane area;
    JMenu font, style, size;
    Font letters;
}