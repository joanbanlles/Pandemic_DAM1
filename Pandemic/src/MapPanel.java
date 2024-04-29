package pamdemic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class MapPanel extends JPanel {
    private HashMap<String, Point> cities;
    private Image worldMap;

    public MapPanel() {
        cities = new HashMap<>();
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
        worldMap = new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\mapa_mundo.png").getImage();

        // Configurar el layout del panel
        setLayout(null);
        setPreferredSize(new Dimension(1920, 1080)); // Tamaño de la pantalla estándar

        // Agregar los botones para cada ciudad
        for (String city : cities.keySet()) {
            Point coordinates = cities.get(city);
            addButton(city, coordinates.x, coordinates.y);
        }
    }

    private void addCity(String name, int x, int y) {
        cities.put(name, new Point(x, y));
    }

    private void addButton(String name, int x, int y) {
        JButton button = new JButton(name);
        // Ajustar la posición del botón para centrarlo en la ciudad
        button.setBounds(x - 10, y - 10, 20, 20); // Tamaño del botón

        // Asignar una imagen al botón
        ImageIcon icon = new ImageIcon("image_placeholder.jpg"); // Cambia "image_placeholder.jpg" por la imagen deseada
        Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes cargar la imagen relacionada con la ciudad
                // Puedes mostrar un JFileChooser para que el usuario seleccione la imagen
                JOptionPane.showMessageDialog(MapPanel.this, "Cargando imagen para " + name);
            }
        });
        add(button);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar el mapa del mundo como fondo
        g.drawImage(worldMap, 0, 0, getWidth(), getHeight(), this);
    }
}