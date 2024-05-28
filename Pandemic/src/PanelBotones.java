
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class PanelBotones extends JPanel {
    public static double porcentajeActual1 = 0;
    public static double porcentajeActual2 = 0;
    public static double porcentajeActual3 = 0;
    public static double porcentajeActual4 = 0;


    public PanelBotones() {
        // Configura el diseño del panel principal
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Crear botones y etiquetas
        // Crear botones y etiquetas
        JButton boton1 = new JButton(new ImageIcon("vacuna amarilla.png"));
        JLabel porcentaje1 = new JLabel();
        porcentaje1.setText(porcentajeActual1 + "%");
        //si contador acciones es =4 se ponga contador acciones a 0

        JButton boton2 = new JButton(new ImageIcon("vacuna roja.png"));
        JLabel porcentaje2 = new JLabel();
        porcentaje1.setText(porcentajeActual2 + "%");

        JButton boton3 = new JButton(new ImageIcon("vacuna azul.png"));
        JLabel porcentaje3 = new JLabel();
        porcentaje1.setText(porcentajeActual3 + "%");

        JButton boton4 = new JButton(new ImageIcon("vacuna negra.png"));
        JLabel porcentaje4 = new JLabel();
        porcentaje1.setText(porcentajeActual4 + "%");

        // Configura los ActionListeners para incrementar los porcentajes
    boton1.addActionListener(new ActionListener() {
    @Override

    public void actionPerformed(ActionEvent e) {
        if (Mapa.contadorAcciones == 4) {
            incrementarPorcentaje(porcentaje1, 1);

            // si el porcentaje esta a 100% que no se gasten mas acciones
            if (porcentajeActual1 != 100) {
                Mapa.contadorAcciones=0;
            }
            Mapa.labelAcciones.setText("Acciones restantes: " + Mapa.contadorAcciones);
            if (porcentajeActual1 == 100 && porcentajeActual2 == 100 && porcentajeActual3 == 100 && porcentajeActual4 == 100) {
                System.out.println("Has ganado la partida");
                //ventana emergente de que has ganado
                JOptionPane.showMessageDialog(null, "Has ganado la partida ole tu ;)");
                System.exit(0);


            }
        }
    }
});

        boton2.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (Mapa.contadorAcciones == 4) {
                    incrementarPorcentaje(porcentaje2, 2);
                    if (porcentajeActual1 != 100) {
                        Mapa.contadorAcciones=0;
                    }
                    Mapa.labelAcciones.setText("Acciones restantes: " + Mapa.contadorAcciones);
                    //si las 4 estan al 100& has ganado la partida
                    if (porcentajeActual1 == 100 && porcentajeActual2 == 100 && porcentajeActual3 == 100 && porcentajeActual4 == 100) {
                        System.out.println("Has ganado la partida");
                        //ventana emergente de que has ganado
                        JOptionPane.showMessageDialog(null, "Has ganado la partida ole tu ;)");
                            System.exit(0);


                        }
                }

            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (Mapa.contadorAcciones == 4) {
                    incrementarPorcentaje(porcentaje3, 3);
                    //poner acciones a 0
                    if (porcentajeActual1 != 100) {
                        Mapa.contadorAcciones=0;
                    }

                    Mapa.labelAcciones.setText("Acciones restantes: " + Mapa.contadorAcciones);
                    if (porcentajeActual1 == 100 && porcentajeActual2 == 100 && porcentajeActual3 == 100 && porcentajeActual4 == 100) {
                        System.out.println("Has ganado la partida");
                        //ventana emergente de que has ganado
                        JOptionPane.showMessageDialog(null, "Has ganado la partida ole tu ;)");
                        System.exit(0);


                    }
                }
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                if (Mapa.contadorAcciones == 4) {
                    incrementarPorcentaje(porcentaje4, 4);
                    if (porcentajeActual1 != 100) {
                        Mapa.contadorAcciones=0;
                    }
                    Mapa.labelAcciones.setText("Acciones restantes: " + Mapa.contadorAcciones);
                    if (porcentajeActual1 == 100 && porcentajeActual2 == 100 && porcentajeActual3 == 100 && porcentajeActual4 == 100) {
                        System.out.println("Has ganado la partida");
                        //ventana emergente de que has ganado
                        JOptionPane.showMessageDialog(null, "Has ganado la partida ole tu ;)");
                        System.exit(0);


                    }
                }
            }
        });







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
        JButton curarButton1 = new JButton(new ImageIcon("tiritacura.png"));

        // Configura la acción del botón curar ciudad
        curarButton1.addActionListener(e -> {
            // Lógica para curar ciudad
            String nombreciudad = Mapa.botonselecionado.getText();
            // Busca la ciudad en la lista de ciudades
            for (Ciudad ciudad :Mapa.ciudadesarrylist) {
                if (ciudad.getNombre().equals(nombreciudad)) {
                    // Curar la ciudad si la infeccion es mayor que 0
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
    private void incrementarPorcentaje(JLabel porcentaje, int indice ) {
        double incremento = 25.0;
        // si el porcentaje llega a 100 que no se gasten mas acciones

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
        // Incrementa el porcentaje según el índice

    }
