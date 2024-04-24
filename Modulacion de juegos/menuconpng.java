import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
public class menuconpng {
    
    public static void main(String[] args) {
        // Crear el marco (ventana)
        JFrame marco = new JFrame("Menú Principal");
        marco.setSize(1000, 1000);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Crear la barra de menú
        JMenuBar barraMenu = new JMenuBar();

        // Crear los menús
        JMenu menuPartida = new JMenu("Partida");
        JMenu menuInformacion = new JMenu("Información");

        // Crear los elementos de los menús
        JMenuItem itemNuevaPartida = new JMenuItem("Nueva Partida");
        JMenuItem itemCargarPartida = new JMenuItem("Cargar Partida");
        JMenuItem itemResumenPuntuaciones = new JMenuItem("Resumen de Puntuaciones");
        JMenuItem itemAutores = new JMenuItem("Autores");
        JMenuItem itemVersion = new JMenuItem("Versión");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Agregar los elementos a los menús
        menuPartida.add(itemNuevaPartida);
        menuPartida.add(itemCargarPartida);
        menuPartida.addSeparator();
        menuPartida.add(itemResumenPuntuaciones);
        menuInformacion.add(itemAutores);
        menuInformacion.add(itemVersion);
        menuInformacion.addSeparator();
        menuInformacion.add(itemSalir);

        // Agregar los menús a la barra de menú
        barraMenu.add(menuPartida);
        barraMenu.add(menuInformacion);

        // Agregar la barra de menú al panel
        panel.add(barraMenu, BorderLayout.NORTH);

        // Cargar la imagen
        String imagePath = "C:\\Users\\W10\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\mapa_mundo.png";
        Image image = null;
		try {
			image = loadImage(imagePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Crear un JLabel con la imagen
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setPreferredSize(new Dimension(500, 500)); // Establecer el tamaño deseado de la imagen

        // Agregar el JLabel al panel
        panel.add(imageLabel, BorderLayout.CENTER);

        // Agregar el panel al marco
        marco.add(panel);

        // Agregar acciones a los elementos del menú
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

        itemAutores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(marco, "Autores", true);
                dialog.setSize(300, 200);
                dialog.setLocationRelativeTo(null);

                JPanel dialogPanel = new JPanel(new GridLayout(2, 1));
                dialogPanel.add(new JLabel("Nombre: [Tu nombre aquí]"));
                dialogPanel.add(new JLabel("Contacto: [Tu correo electrónico o información de contacto]"));

                dialog.add(dialogPanel);
                dialog.setVisible(true);
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

    private static Image loadImage(String imagePath) {
        Image image = null;
        try {
            File file = new File(imagePath);
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}

