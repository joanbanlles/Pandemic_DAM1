
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class PanelBotones extends JPanel {
    private double porcentajeActual1 = 0.0;
    private double porcentajeActual2 = 0.0;
    private double porcentajeActual3 = 0.0;
    private double porcentajeActual4 = 0.0;

    public PanelBotones() {
        // Configura el diseño del panel principal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Crear botones y etiquetas
// Crear botones y etiquetas
JButton boton1 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna amarilla.png"));
JLabel porcentaje1 = new JLabel(String.format("%.2f%%", porcentajeActual1));

JButton boton2 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna roja.png"));
JLabel porcentaje2 = new JLabel(String.format("%.2f%%", porcentajeActual2));

JButton boton3 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna azul.png"));
JLabel porcentaje3 = new JLabel(String.format("%.2f%%", porcentajeActual3));

JButton boton4 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\vacuna negra.png"));
JLabel porcentaje4 = new JLabel(String.format("%.2f%%", porcentajeActual4));

        // Configura los ActionListeners para incrementar los porcentajes
        boton1.addActionListener(e -> incrementarPorcentaje(porcentaje1, 1));
        boton2.addActionListener(e -> incrementarPorcentaje(porcentaje2, 2));
        boton3.addActionListener(e -> incrementarPorcentaje(porcentaje3, 3));
        boton4.addActionListener(e -> incrementarPorcentaje(porcentaje4, 4));

        // Crear paneles para cada botón y su etiqueta de porcentaje
        JPanel panelBoton1 = crearPanelConBotonYPorcentaje(boton1, porcentaje1);
        JPanel panelBoton2 = crearPanelConBotonYPorcentaje(boton2, porcentaje2);
        JPanel panelBoton3 = crearPanelConBotonYPorcentaje(boton3, porcentaje3);
        JPanel panelBoton4 = crearPanelConBotonYPorcentaje(boton4, porcentaje4);

        // Añade los paneles al panel principal
        add(panelBoton1);
        add(panelBoton2);
        add(panelBoton3);
        add(panelBoton4);

        // Crear el botón curar ciudad
        JButton curarButton1 = new JButton(new ImageIcon("C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\tiritacura.png"));
        
        // Configura la acción del botón curar ciudad
        curarButton1.addActionListener(e -> {
            // Lógica para curar ciudad
        });
        
        // Añade el botón curar ciudad al final del panel
        add(curarButton1);
        // Añade un JLabel vacío al final para mantener el diseño simétrico
        add(new JLabel());
    }

    // Método para crear un panel con un botón y su etiqueta de porcentaje
    private JPanel crearPanelConBotonYPorcentaje(JButton boton, JLabel porcentaje) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        panel.add(boton);
        panel.add(porcentaje);
        return panel;
    }

    // Método para incrementar el porcentaje de una etiqueta específica
    private void incrementarPorcentaje(JLabel porcentaje, int indice) {
        double incremento = 25.0;

        // Incrementa el porcentaje según el índice
        switch (indice) {
            case 1:
                porcentajeActual1 = Math.min(porcentajeActual1 + incremento, 100);
                porcentaje.setText(String.format("%.2f%%", porcentajeActual1));
                break;
            case 2:
                porcentajeActual2 = Math.min(porcentajeActual2 + incremento, 100);
                porcentaje.setText(String.format("%.2f%%", porcentajeActual2));
                break;
            case 3:
                porcentajeActual3 = Math.min(porcentajeActual3 + incremento, 100);
                porcentaje.setText(String.format("%.2f%%", porcentajeActual3));
                break;
            case 4:
                porcentajeActual4 = Math.min(porcentajeActual4 + incremento, 100);
                porcentaje.setText(String.format("%.2f%%", porcentajeActual4));
                break;
        }
    }
}