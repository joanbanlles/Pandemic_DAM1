

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameMenu extends JFrame {
    public GameMenu() {
        super("Menú del Juego");

        // Carga la imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\fonde del menu.jpeg");

        // Crea un panel para el menú sin bordes
        JPanel menuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        menuPanel.setLayout(new GridBagLayout()); // Centra los elementos
        menuPanel.setOpaque(false); // Fondo transparente

        // Usa imágenes para los botones del menú
        JButton newGameButton = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\NUEVA PARTIDA (13).gif"));
        newGameButton.setPreferredSize(new Dimension(450, 55));
        JButton loadGameButton = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\CARGAR PARTIDA.gif"));
        loadGameButton.setPreferredSize(new Dimension(450, 55));
        JButton infoButton = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\INFORMACION.gif"));
        infoButton.setPreferredSize(new Dimension(450, 55));
        JButton scoresButton = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\RESUMEN.gif"));
        scoresButton.setPreferredSize(new Dimension(450, 55));
        JButton exitButton = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\SALIR.gif"));
        exitButton.setPreferredSize(new Dimension(450, 55));
        // Configura ActionListeners para los botones
        newGameButton.addActionListener(e -> System.out.println("Nueva partida"));
        loadGameButton.addActionListener(e -> System.out.println("Cargar partida"));
        exitButton.addActionListener(e -> System.exit(0)); // Salir del programa

        // Asigna el manejador para el botón de información
        infoButton.addActionListener(new InfoButtonHandler());

        // Añadir botones al panel principal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre botones
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy = 0;
        menuPanel.add(newGameButton, gbc);

        gbc.gridy = 1;
        menuPanel.add(loadGameButton, gbc);

        gbc.gridy = 2;
        menuPanel.add(infoButton, gbc);

        gbc.gridy = 3;
        menuPanel.add(scoresButton, gbc);

        gbc.gridy = 4;
        menuPanel.add(exitButton, gbc);

        // Panel inferior
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setOpaque(false);

        JLabel versionLabel = new JLabel("Versión 1.0");
        JLabel authorsLabel = new JLabel("Miquel Simo, Alejandro Paris, Joan Banlles");

        // Añade elementos al panel inferior
        bottomPanel.add(versionLabel, BorderLayout.EAST); // Versión en la esquina inferior izquierda
        bottomPanel.add(authorsLabel, BorderLayout.WEST); // Autores en la esquina inferior derecha

        // Añadir el panel inferior y el menú principal
        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH); // Panel inferior

        // Configuración del JFrame
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameMenu::new);
    }
}
