<<<<<<< Updated upstream
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class PanelBotones extends JPanel {
    public PanelBotones() {
        // Usar un GridLayout para colocar los botones uno debajo del otro
        setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas, 1 columna, espacio entre botones
=======
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase para el panel de botones a la derecha
class PanelBotones extends JPanel {
    public PanelBotones() {
        // Usar un GridLayout para colocar los botones uno debajo del otro
        setLayout(new GridLayout(4, 1, 10, 10)); // 4 filas, 1 columna, espacio entre botones
>>>>>>> Stashed changes

        // Crear cuatro botones con imágenes
        JButton boton1 = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna amarilla.png"));
        JButton boton2 = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna roja.png"));
        JButton boton3 = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna azul.png"));
        JButton boton4 = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna negra.png"));
<<<<<<< Updated upstream
        JButton boton5 = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\tiritacura.png"));
=======

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón 4 presionado");
            }
        });
=======

>>>>>>> Stashed changes
        // Añadir botones al panel
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
<<<<<<< Updated upstream
        add(boton5);
=======
>>>>>>> Stashed changes
    }
}