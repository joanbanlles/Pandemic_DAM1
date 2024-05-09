import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class resultados extends JFrame {

    public resultados() {
        // Configura el título y el tamaño de la ventana
        setTitle("Ventana con Fondo");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea un panel con un fondo de imagen
        JPanel panelConFondo = new PanelConFondo("fonde del menu.jpeg");
        panelConFondo.setLayout(new BorderLayout()); // Usa BorderLayout para el panel principal

        // Crea un panel para los botones en la parte superior
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setOpaque(false); // Hace que el panel sea transparente para ver el fondo

        // Carga las imágenes para los botones
        JButton boton1 = new JButton(new ImageIcon("PUNTUACION F.png"));
        boton1.setPreferredSize(new Dimension(350, 55));
        JButton boton2 = new JButton(new ImageIcon("PUNTUACION M.png"));
        boton2.setPreferredSize(new Dimension(350, 55));
        JButton boton3 = new JButton(new ImageIcon("PUNTUACION D.png"));
        boton3.setPreferredSize(new Dimension(350, 55));

        
        // Añade los botones al panel
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);

        // Añade el panel de botones a la parte superior del panel con fondo
        panelConFondo.add(panelBotones, BorderLayout.NORTH);

        // Añade el panel con fondo al JFrame
        add(panelConFondo);

        // Haz visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crea una instancia de la ventana para mostrarla
        SwingUtilities.invokeLater(resultados::new);
    }
}

// Clase personalizada para el panel con fondo
class PanelConFondo extends JPanel {
    private Image fondo;

    public PanelConFondo(String rutaFondo) {
        // Carga la imagen de fondo
        fondo = new ImageIcon(rutaFondo).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen de fondo escalada para llenar el panel
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
}