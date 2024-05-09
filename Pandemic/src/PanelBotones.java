
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class PanelBotones extends JPanel {
    // Declarar panelInferior como variable de instancia
    private JPanel panelInferior;

    public PanelBotones() {
        // Configura el diseño del panel principal
        setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas, 1 columna, espacio entre botones

        // Inicializa panelInferior con una instancia de JPanel o Container
        panelInferior = new JPanel();  // Podrías usar GridLayout u otro Layout

        // Crear botones
        JButton boton1 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna amarilla.png"));
        JButton boton2 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna roja.png"));
        JButton boton3 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna azul.png"));
        JButton boton4 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna negra.png"));
        JButton curarButton1 = new JButton(new ImageIcon("C:\\Users\\SPK Pc Gaming\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\tiritacura.png"));

        // Añadir acción a los botones
        boton1.addActionListener(e -> System.out.println("Botón 1 presionado"));
        boton2.addActionListener(e -> System.out.println("Botón 2 presionado"));
        boton3.addActionListener(e -> System.out.println("Botón 3 presionado"));
        boton4.addActionListener(e -> System.out.println("Botón 4 presionado"));

        // Crea un botón curar ciudad

        
        curarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para curar ciudad
            }
        });

        // Añade el botón curar ciudad al panel principal (PanelBotones)
        add(curarButton1);

        // Añadir otros botones al panel principal
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(curarButton1);
    }
}
