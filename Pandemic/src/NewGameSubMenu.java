

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class NewGameSubMenu extends JDialog {
    public NewGameSubMenu(JFrame parent) {
        super(parent, "Selecciona nivel de dificultad", true);

        // Carga la imagen de fondo
        BufferedImage backgroundImage = null;
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\fonde del menu.jpeg"));
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

        // Crea botones para el submenú y añade ActionListeners
        JButton option1 = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\FACIL.png"));
        option1.setPreferredSize(new Dimension(450, 55));
        option1.addActionListener(e -> System.out.println("Modo Fácil seleccionado"));

        JButton option2 = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\MEDIO.png"));
        option2.setPreferredSize(new Dimension(450, 55));
        option2.addActionListener(e -> System.out.println("Modo Medio seleccionado"));

        JButton option3 = new JButton(new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\DIFÍCIL.png"));
        option3.setPreferredSize(new Dimension(450, 55));
        option3.addActionListener(e -> System.out.println("Modo Difícil seleccionado"));

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
}

