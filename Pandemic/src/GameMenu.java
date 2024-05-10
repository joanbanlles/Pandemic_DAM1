
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {
    public GameMenu() {
        super("Menú del Juego");

        // Ajustar el tamaño del JFrame a 1920x1080
        int frameWidth = 1920;
        int frameHeight = 1080;
        setSize(frameWidth, frameHeight); 

        // Centrar la ventana
        setLocationRelativeTo(null);

        // Configurar el cierre del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cargar la imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("pantalla principal.gif");

        // Crear un panel para el menú
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
        JButton newGameButton = new JButton(new ImageIcon("NUEVA PARTIDA (13).gif"));
        newGameButton.setPreferredSize(new Dimension(450, 55));


        JButton loadGameButton = new JButton(new ImageIcon("CARGAR PARTIDA.gif"));
        loadGameButton.setPreferredSize(new Dimension(450, 55));

        JButton infoButton = new JButton(new ImageIcon("INFORMACION.gif"));
        infoButton.setPreferredSize(new Dimension(450, 55));

        JButton scoresButton = new JButton(new ImageIcon("RESUMEN.gif"));
        scoresButton.setPreferredSize(new Dimension(450, 55));

        JButton exitButton = new JButton(new ImageIcon("SALIR.gif"));
        exitButton.setPreferredSize(new Dimension(450, 55));

        // Configurar ActionListeners para cada botón

        newGameButton.addActionListener(e -> {
            // Ejemplo de abrir un submenú
            NewGameSubMenu subMenu = new NewGameSubMenu(this);
            subMenu.setVisible(true);
            // Cerrar el GameMenu
            dispose();
        });

        loadGameButton.addActionListener(e -> System.out.println("Cargar partida"));

        // ActionListener para el botón de resultados (scoresButton)
        scoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la ventana de resultados
                resultados resultWindow = new resultados();
                resultWindow.setVisible(true);
                // Cerrar el GameMenu
                dispose();
            }
        });

        infoButton.addActionListener(new InfoButtonHandler());

        exitButton.addActionListener(e -> System.exit(0)); // Salir del programa

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

        // Añadir el panel al JFrame
        setLayout(new BorderLayout());
        add(menuPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configuración de cierre
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameMenu::new);
    }
}
