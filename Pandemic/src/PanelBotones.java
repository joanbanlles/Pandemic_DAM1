import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// Definición de la clase PanelBotones
class PanelBotones extends JPanel {
    // Variables estáticas para los porcentajes actuales de cada botón
    public static double porcentajeActual1 = 0;
    public static double porcentajeActual2 = 0;
    public static double porcentajeActual3 = 0;
    public static double porcentajeActual4 = 0;

    // Constructor de la clase
    public PanelBotones() {
        // Configura el diseño del panel principal como BoxLayout vertical
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Crear botones y etiquetas para cada vacuna
        JButton boton1 = new JButton(new ImageIcon("vacuna amarilla.png"));
        JLabel porcentaje1 = new JLabel();
        porcentaje1.setText(porcentajeActual1 + "%");

        JButton boton2 = new JButton(new ImageIcon("vacuna roja.png"));
        JLabel porcentaje2 = new JLabel();
        porcentaje2.setText(porcentajeActual2 + "%");

        JButton boton3 = new JButton(new ImageIcon("vacuna azul.png"));
        JLabel porcentaje3 = new JLabel();
        porcentaje3.setText(porcentajeActual3 + "%");

        JButton boton4 = new JButton(new ImageIcon("vacuna negra.png"));
        JLabel porcentaje4 = new JLabel();
        porcentaje4.setText(porcentajeActual4 + "%");

        // Configurar ActionListeners para los botones de las vacunas
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Mapa.contadorAcciones == 4) {
                    incrementarPorcentaje(porcentaje1, 1);
                    Mapa.labelAcciones.setText("Acciones restantes: " + Mapa.contadorAcciones);
                    if (porcentajeActual1 == 100 && porcentajeActual2 == 100 && porcentajeActual3 == 100 && porcentajeActual4 == 100) {
                        System.out.println("Has ganado la partida");
                        JOptionPane.showMessageDialog(null, "Has ganado la partida ole tu ;)");
                        System.exit(0);
                    }
                }
            }
        });

        // Configurar ActionListeners para el resto de botones de vacunas (boton2, boton3, boton4)

        // Crear paneles para cada botón y su etiqueta de porcentaje
        JPanel panelBoton1 = crearPanelConBotonYPorcentaje(boton1, porcentaje1);
        JPanel panelBoton2 = crearPanelConBotonYPorcentaje(boton2, porcentaje2);
        JPanel panelBoton3 = crearPanelConBotonYPorcentaje(boton3, porcentaje3);
        JPanel panelBoton4 = crearPanelConBotonYPorcentaje(boton4, porcentaje4);

        // Añadir los paneles al panel principal
        add(panelBoton1);
        add(panelBoton2);
        add(panelBoton3);
        add(panelBoton4);

        // Crear el botón "Curar Ciudad"
        JButton curarButton1 = new JButton(new ImageIcon("tiritacura.png"));

        // Configurar la acción del botón "Curar Ciudad"
        curarButton1.addActionListener(e -> {
            // Lógica para curar ciudad
            String nombreciudad = Mapa.botonselecionado.getText();
            for (Ciudad ciudad : Mapa.ciudadesarrylist) {
                if (ciudad.getNombre().equals(nombreciudad)) {
                    if (ciudad.getInfeccion() > 0) {
                        ciudad.curarciudad();
                        if (Mapa.contadorAcciones >=1) {
                            Mapa.contadorAcciones--;
                            Mapa.labelAcciones.setText("Acciones restantes: " + Mapa.contadorAcciones);
                        }
                    }
                    break;
                }
            }
        });

        // Añadir el botón "Curar Ciudad" al final del panel
        add(curarButton1);
        // Añadir un JLabel vacío al final para mantener el diseño simétrico
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
    private void incrementarPorcentaje(JLabel porcentaje, int indice ) {
        double incremento = 25.0;
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
