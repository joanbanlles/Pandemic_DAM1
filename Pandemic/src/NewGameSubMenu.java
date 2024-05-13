import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class NewGameSubMenu extends JDialog {
    private static final String XML_PATH = ("parametros.xml"); // Actualiza esta ruta según tu archivo XML

    public NewGameSubMenu(JFrame parent) {
        super(parent, "Selecciona nivel de dificultad", true);

        // Carga la imagen de fondo
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("fonde del menu.jpeg"));
        } catch (IOException e) {
            System.err.println("Error al cargar la imagen de fondo: " + e.getMessage());
            getContentPane().setBackground(Color.GRAY);
        }

        if (backgroundImage != null) {
            JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
            backgroundLabel.setLayout(new BorderLayout());
            
            setContentPane(backgroundLabel);
        }

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        // Define botones para el submenú y añade ActionListeners
        JButton option1 = new JButton(new ImageIcon("FACIL.png"));
        option1.setPreferredSize(new Dimension(450, 55));
        option1.addActionListener(e -> {
            GameParameters params = loadGameParameters("facil");
            if (params != null) {
                System.out.println("Modo Fácil seleccionado");
                System.out.println("Parámetros: " + params);
            }
            //abrir mapa
            Mapa mapa = new Mapa("facil" );
            //cerrar el resto de pestañas
            this.dispose();
        });

        JButton option2 = new JButton(new ImageIcon("MEDIO.png"));
        option2.setPreferredSize(new Dimension(450, 55));
        option2.addActionListener(e -> {
            GameParameters params = loadGameParameters("mitja");
            if (params != null) {
                System.out.println("Modo Medio seleccionado");
                System.out.println("Parámetros: " + params);
            }
            Mapa mapa = new Mapa("medio" );
            //cerrar el resto de pestañas
            this.dispose();
        });

        JButton option3 = new JButton(new ImageIcon("DIFÍCIL.png"));
        option3.setPreferredSize(new Dimension(450, 55));
        option3.addActionListener(e -> {
            GameParameters params = loadGameParameters("dificl");
            if (params != null) {
                System.out.println("Modo Difícil seleccionado");
                System.out.println("Parámetros: " + params);
            }
            Mapa mapa = new Mapa("dificil" );
            //cerrar el resto de pestañas
            this.dispose();
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy = 0;
        buttonPanel.add(option1, gbc);

        gbc.gridy = 1;
        buttonPanel.add(option2, gbc);

        gbc.gridy = 2;
        buttonPanel.add(option3, gbc);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);

        setSize(500, 400);
        setLocationRelativeTo(parent);
    }

    public static GameParameters loadGameParameters(String levelId) {
        try {
            // Crea un DocumentBuilder para analizar el XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(XML_PATH));

            // Busca el elemento con el id del nivel
            NodeList levels = doc.getElementsByTagName("nivel");
            for (int i = 0; i < levels.getLength(); i++) {
                Element level = (Element) levels.item(i);
                if (level.getAttribute("id").equalsIgnoreCase(levelId)) {
                    // Extrae los valores
                    int ciudadesInicio = Integer.parseInt(level.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent());
                    int ciudadesRonda = Integer.parseInt(level.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent());
                    int enfermedadesDerrota = Integer.parseInt(level.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent());
                    int brotesDerrota = Integer.parseInt(level.getElementsByTagName("numBrotesDerrota").item(0).getTextContent());

                    // Crea un objeto GameParameters para encapsular los valores
                    return new GameParameters(ciudadesInicio, ciudadesRonda, enfermedadesDerrota, brotesDerrota);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println("Error al cargar parámetros de juego: " + e.getMessage());
        }
        
        return null; // Si no se encuentra el nivel o hay un error
    }
    
    // Clase para almacenar parámetros del juego
    public static class GameParameters {
        private static int ciudadesInicio;
        private static int ciudadesRonda;
        private static int enfermedadesDerrota;
        private static int brotesDerrota;



        public GameParameters(int ciudadesInicio, int ciudadesRonda, int enfermedadesDerrota, int brotesDerrota) {
            this.ciudadesInicio = ciudadesInicio;
            this.ciudadesRonda = ciudadesRonda;
            this.enfermedadesDerrota = enfermedadesDerrota;
            this.brotesDerrota = brotesDerrota;
        }
        //hacer getters y setters
        public int getCiudadesInicio() {
            return ciudadesInicio;
        }
        public void setCiudadesInicio(int ciudadesInicio) {
            this.ciudadesInicio = ciudadesInicio;
        }
        public int getCiudadesRonda() {
            return ciudadesRonda;
        }
        public void setCiudadesRonda(int ciudadesRonda) {
            this.ciudadesRonda = ciudadesRonda;
        }
        public int getEnfermedadesDerrota() {
            return enfermedadesDerrota;
        }
        public void setEnfermedadesDerrota(int enfermedadesDerrota) {
            this.enfermedadesDerrota = enfermedadesDerrota;
        }
        public int getBrotesDerrota() {
            return brotesDerrota;
        }
        public void setBrotesDerrota(int brotesDerrota) {
            this.brotesDerrota = brotesDerrota;
        }


        @Override
        public String toString() {
            return String.format("CiudadesInicio: %d, CiudadesRonda: %d, EnfermedadesDerrota: %d, BrotesDerrota: %d",
                                 ciudadesInicio, ciudadesRonda, enfermedadesDerrota, brotesDerrota);
        }
    }
}


