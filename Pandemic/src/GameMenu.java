package prueva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {

    public GameMenu() {
        super("Menú del Juego");

        // Carga una imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("C:\\\\Users\\\\alumnat\\\\eclipse-workspace\\\\prueva\\\\1366_2000.jpg");

        // Crea un panel para el menú sin bordes
        JPanel menuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        menuPanel.setLayout(new GridBagLayout()); // Centra los elementos
        menuPanel.setBorder(null); // Sin borde
        menuPanel.setOpaque(false); // Hace el fondo del panel transparente

        // Crea los botones del menú
        JButton newGameButton = new JButton("Nueva partida");
        JButton loadGameButton = new JButton("Cargar partida");
        JButton infoButton = new JButton("Información");
        JButton scoresButton = new JButton("Resumen de puntuaciones");
        JButton exitButton = new JButton("Salir");

        // Agrega ActionListeners a los botones
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nueva partida");
            }
        });

        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cargar partida");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Salir del programa
            }
        });

        // Añadir botones al panel principal
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre botones
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy = 0; // Fila
        menuPanel.add(newGameButton, gbc);

        gbc.gridy = 1;
        menuPanel.add(loadGameButton, gbc);

        gbc.gridy = 2;
        menuPanel.add(infoButton, gbc);

        gbc.gridy = 3;
        menuPanel.add(scoresButton, gbc);

        gbc.gridy = 4;
        menuPanel.add(exitButton, gbc);

        // Crea un panel inferior sin borde
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(null); // Sin borde
        bottomPanel.setOpaque(false); // Fondo transparente

        JLabel versionLabel = new JLabel("Versión 1.0");
        JLabel authorsLabel = new JLabel("Miquel Simo CEO, Alejandro Paris CEO, Joan Banlles CEO");

        // Agrega la versión a la izquierda y los autores a la derecha
        bottomPanel.add(versionLabel, BorderLayout.EAST); // Versión en la esquina inferior izquierda
        bottomPanel.add(authorsLabel, BorderLayout.WEST); // Autores en la esquina inferior derecha

        // Añade el panel principal y el panel inferior al JFrame
        this.setLayout(new BorderLayout());
        this.add(menuPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH); // Panel inferior en la parte inferior

        // Configura el JFrame
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameMenu());
    }
}
