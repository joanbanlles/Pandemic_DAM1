import javax.swing.*;
import java.awt.*;

public class Mapa extends JFrame {

    public Mapa() {
        // Configurar la ventana principal
        setTitle("Mapa del Mundo Escalado");
        setSize(1900, 1050); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
        
        // Configurar el BorderLayout
        setLayout(new BorderLayout());
        
        // Ruta de la imagen del mapa del mundo
        String rutaImagen = "C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\mapa_mundo_color.png";

        // Crear el panel para mostrar la imagen escalada
        PanelImagenEscalada panelImagen = new PanelImagenEscalada(rutaImagen);

        // Crear paneles laterales e inferior para los bordes
        JPanel panelIzquierdo = new JPanel();
        JPanel panelDerecho = new JPanel();
        JPanel panelInferior = new JPanel();

        // Ajustar el tamaño de los bordes para dar más espacio al centro
        panelIzquierdo.setPreferredSize(new Dimension(100, 0)); // Ancho del borde izquierdo
        panelDerecho.setPreferredSize(new Dimension(100, 0)); // Ancho del borde derecho
        panelInferior.setPreferredSize(new Dimension(0, 100)); // Alto del borde inferior
        
        // Configurar colores de fondo
        panelIzquierdo.setBackground(Color.LIGHT_GRAY);
        panelDerecho.setBackground(Color.LIGHT_GRAY);
        panelInferior.setBackground(Color.LIGHT_GRAY);

        // Agregar componentes al BorderLayout
        add(panelIzquierdo, BorderLayout.WEST); // Borde izquierdo
        add(panelDerecho, BorderLayout.EAST); // Borde derecho
        add(panelInferior, BorderLayout.SOUTH); // Borde inferior
        add(panelImagen, BorderLayout.CENTER); // Imagen escalada en el centro

        // Hacer visible la ventana
        setVisible(true);
    }

    // Clase interna para escalar la imagen
    static class PanelImagenEscalada extends JPanel {
        private Image imagenOriginal;

        public PanelImagenEscalada(String rutaImagen) {
            // Cargar la imagen desde el archivo
            this.imagenOriginal = new ImageIcon(rutaImagen).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagenOriginal != null) {
                // Escalar la imagen para que ocupe todo el espacio disponible
                int panelWidth = getWidth();
                int panelHeight = getHeight();
                Image imagenEscalada = imagenOriginal.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
                g.drawImage(imagenEscalada, 0, 0, null);
            }
        }
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new Mapa(); // Crear la ventana con el mapa escalado
        });
    }
}