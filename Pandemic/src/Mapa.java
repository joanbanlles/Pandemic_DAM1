import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Mapa extends JFrame {

    public Mapa() {
        // Configuración de la ventana principal
        setTitle("Mapa del Mundo");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        // Coordenadas de las ciudades
        String coordenadas = "San Francisco;0;235,315;Chicago,Los Angeles,Manila,Tokio;" +
                "Chicago;0;300,280;San Francisco,Montreal,Atlanta,Mexico DF,Los Angeles;" +
                "Atlanta;0;320,320;Chicago,Miami,Washington;" +
                "Montreal;0;350,280;Chicago,Nueva York, Washington;" +
                "Nueva York;0;380,290;Montreal,Washington,Londres,Madrid;" +
                "Washington;0;360,330;Montreal,Nueva York,Atlanta,Miami;" +
                "Londres;0;700,230;Nueva York,Madrid,Paris,Essen;" +
                "Madrid;0;687,290;Nueva York,Londres,Paris,Sao Paulo,Argel;" +
                "Paris;0;727,250;Madrid,Londres,Essen,Argel,Milan;" +
                "Essen;0;755,190;Londres,Paris,San Petersburgo,Milan;" +
                "Milan;0;755,235;Essen,Paris,Estambul;" +
                "San Petersburgo;0;815,210;Essen,Estambul,Moscu;" +
                "Los Angeles;3;275,355;San Francisco,Mexico DF,Chicago,Sidney;" +
                "Miami;3;380,360;Washington,Atlanta,Mexico DF,Bogota;" +
                "Mexico DF;3;300,385;Los Angeles,Miami,Chicago,Bogota,Lima;" +
                "Bogota;3;400,460;Miami,Mexico DF,Lima,Sao Paulo,Buenos Aires;" +
                "Lima;3;395,520;Mexico DF,Bogota,Santiago de Chile;" +
                "Santiago de Chile;3;430,620;Lima;" +
                "Buenos Aires;3;453,670;Sao Paulo,Bogota;" +
                "Sao Paulo;3;520,570;Bogota,Buenos Aires,Lagos,Madrid;" +
                "Lagos;3;710,450;Sao Paulo,Kinsasa,Jartum;" +
                "Kinsasa;3;770,540;Lagos,Jartum,Johannesburgo;" +
                "Jartum;3;815,450;El Cairo,Lagos,Kinsasa,Johannesburgo;" +
                "Johannesburgo;3;815,630;Kinsasa,Jartum;" +
                "Argel;2;730,330;Madrid,Paris,Estambul,El Cairo;" +
                "El Cairo;2;820,350;Argel,Estambul,Bagdad;" +
                "Riad;2;895,385;El Cairo,Bagdad,Karachi;" +
                "Estambul;2;830,294;Argel,El Cairo,Bagdad,Moscu;" +
                "Bagdad;2;880,320;Estambul,Karachi,Riad,El Cairo;" +
                "Moscu;2;890,230;Teheran,Estambul,San Petersburgo;" +
                "Teheran;2;920,310;Moscu,Bagdad,Karachi,Nueva Delhi;" +
                "Karachi;2;980,355;Teheran,Bagdad,Nueva Delhi,Riad,Bombay;" +
                "Bombay;2;1005,395;Karachi,Nueva Delhi,Madras;" +
                "Nueva Delhi;2;1025,330;Teheran,Karachi,Bombay,Madras,Calcuta;" +
                "Calcuta;2;1070,370;Nueva Delhi,Hong Kong,Madras,Bangkok;" +
                "Madras;2;1035,410;Bombay,Nueva Delhi,Calcula,Bangkok,Yakarta;" +
                "Bombay;2;1005,395;Karachi,Madras,Nueva Delhi;" +
                "Yakarta;1;1150,525;Madras,Bangkok,Ho Chi Minh,Sidney;" +
                "Bangkok;1;1120,415;Yakarta,Calcuta,Madras,Ho Chi Minh,Hong Kong;" +
                "Hong Kong;1;1165,370;Bangkok,Ho Chi Minh,Taipei,Manila,Shanghai;" +
                "Shanghai;1;1195,355;Pekin,Hong Kong,Seul,Tokio,Taipei;" +
                "Pekin;1;1175,300;Seul,Shanghai;" +
                "Seul;1;1225,297;Pekin,Tokio;" +
                "Tokio;1;1280,290;San Francisco,Seul,Osaka,Shanghai;" +
                "Osaka;1;1255,320;Tokio,Taipei;" +
                "Taipei;1;1205,375;Osaka,Shanghai,Hong Kong,Manila;" +
                "Ho Chi Minh;1;1148,429;Yakarta,Bangkok,Hong Kong,Manila;" +
                "Manila;1;1200,420;San Francisco,Ho Chi Minh,Taipei,Hong Kong,Sidney;" +
                "Sidney;1;1320,645;Los Angeles,Manila,Yakarta;";


        // Separar las coordenadas
        String[] ciudades = coordenadas.split(";");
        // HashMap para almacenar las coordenadas de las ciudades
        HashMap<String, String[]> coordenadasCiudades = new HashMap<>();

        // Almacenar las coordenadas en el HashMap
        for (int i = 0; i < ciudades.length; i += 4) {
            String ciudad = ciudades[i];
            String[] coordenadasXY = ciudades[i + 2].split(",");
            coordenadasCiudades.put(ciudad, coordenadasXY);
        }

        // Crear botones para cada ciudad y agregarlos al mapa
        for (String ciudad : coordenadasCiudades.keySet()) {
            JButton botonCiudad = new JButton();
            int x = Integer.parseInt(coordenadasCiudades.get(ciudad)[0]);
            int y = Integer.parseInt(coordenadasCiudades.get(ciudad)[1]);

            // Ajustar las coordenadas de los botones de América y Sudamérica
            if (x < 500 && y > 300) {
                x -= 40; // Mover hacia la izquierda
                y += 20; // Mover hacia abajo
            }

            botonCiudad.setBounds(x, y, 10, 10); // Establecer las coordenadas y tamaño del botón
            botonCiudad.setBackground(Color.BLACK); // Color del botón
            botonCiudad.setOpaque(true); // Hacer el botón opaco
            mapaLabel.add(botonCiudad); // Agregar el botón al mapa
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Mapa::new);
    }
}

