import javax.swing.*;

public class MapaPartidaFrame {
    public static void main(String[] args) {
        // Crear un JFrame
        JFrame frame = new JFrame("Mapa y Partida");

        // Configurar la operación de cierre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una instancia de MapaPartidaPanel
        MapaPartidaPanel mapaPartidaPanel = new MapaPartidaPanel();

        // Agregar MapaPartidaPanel al frame
        frame.setContentPane(mapaPartidaPanel);

        // Ajustar el tamaño y mostrar la ventana
        frame.pack();
        frame.setVisible(true);
    }
}