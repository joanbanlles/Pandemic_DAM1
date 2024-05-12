import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Mapa extends JFrame {
    public static ArrayList<JButton> botonesCiudad = new ArrayList<>();

    public static ArrayList <Ciudad> ciudadesarrylist = new ArrayList<>();

    public static Datos_partida dp = new Datos_partida();

    public static JButton botonselecionado;
    // crear numCuidadesInfectadasRonda, numEnfermedadesActivasDerrota, numBrotesDerrota, incrementoporcentajevacuna, numCiudadesInfectadasInicio

    public Mapa() {
        // Configuración de la ventana principal
        setTitle("Mapa del Mundo");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dp.cargarDatos();



        // Configuración del BorderLayout
        setLayout(new BorderLayout());

        // Cargar la imagen del mapa
        ImageIcon mapaImagen = new ImageIcon("mapa_mundo.png");

        // Obtener dimensiones originales y escalar imagen
        int imagenAncho = mapaImagen.getIconWidth();
        int imagenAlto = mapaImagen.getIconHeight();

        double aspectRatio = (double) imagenAncho / imagenAlto;
        int nuevoAncho, nuevoAlto;

        if (getWidth() / aspectRatio < getHeight()) {
            nuevoAncho = getWidth();
            nuevoAlto = (int) (getWidth() / aspectRatio);
        } else {
            nuevoAlto = getHeight();
            nuevoAncho = (int) (nuevoAlto * aspectRatio);
        }

        Image imagenEscalada = mapaImagen.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

        JLabel mapaLabel = new JLabel(new ImageIcon(imagenEscalada));
        mapaLabel.setLayout(null); // Establecer layout nulo para posicionar los botones de forma específica

        crearArrayCiudades(ciudadesarrylist);


        // Crear botones para cada ciudad
        for (Ciudad ciudad : ciudadesarrylist) {
            JButton botonCiudad = new JButton(ciudad.getNombre());
            botonCiudad.setBounds(ciudad.getCoords()[0], ciudad.getCoords()[1], 25, 25); // Tamaño del botón reducido y cuadrado
            botonesCiudad.add(botonCiudad);
            mapaLabel.add(botonCiudad);

        }


        for (int i = 0; i < ciudadesarrylist.size(); i++) {
            Ciudad ciudad = ciudadesarrylist.get(i);
            JButton botonCiudad = botonesCiudad.get(i);


            ImageIcon icon = null;

            switch (ciudad.getEnfermedad()) {
                case "Alfa":
                    icon = new ImageIcon("0 azul.png");
                    break;
                case "Beta":
                    icon = new ImageIcon("0 rojo.png");
                    break;
                case "Gama":
                    icon = new ImageIcon("0 negro.png");
                    break;
                case "Delta":
                    icon = new ImageIcon("0 amarillo.png");
                    break;
                default:
                    // Opcional: puedes manejar el caso en que la enfermedad no sea ninguna de las esperadas
                    break;
            }

            if (icon != null) {
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(botonCiudad.getWidth(), botonCiudad.getHeight(), java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                botonCiudad.setIcon(icon);
            }
        }
        //cuando se pulsa un boton este boton se pone boton selecionado
        for (JButton boton : botonesCiudad) {
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    botonselecionado = boton;
                    System.out.println("Boton seleccionado: " + botonselecionado.getText());
                }
            });
        }




                    // Crear paneles
                    JPanel panelIzquierdo = new JPanel();
                    panelIzquierdo.setPreferredSize(new Dimension(150, 0));

                    JPanel panelDerecho = new PanelBotones(); // Utilizar el panel de botones personalizado
                    panelDerecho.setPreferredSize(new Dimension(150, 0));

                    JPanel panelInferior = new JPanel(new GridBagLayout()); // Utilizar GridBagLayout
                    panelInferior.setPreferredSize(new Dimension(0, 190));

                    // Crear los botones "Guardar Partida" y "Pasar Turno"
                    JButton guardarPartidaButton = new JButton("Guardar Partida");
                    guardarPartidaButton.setPreferredSize(new Dimension(180, 50)); // Tamaño más grande
                    JButton pasarTurnoButton = new JButton("Pasar Turno");
                    pasarTurnoButton.setPreferredSize(new Dimension(150, 140)); // Tamaño más grande

                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(10, 10, 10, 10); // Margen entre componentes

                    // Espaciador a la izquierda para dividir el panel en tres partes
                    gbc.gridx = 0; // Primera columna
                    gbc.weightx = 1.0; // Peso para expandir a lo largo
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    panelInferior.add(new JPanel(), gbc); // Espaciador para la parte izquierda

                    // Colocar el botón "Pasar Turno" en el centro
                    gbc.gridx = 1; // Segunda columna
                    gbc.weightx = 0; // No expandir
                    panelInferior.add(pasarTurnoButton, gbc);

                    // Espaciador entre los botones
                    gbc.gridx = 2; // Tercera columna
                    gbc.weightx = 1.0; // Peso para expandir
                    panelInferior.add(new JPanel(), gbc); // Espaciador para la parte central

                    // Colocar el botón "Guardar Partida" en la derecha
                    gbc.gridx = 3; // Cuarta columna
                    gbc.weightx = 0; // No expandir
                    panelInferior.add(guardarPartidaButton, gbc);


                    // Añadir acciones a los botones
                    guardarPartidaButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Guardar Partida presionado");
                        }
                    });

                    pasarTurnoButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("Pasar Turno presionado");
                        }
                    });

                    // Añadir componentes al marco
                    add(panelIzquierdo, BorderLayout.WEST);
                    add(panelDerecho, BorderLayout.EAST);
                    add(panelInferior, BorderLayout.SOUTH);
                    add(mapaLabel, BorderLayout.CENTER);

                    setVisible(true);


        infectarCiudadesInicio();

    }


public static void infectarCiudadesInicio(){
        ArrayList<Ciudad> infectadas = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < dp.numCiudadesInfectadasInicio; i++) {
            int int_random = rand.nextInt(0, ciudadesarrylist.size() );
            ciudadesarrylist.get(int_random).setInfeccion(ciudadesarrylist.get(int_random).getInfeccion() + 1);
            infectadas.add(ciudadesarrylist.get(int_random));
        }

        //switch para cambiar el icono de la ciudad infectada
        for (Ciudad ciudad : infectadas) {
            JButton botonCiudad = botonesCiudad.get(ciudadesarrylist.indexOf(ciudad));
            ImageIcon icon = null;

            switch (ciudad.getEnfermedad()) {
                case "Alfa":
                    icon = new ImageIcon("1 azul.png");
                    break;
                case "Beta":
                    icon = new ImageIcon("1 rojo.png");
                    break;
                case "Gama":
                    icon = new ImageIcon("1 negro.png");
                    break;
                case "Delta":
                    icon = new ImageIcon("1 amarillo.png");
                    break;
                default:
                    // Opcional: puedes manejar el caso en que la enfermedad no sea ninguna de las esperadas
                    break;
            }
            
        }
        //printear el nombre de las ciudades infectadas
    for (int i = 0; i < infectadas.size(); i++) {
        System.out.println(infectadas.get(i).getNombre()) ;
    }


}

public static void crearArrayCiudades(ArrayList<Ciudad> ciudadesarrylist) {
        String linea = "";

        String nombreFichero = "ciudades.txt";
        try {
            // Creamos un objeto de tipo FileReader para abrir un fichero de lectura
            FileReader fileReader = new FileReader(nombreFichero);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            do {
                // Leemos el contenido del fichero
                linea = bufferedReader.readLine();
                if (linea != null) {

                    ciudadesarrylist.add(TxtCiudades.asignarCiudades(linea));

                }

            } while (linea != null);
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Ha habido un error al intentar abrir el fichero" + e);
        }

    }

}




