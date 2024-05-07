import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Mapa extends JPanel {
    private HashMap<String, JButton> cityButtons;
    private Image worldMap;

    public Mapa() {
        
        // Configurar la ventana principal
        setTitle("Mapa del Mundo");
        setSize(1920, 1080); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
        
        // Configurar el BorderLayout
        setLayout(new BorderLayout());
        
        // Cargar la imagen del mapa del mundo
        ImageIcon mapaImagen = new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\mapa_mundo.png");
        
        // Obtener las dimensiones originales de la imagen
        int imagenAncho = mapaImagen.getIconWidth();
        int imagenAlto = mapaImagen.getIconHeight();
        
        // Escalar la imagen para mantener su relación de aspecto sin recortar
        int ventanaAncho = getWidth();
        int ventanaAlto = getHeight();
        
        double aspectRatio = (double) imagenAncho / imagenAlto;
        int nuevoAncho, nuevoAlto;
        
        if (ventanaAncho / aspectRatio < ventanaAlto) {
            // Ajustar por ancho
            nuevoAncho = ventanaAncho;
            nuevoAlto = (int) (ventanaAncho / aspectRatio);
        } else {
            // Ajustar por alto
            nuevoAlto = ventanaAlto;
            nuevoAncho = (int) (ventanaAlto * aspectRatio);
        }
        
        // Escalar la imagen manteniendo la relación de aspecto
        Image imagenEscalada = mapaImagen.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);
        
        // Crear un JLabel con la imagen escalada y centrarlo
        JLabel mapaLabel = new JLabel(new ImageIcon(imagenEscalada));
        mapaLabel.setHorizontalAlignment(SwingConstants.CENTER); // Asegurar que esté centrado
        
        // Crear paneles laterales y panel inferior (más pequeños)
        JPanel panelIzquierdo = new JPanel();
        JPanel panelDerecho = new JPanel();
        JPanel panelInferior = new JPanel();
        
        // Configurar los colores de fondo (opcional)
        panelIzquierdo.setBackground(Color.LIGHT_GRAY);
        panelDerecho.setBackground(Color.LIGHT_GRAY);
        panelInferior.setBackground(Color.LIGHT_GRAY);
        
        // Ajustar el tamaño de los bordes para ser más pequeños
        panelIzquierdo.setPreferredSize(new Dimension(150, 0)); // 50 píxeles de ancho
        panelDerecho.setPreferredSize(new Dimension(150, 0));
        panelInferior.setPreferredSize(new Dimension(0, 190)); // 50 píxeles de alto
        
        // Añadir los componentes al marco
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        add(mapaLabel, BorderLayout.CENTER); // Imagen centrada
        
        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Mapa()); // Crear la ventana
>>>>>>> d1e228eafe255e215e8979eaeea7a7abbcf6db92
    }
}
