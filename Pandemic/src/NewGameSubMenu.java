
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase para el submenú que aparece al hacer clic en "Nueva Partida"
class NewGameSubMenu extends JDialog {
    public NewGameSubMenu(JFrame parent) {
        super(parent, "Nueva Partida", true); // Diálogo modal
        setLayout(new GridBagLayout()); // Layout para el submenú

        // Crea botones para el submenú
        JButton option1 = new JButton("Modo Fácil");
        JButton option2 = new JButton("Modo Medio");
        JButton option3 = new JButton("Modo Difícil");

        // Configura ActionListeners para cada botón del submenú
        option1.addActionListener(e -> System.out.println("Modo Fácil seleccionado"));
        option2.addActionListener(e -> System.out.println("Modo Medio seleccionado"));
        option3.addActionListener(e -> System.out.println("Modo Difícil seleccionado"));

        // Disposición de los botones en el submenú
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridy = 0;
        add(option1, gbc);

        gbc.gridy = 1;
        add(option2, gbc);

        gbc.gridy = 2;
        add(option3, gbc);

        // Tamaño y centrado del submenú
        setSize(300, 200); // Tamaño del submenú
        setLocationRelativeTo(parent); // Centra el submenú respecto al JFrame principal
    }
}