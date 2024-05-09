
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class PanelBotones extends JPanel {
    public PanelBotones() {
        // Usar un GridLayout para colocar los botones uno debajo del otro
        setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas, 1 columna, espacio entre botones

 

        // Crear cuatro botones con imágenes
        JButton boton1 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna amarilla.png"));
        JButton boton2 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna roja.png"));
        JButton boton3 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna azul.png"));
        JButton boton4 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna negra.png"));

        JButton boton5 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\tiritacura.png"));

        // Añadir acción a los botones (ejemplo simple)
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 1 presionado");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 2 presionado");
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 3 presionado");
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 4 presionado");
            }
        });
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 4 presionado");
            }
        });

        // Añadir botones al panel
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
    }
}