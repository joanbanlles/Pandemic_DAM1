import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

class Ciudad {
    private String nombre;
    int nivelInfeccion;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.nivelInfeccion = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelInfeccion() {
        return nivelInfeccion;
    }

    public void curar() {
        if (nivelInfeccion > 0) {
            nivelInfeccion--;
        }
    }

    @Override
    public String toString() {
        return nombre + " - Infección: " + nivelInfeccion;
    }
}

class Partida {
    private List<Ciudad> ciudades;
    private int desarrolloVacuna; // Rango de 0 a 100
    private int rondas;

    public Partida() {
        this.ciudades = new ArrayList<>();
        this.ciudades.add(new Ciudad("Ciudad1"));
        this.ciudades.add(new Ciudad("Ciudad2"));
        this.ciudades.add(new Ciudad("Ciudad3"));
        this.ciudades.add(new Ciudad("Ciudad4"));
        this.desarrolloVacuna = 0;
        this.rondas = 0;
    }

    public void curarCiudad(int indiceCiudad) {
        if (indiceCiudad >= 0 && indiceCiudad < ciudades.size()) {
            ciudades.get(indiceCiudad).curar();
        }
    }

    public void desarrollarVacuna() {
        if (desarrolloVacuna < 100) {
            desarrolloVacuna++;
        }
    }

    public void guardarPartida(String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write("Rondas: " + rondas + "\n");
            writer.write("Desarrollo de la vacuna: " + desarrolloVacuna + "\n");
            writer.write("Ciudades:\n");
            for (Ciudad ciudad : ciudades) {
                writer.write(ciudad.getNombre() + "," + ciudad.getNivelInfeccion() + "\n");
            }
        }
    }

    public void cargarPartida(String archivo) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            rondas = Integer.parseInt(reader.readLine().split(": ")[1]);
            desarrolloVacuna = Integer.parseInt(reader.readLine().split(": ")[1]);
            ciudades.clear();
            reader.readLine(); // Salta la línea de "Ciudades:"
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombreCiudad = partes[0];
                int nivelInfeccion = Integer.parseInt(partes[1]);
                Ciudad ciudad = new Ciudad(nombreCiudad);
                ciudad.nivelInfeccion = nivelInfeccion;
                ciudades.add(ciudad);
            }
        }
    }

    public void finalizarTurno() {
        rondas++;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public int getRondas() {
        return rondas;
    }

    public int getDesarrolloVacuna() {
        return desarrolloVacuna;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JuegoSwing::new);
    }
}

public class JuegoSwing {
	
    private JFrame frame;
    private JTextArea estadoTextArea;
    private JTextField rondaTextField;
    private JTextField desarrolloVacunaTextField;
    private Partida partida;

    public JuegoSwing() {
        partida = new Partida();
        frame = new JFrame("Juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Resto del código de la clase JuegoSwing...
    

        // Panel para mostrar el estado
        estadoTextArea = new JTextArea(10, 30);
        estadoTextArea.setEditable(false);
        JScrollPane estadoScrollPane = new JScrollPane(estadoTextArea);
        frame.add(estadoScrollPane, BorderLayout.CENTER);

        // Panel para la entrada y los botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(2, 2));

        JLabel rondaLabel = new JLabel("Ronda:");
        rondaTextField = new JTextField();
        rondaTextField.setEditable(false);
        rondaTextField.setText(String.valueOf(partida.getRondas()));

        JLabel desarrolloVacunaLabel = new JLabel("Desarrollo de la vacuna:");
        desarrolloVacunaTextField = new JTextField();
        desarrolloVacunaTextField.setEditable(false);
        desarrolloVacunaTextField.setText(String.valueOf(partida.getDesarrolloVacuna()));

        panelSuperior.add(rondaLabel);
        panelSuperior.add(rondaTextField);
        panelSuperior.add(desarrolloVacunaLabel);
        panelSuperior.add(desarrolloVacunaTextField);

        panel.add(panelSuperior);

        // Panel inferior para los botones
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(1, 5));

        JButton curarButton = new JButton("Curar ciudad");
        curarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ciudadCurada = false;
                while (!ciudadCurada) {
                    try {
                        String ciudadString = JOptionPane.showInputDialog(frame, "Ingrese el índice de la ciudad a curar (0-3):");
                        if (ciudadString == null) {
                            // El usuario canceló la entrada.
                            return;
                        }

                        int indiceCiudad = Integer.parseInt(ciudadString);

                        if (indiceCiudad >= 0 && indiceCiudad < partida.getCiudades().size()) {
                            partida.curarCiudad(indiceCiudad);
                            ciudadCurada = true;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Índice fuera de rango. Por favor, ingrese un número entre 0 y 3.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Entrada inválida. Por favor, ingrese un número entero entre 0 y 3.");
                    }
                }
                actualizarEstado();
            }
        });

        JButton desarrollarButton = new JButton("Desarrollar vacuna");
        desarrollarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                partida.desarrollarVacuna();
                actualizarEstado();
            }
        });

        JButton guardarButton = new JButton("Guardar partida");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    partida.guardarPartida("partida.txt");
                    JOptionPane.showMessageDialog(frame, "Partida guardada.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error al guardar la partida.");
                }
            }
        });

        JButton cargarButton = new JButton("Cargar partida");
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    partida.cargarPartida("partida.txt");
                    JOptionPane.showMessageDialog(frame, "Partida cargada.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error al cargar la partida.");
                }
                actualizarEstado();
            }
        });

        JButton finalizarButton = new JButton("Finalizar turno");
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                partida.finalizarTurno();
                actualizarEstado();
            }
        });

        panelInferior.add(curarButton);
        panelInferior.add(desarrollarButton);
        panelInferior.add(guardarButton);
        panelInferior.add(cargarButton);
        panelInferior.add(finalizarButton);

        panel.add(panelInferior);

        frame.add(panel, BorderLayout.SOUTH);

        // Configurar el tamaño y visibilidad de la ventana
        frame.pack();
        frame.setVisible(true);

        actualizarEstado();
    }
    

    private void actualizarEstado() {
        // Actualizar el área de texto con el estado actual del juego
        StringBuilder estado = new StringBuilder();
        estado.append("Ronda: ").append(partida.getRondas()).append("\n");
        estado.append("Desarrollo de la vacuna: ").append(partida.getDesarrolloVacuna()).append("\n");
        estado.append("Ciudades:\n");
        for (Ciudad ciudad : partida.getCiudades()) {
            estado.append(ciudad).append("\n");
        }
        estadoTextArea.setText(estado.toString());

        // Actualizar los campos de texto con el estado actual
        rondaTextField.setText(String.valueOf(partida.getRondas()));
        desarrolloVacunaTextField.setText(String.valueOf(partida.getDesarrolloVacuna()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JuegoSwing::new);
    }
}
