import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Mapa extends JPanel {
    private HashMap<String, JButton> cityButtons;
    private Image worldMap;

    public Mapa() {
        cityButtons = new HashMap<>();
        // Agregar las coordenadas de las ciudades
        addCity("Yakarta", 1150, 525);
        addCity("El Cairo", 820, 350);
        addCity("Hong Kong", 1165, 370);
        addCity("Tokio", 1280, 290);
        addCity("Mexico DF", 300, 385);
        addCity("Taipei", 1205, 375);
        addCity("Lagos", 710, 450);
        addCity("Manila", 1200, 420);
        addCity("Essen", 755, 190);
        addCity("Pekin", 1175, 300);
        addCity("Washington", 360, 330);
        addCity("Moscu", 890, 230);
        addCity("Argel", 730, 330);
        addCity("Atlanta", 320, 320);
        addCity("Lima", 395, 520);
        addCity("Bombay", 1005, 395);
        addCity("Santiago de Chile", 430, 620);
        addCity("Buenos Aires", 453, 670);
        addCity("Nueva Delhi", 1025, 330);
        addCity("Riad", 895, 385);
        addCity("Teheran", 920, 310);
        addCity("Madras", 1035, 410);
        addCity("Johannesburgo", 815, 630);
        addCity("Jartum", 815, 450);
        addCity("Chicago", 300, 280);
        addCity("Calcuta", 1070, 370);
        addCity("Shanghai", 1195, 355);
        addCity("Londres", 700, 230);
        addCity("Kinsasa", 770, 540);
        addCity("Ho Chi Minh", 1148, 429);
        addCity("Sidney", 1320, 645);
        addCity("Sao Paulo", 520, 570);
        addCity("Bogota", 400, 460);
        addCity("Seul", 1225, 297);
        addCity("Miami", 380, 360);
        addCity("San Francisco", 235, 315);
        addCity("Bangkok", 1120, 415);
        addCity("Karachi", 980, 355);
        addCity("Milan", 755, 235);
        addCity("Nueva York", 380, 290);
        addCity("Madrid", 687, 290);
        addCity("San Petersburgo", 815, 210);
        addCity("Bagdad", 880, 320);
        addCity("Los Angeles", 275, 355);
        addCity("Osaka", 1255, 320);
        addCity("Montreal", 350, 280);
        addCity("Paris", 727, 250);
        addCity("Estambul", 830, 294);

        // Cargar la imagen del mapa del mundo
        worldMap = new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\mapa_mundo_color.png").getImage();

        setLayout(null); // Establecer un diseño nulo para posicionar manualmente los botones
        setPreferredSize(new Dimension(1366, 768)); // Tamaño de la pantalla estándar
    }

    // Método para agregar una ciudad con sus coordenadas y un mini botón
    private void addCity(String cityName, int x, int y) {
        JButton cityButton = new JButton(cityName);
        cityButton.setBounds(x, y, 10, 10); // Establecer las coordenadas de la ciudad en el mapa
        cityButtons.put(cityName, cityButton);
        add(cityButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja el mapa del mundo
        g.drawImage(worldMap, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        // Ejecutar la aplicación en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mapa del Mundo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new MapPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
