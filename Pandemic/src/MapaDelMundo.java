package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MapaDelMundo extends JFrame {
    private MapPanel mapPanel;

    public MapaDelMundo() {
    	
        setTitle("Mapa del Mundo");
        setSize(1366, 768); // Tamaño de la pantalla estándar
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear el panel de mapa
        mapPanel = new MapPanel();
        add(mapPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MapaDelMundo::new);
    }
}
