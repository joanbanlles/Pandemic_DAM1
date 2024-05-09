
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class PanelBotones extends JPanel {

    public PanelBotones() {
        // Configura el diseño del panel principal
        setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas, 2 columnas, espacio entre componentes

        // Crear botones
        JButton boton1 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna amarilla.png"));
        JButton boton2 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna roja.png"));
        JButton boton3 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna azul.png"));
        JButton boton4 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna negra.png"));
        JButton curarButton1 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\tiritacura.png"));
        Dimension size = new Dimension (200,130);
        boton1.setPreferredSize(size);
        boton2.setPreferredSize(size);
        boton3.setPreferredSize(size);
        boton4.setPreferredSize(size);

        // Crear etiquetas de porcentaje
        JLabel porcentaje1 = new JLabel("0%");
        JLabel porcentaje2 = new JLabel("0%");
        JLabel porcentaje3 = new JLabel("0%");
        JLabel porcentaje4 = new JLabel("0%");

        // Añadir acción a los botones
        boton1.addActionListener(e -> System.out.println("Botón 1 presionado"));
        boton2.addActionListener(e -> System.out.println("Botón 2 presionado"));
        boton3.addActionListener(e -> System.out.println("Botón 3 presionado"));
        boton4.addActionListener(e -> System.out.println("Botón 4 presionado"));
        
        // Añade los botones y sus etiquetas de porcentaje correspondientes al panel principal
        add(boton1);
        add(porcentaje1);
        add(boton2);
        add(porcentaje2);
        add(boton3);
        add(porcentaje3);
        add(boton4);
        add(porcentaje4);
        
        // Configura la acción del botón curar ciudad
        curarButton1.addActionListener(e -> {
            // Lógica para curar ciudad
        });

        // Añade el botón curar ciudad al final del panel
        add(curarButton1);
        // Añade un JLabel vacío al final para mantener el diseño simétrico
        add(new JLabel());
    }
}