import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal {
        public static void main(String[] args) {
        // Crear el marco (ventana)
        JFrame marco = new JFrame("Menú Principal");
        marco.setSize(1000, 1000);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Usar GridBagLayout para el panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Crear la barra de menú
        JMenuBar barraMenu = new JMenuBar();
        
        // Crear los menús "Partida" y "Menú"
        JMenu menuPartida = new JMenu("Partida");
        JMenu menuMenu = new JMenu("Menú");
        
        // Crear los elementos del menú "Partida"
        JMenuItem itemNuevaPartida = new JMenuItem("Nueva Partida");
        JMenuItem itemCargarPartida = new JMenuItem("Cargar Partida");
        JMenuItem itemResumenPuntuaciones = new JMenuItem("Resumen de Puntuaciones");
        JMenuItem itemInformacion = new JMenuItem("Información");
        
        // Crear los elementos del menú "Menú"
        JMenuItem itemAutores = new JMenuItem("Autores");
        JMenuItem itemVersion = new JMenuItem("Versión");
        JMenuItem itemSalir = new JMenuItem("Salir");
        
        // Agregar elementos al menú "Partida"
        menuPartida.add(itemNuevaPartida);
        menuPartida.add(itemCargarPartida);
        menuPartida.add(itemResumenPuntuaciones);
        menuPartida.add(itemInformacion);
        
        // Agregar elementos al menú "Menú"
        menuMenu.add(itemAutores);
        menuMenu.add(itemVersion);
        menuMenu.addSeparator();
        menuMenu.add(itemSalir);
        
        // Agregar los menús a la barra de menú
        barraMenu.add(menuPartida);
        barraMenu.add(menuMenu);
        
        // Asociar la barra de menú al panel
        panel.add(barraMenu, gbc);
        
        // Agregar el panel al marco
        marco.add(panel);
        
        // Agregar acciones a los elementos de los menús
        itemNuevaPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funcionalidad Nueva Partida en desarrollo...");
            }
        });
        
        itemCargarPartida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funcionalidad Cargar Partida en desarrollo...");
            }
        });
        
        itemResumenPuntuaciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Funcionalidad Resumen de Puntuaciones en desarrollo...");
            }
        });
        
        // Modificar la acción para el elemento de menú "Información"
        itemInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoInformacion = "Requisitos Funcionales:\n" +
                    "Gestión de Ciudades:\n" +
                    "● Permitir la creación de ciudades con su nombre, coordenadas (X, Y) y enfermedad principal.\n" +
                    "● Capacidad para establecer diferentes niveles de infección para cada ciudad, con valores de 0 a 3.\n" +
                    "● Mantener un registro de las ciudades adyacentes a cada ciudad.\n" +
                    "● Incrementar en 1 el nivel de infección de una ciudad infectada en cada ronda.\n" +
                    "● Propagar la enfermedad a ciudades adyacentes si el nivel de infección supera 3, aumentando el contador de brotes.\n" +
                    "Gestión de Partidas:\n" +
                    "● Asignar un número de partida a cada sesión de juego.\n" +
                    "● Mantener una lista de ciudades y vacunas disponibles en cada partida.\n" +
                    "● Permitir operaciones como investigar sobre la vacuna de una ciudad.\n" +
                    "● Limitar al jugador a 4 acciones por ronda.\n" +
                    "● Incrementar el porcentaje de desarrollo de la vacuna en un 25% después de 4 acciones dedicadas a la investigación.\n" +
                    "● Reducir el nivel de enfermedad de una ciudad al curarla, disminuyendo a 2 si el nivel era 3 y no hay vacuna desarrollada.\n" +
                    "● Determinar si el jugador ha ganado, perdido o el resultado es indeterminado al finalizar cada ronda.\n" +
                    "● Reducir el nivel de infección a 0 si la vacuna está desarrollada al 100% para una ciudad.\n" +
                    "Gestión de Vacunas:\n" +
                    "● Asignar un identificador de color y un porcentaje de desarrollo a cada vacuna.\n" +
                    "● Permitir el aumento del desarrollo de la vacuna en un 25% cada 4 acciones dedicadas a su investigación, hasta alcanzar el 100%.\n" +
                    "Requisitos No Funcionales:\n" +
                    "Interfaz de Usuario:\n" +
                    "● Debe ser amigable e intuitiva para un jugador de cualquier edad (12-99 años).\n" +
                    "● Soportar múltiples idiomas (opcional) para adaptarse a diversos usuarios.\n" +
                    "● Permitir la adición de mecánicas adicionales para extender la jugabilidad.\n" +
                    "Desempeño:\n" +
                    "● Mantener una respuesta fluida y sin retrasos para una experiencia de juego óptima.\n" +
                    "Configuración:\n" +
                    "● Permitir al usuario configurar el número de ciudades infectadas, el número de ciudades infectadas en cada ronda y el número de enfermedades activas para cada partida.\n" +
                    "Desarrollo de la Vacuna:\n" +
                    "● Asegurar que el desarrollo de la vacuna siga un proceso realista y proporcione un desafío equilibrado para el jugador.";
                
                JOptionPane.showMessageDialog(null, textoInformacion);
            }
        });
        itemAutores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Autores:\n\n" +
                                                        "Joan Banlles (CEO)\n" +
                                                        "Miquel Simo (CEO 2)\n" +
                                                        "Alejandro Paris (no se entera de na)\n\n" +
                                                        "Contacto: joanbanlles6@gmail.com");
            }
        });
        
        itemVersion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Versión 1.0");
            }
        });
        
        itemSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        // Centrar el marco en la pantalla
        marco.setLocationRelativeTo(null);
        
        // Hacer visible el marco
        marco.setVisible(true);
    }
}