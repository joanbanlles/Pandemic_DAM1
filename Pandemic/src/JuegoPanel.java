import javax.swing.*;
import java.awt.*;

public class JuegoPanel extends JPanel {
    private Partida partidaPanel; // Panel de la partida
    private Mapa mapaPanel; // Panel del mapa

    public JuegoPanel() {
        // Configurar el diseño del panel principal
        setLayout(new BorderLayout());
        
        // Inicializar las instancias de Partida y Mapa
        partidaPanel = new Partida();
        mapaPanel = new Mapa();
        
        // Configurar los paneles en el diseño
        // Agregar Partida al panel izquierdo
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.add(partidaPanel, BorderLayout.CENTER);
        panelIzquierdo.setPreferredSize(new Dimension(400, 0)); // Establece el tamaño preferido
        
        // Agregar Mapa al panel derecho
        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.add(mapaPanel, BorderLayout.CENTER);
        
        // Agregar panel izquierdo (Partida) y panel derecho (Mapa) al JuegoPanel
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Crear un JFrame para contener el JuegoPanel
        JFrame frame = new JFrame("Juego");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800); // Establece el tamaño de la ventana

        // Crear una instancia de JuegoPanel
        JuegoPanel juegoPanel = new JuegoPanel();

        // Agregar JuegoPanel al JFrame
        frame.add(juegoPanel);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}
