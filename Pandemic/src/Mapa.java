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
    public static int contadorAcciones = 0;
    public static int contadorBrotes = 0;
    public static int contadorRondas = 0;
    public static JLabel labelAcciones;
    public static JLabel labelBrotes;
    public static JLabel labelRondas;
    public static ArrayList<JButton> botonesCiudad = new ArrayList<>();

    public static ArrayList<Ciudad> ciudadesarrylist = new ArrayList<>();

    public static Datos_partida dp = new Datos_partida();

    public static JButton botonselecionado;
    // crear numCuidadesInfectadasRonda, numEnfermedadesActivasDerrota, numBrotesDerrota, incrementoporcentajevacuna, numCiudadesInfectadasInicio

    public Mapa(String dificultad) {

        NewGameSubMenu.GameParameters params = NewGameSubMenu.loadGameParameters(dificultad);
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
        //action listener de pasar turno
        pasarTurnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasarTurno(params.getCiudadesRonda());
            }
        });
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
        // Crear JLabels para los contadores
        labelAcciones = new JLabel("Acciones: " + contadorAcciones);
        labelBrotes = new JLabel("Brotes: " + contadorBrotes);
        labelRondas = new JLabel("Rondas: " + contadorRondas);

        // Crear un panel para los JLabels
        JPanel panelContadores = new JPanel();
        panelContadores.setLayout(new BoxLayout(panelContadores, BoxLayout.Y_AXIS));
        panelContadores.add(labelAcciones);
        panelContadores.add(labelBrotes);
        panelContadores.add(labelRondas);

        // Añadir el panel de contadores al panel inferior
        panelInferior.add(panelContadores);



        setVisible(true);


        infectarCiudadesInicio(params.getCiudadesInicio(), params.getBrotesDerrota());

    }


    public static void infectarCiudadesInicio(int numCiudadesInfectadasInicio, int numBrotesMaximos) {


        //poner acciones en 4
        contadorAcciones=4;
        labelAcciones.setText("Acciones: " + contadorAcciones);
        //poner contador brotes en el valor de brotesmaximos
        contadorBrotes=numBrotesMaximos;

        //necesito que cuando la ciudad este a 0 no se pueda infectar mas


        labelBrotes.setText("Brotes restantes:" + contadorBrotes);
        //poner contador rondas en 0
        contadorRondas=0;
        labelRondas.setText("Rondas: " + contadorRondas);




        ArrayList<Ciudad> infectadas = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numCiudadesInfectadasInicio; i++) {
            int int_random = rand.nextInt(ciudadesarrylist.size());
            ciudadesarrylist.get(int_random).setInfeccion(ciudadesarrylist.get(int_random).getInfeccion() + 1);
            infectadas.add(ciudadesarrylist.get(int_random));
        }

        //switch para cambiar el icono de la ciudad infectada
        for (Ciudad ciudad : infectadas) {
            JButton botonCiudad = botonesCiudad.get(ciudadesarrylist.indexOf(ciudad));
            ImageIcon icon = null;

            switch (ciudad.getEnfermedad()) {
                case "Alfa":
                    icon = new ImageIcon("1 azul.png"); // Cambiar la ruta según sea necesario
                    break;
                case "Beta":
                    icon = new ImageIcon("1 rojo.png"); // Cambiar la ruta según sea necesario
                    break;
                case "Gama":
                    icon = new ImageIcon("1 negro.png"); // Cambiar la ruta según sea necesario
                    break;
                case "Delta":
                    icon = new ImageIcon("1 amarillo.png"); // Cambiar la ruta según sea necesario
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
        //printear el nombre de las ciudades infectadas
        for (int i = 0; i < infectadas.size(); i++) {
            System.out.println(infectadas.get(i).getNombre());
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

    //funcion de pasar turno
    public static void pasarTurno(int numCuidadesInfectadasRonda) {

        contadorAcciones = 4;
        labelAcciones.setText("Acciones: " + contadorAcciones);
        contadorRondas++;
        labelRondas.setText("Rondas: " + contadorRondas);

        ArrayList<Ciudad> infectadas = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i < numCuidadesInfectadasRonda; i++) {
            //si la infencion es 3 no se puede infectar mas
            if (ciudadesarrylist.get(i).getInfeccion() == 3) {
                brotar(ciudadesarrylist.get(i));
                continue;
            }
            int int_random = rand.nextInt(ciudadesarrylist.size());
            ciudadesarrylist.get(int_random).setInfeccion(ciudadesarrylist.get(int_random).getInfeccion() + 1);
            infectadas.add(ciudadesarrylist.get(int_random));
        }

        //switch para cambiar el icono de la ciudad infectada
        for (Ciudad ciudad : infectadas) {
            JButton botonCiudad = botonesCiudad.get(ciudadesarrylist.indexOf(ciudad));
            ImageIcon icon = null;

            switch (ciudad.getEnfermedad()) {
                case "Alfa":
                    //actualizar imagen de la ciudad segun su nivel infeccion
                    if (ciudad.getInfeccion() == 1) {
                        icon = new ImageIcon("1 azul.png");
                    } else if (ciudad.getInfeccion() == 2) {
                        icon = new ImageIcon("2 azul.png");
                    } else if (ciudad.getInfeccion() == 3) {
                        icon = new ImageIcon("3 azul.png");
                    }
                    break;
                case "Beta":
                    //actualizar imagen de la ciudad segun su nivel infeccion
                    if (ciudad.getInfeccion() == 1) {
                        icon = new ImageIcon("1 rojo.png");
                    } else if (ciudad.getInfeccion() == 2) {
                        icon = new ImageIcon("2 rojo.png");
                    } else if (ciudad.getInfeccion() == 3) {
                        icon = new ImageIcon("3 rojo.png");
                    }
                    break;
                case "Gama":
                    //actualizar imagen de la ciudad segun su nivel infeccion
                    if (ciudad.getInfeccion() == 1) {
                        icon = new ImageIcon("1 negro.png");
                    } else if (ciudad.getInfeccion() == 2) {
                        icon = new ImageIcon("2 negro.png");
                    } else if (ciudad.getInfeccion() == 3) {
                        icon = new ImageIcon("3 negro.png");
                    }
                    break;
                case "Delta":
                    //actualizar imagen de la ciudad segun su nivel infeccion
                    if (ciudad.getInfeccion() == 1) {
                        icon = new ImageIcon("1 amarillo.png");
                    } else if (ciudad.getInfeccion() == 2) {
                        icon = new ImageIcon("2 amarillo.png");
                    } else if (ciudad.getInfeccion() == 3) {
                        icon = new ImageIcon("3 amarillo.png");
                    }
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
        //printear el nombre de las ciudades infectadas
        for (int i = 0; i < infectadas.size(); i++) {
            System.out.println(infectadas.get(i).getNombre());
        }


    }

    public static void brotar(Ciudad c) {
        //restar un brote
        contadorBrotes--;
        labelBrotes.setText("Brotes restantes: " + contadorBrotes);
        //si el contador de brotes llega a 0 se pierde la partida
        if (contadorBrotes == 0) {
            System.out.println("Has perdido la partida");
        }
        //si contador brotes es menor que 0 se pone en 0
        if (contadorBrotes < 0) {
            contadorBrotes = 0;
        }
        //si has perdido la partida que salga una ventana emergente que diga que has perdido y que cierre la  pestaña del mapa
        if (contadorBrotes == 0) {
            JOptionPane.showMessageDialog(null, "Has perdido la partida pringao");
            System.exit(0);
        }


        //crear arraylist de string con las ciudades colindantes
        ArrayList<String> colindantes = c.getColindantes();
        //crear arraylist de ciudades colindantes
        ArrayList<Ciudad> colindantesCiudades = new ArrayList<>();
        //rellenar el arraylist de ciudades colindantes buscando las ciudades con el nombre de las colindantes
        for (int i = 0; i < colindantes.size(); i++) {
            for (int j = 0; j < ciudadesarrylist.size(); j++) {
                if (colindantes.get(i).equals(ciudadesarrylist.get(j).getNombre())) {
                    colindantesCiudades.add(ciudadesarrylist.get(j));
                }
            }
        }


        //infectar las ciudades colindantes
        for (int i = 0; i < colindantesCiudades.size(); i++) {
            if (colindantesCiudades.get(i).getInfeccion() == 3) {
                continue;
            }
            colindantesCiudades.get(i).setInfeccion(colindantesCiudades.get(i).getInfeccion() + 1);
        }

        //switch para cambiar el icono de la ciudad infectada
        for (Ciudad ciudad : colindantesCiudades) {
            JButton botonCiudad = botonesCiudad.get(ciudadesarrylist.indexOf(ciudad));
            ImageIcon icon = null;

            switch (ciudad.getEnfermedad()) {
                case "Alfa":
                    //actualizar imagen de la ciudad segun su nivel infeccion
                    if (ciudad.getInfeccion() == 1) {
                        icon = new ImageIcon("1 azul.png");
                    } else if (ciudad.getInfeccion() == 2) {
                        icon = new ImageIcon("2 azul.png");
                    } else if (ciudad.getInfeccion() == 3) {
                        icon = new ImageIcon("3 azul.png");
                    }
                    break;
                case "Beta":
                    //actualizar imagen de la ciudad segun su nivel infeccion
                    if (ciudad.getInfeccion() == 1) {
                        icon = new ImageIcon("1 rojo.png");
                    } else if (ciudad.getInfeccion() == 2) {
                        icon = new ImageIcon("2 rojo.png");
                    } else if (ciudad.getInfeccion() == 3) {
                        icon = new ImageIcon("3 rojo.png");
                    }
                    break;
                case "Gama":
                    //actualizar imagen de la ciudad segun su nivel infeccion
                    if (ciudad.getInfeccion() == 1) {
                        icon = new ImageIcon("1 negro.png");
                    } else if (ciudad.getInfeccion() == 2) {
                        icon = new ImageIcon("2 negro.png");
                    } else if (ciudad.getInfeccion() == 3) {
                        icon = new ImageIcon("3 negro.png");
                    }
                    break;
                case "Delta":
                    //actualizar imagen de la ciudad segun su nivel infeccion
                    if (ciudad.getInfeccion() == 1) {
                        icon = new ImageIcon("1 amarillo.png");
                    } else if (ciudad.getInfeccion() == 2) {
                        icon = new ImageIcon("2 amarillo.png");
                    } else if (ciudad.getInfeccion() == 3) {
                        icon = new ImageIcon("3 amarillo.png");
                    }
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

    }
}





