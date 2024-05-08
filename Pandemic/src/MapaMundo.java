
import javax.swing.*;
import java.awt.*;

public class MapaMundo extends JFrame {


	 public MapaMundo() {
	        // Configurar la ventana principal
	        setTitle("Mapa del Mundo con Borde Inferior Grande");
	        setSize(2000, 1050); // Tamaño de la ventana
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
	        
	        // Configurar el BorderLayout
	        setLayout(new BorderLayout());
	        
	        // Cargar la imagen del mapa del mundo
	        ImageIcon mapaImagen = new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\mapa_mundo_color.png"); // Ruta al archivo de imagen

	        // Crear un JLabel con la imagen
	        JLabel mapaLabel = new JLabel(mapaImagen);

	        // Crear paneles laterales y un panel inferior más grande
	        JPanel panelIzquierdo = new JPanel(); // Para borde izquierdo
	        JPanel panelDerecho = new JPanel(); // Para borde derecho
	        JPanel panelInferior = new JPanel(); // Para borde inferior
	        
	        // Configurar los colores de fondo
	        panelIzquierdo.setBackground(Color.LIGHT_GRAY); // Color para el borde izquierdo
	        panelDerecho.setBackground(Color.LIGHT_GRAY); // Color para el borde derecho
	        panelInferior.setBackground(Color.LIGHT_GRAY); // Color para el borde inferior

	        // Ajustar la altura del panel inferior para hacerlo más grande
	        panelInferior.setPreferredSize(new Dimension(0, 100));
	        panelDerecho.setPreferredSize(new Dimension(100, 0));
	        panelIzquierdo.setPreferredSize(new Dimension(100, 0));// 150 píxeles de alto

	        // Configurar los paneles laterales (sin botones) y el panel inferior
	        add(panelIzquierdo, BorderLayout.WEST); // Borde izquierdo
	        add(panelDerecho, BorderLayout.EAST); // Borde derecho
	        add(panelInferior, BorderLayout.SOUTH); // Borde inferior grande
	        add(mapaLabel, BorderLayout.CENTER); // Imagen del mapa del mundo en el centro

	        // Hacer visible la ventana
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        // Ejecutar la aplicación en el hilo de eventos de Swing
	        SwingUtilities.invokeLater(() -> {
	            new MapaMundo(); // Crear la ventana con borde inferior grande
	        });
	    }
	}