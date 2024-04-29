package base;

import javax.swing.*;

import base.CityWindow.CureListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

class MapPanel extends JPanel implements CureListener {

    private HashMap<String, JButton> cityButtons;
    private Image worldMap;

    public MapPanel() {
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
        worldMap = new ImageIcon("C:\\Users\\Nitropc\\OneDrive\\Documentos\\GitHub\\Pandemic_DAM1\\Pandemic\\mapa_mundo.png").getImage();

        // Configurar el layout del panel
        setLayout(null);
        setPreferredSize(new Dimension(1366, 768)); // Tamaño de la pantalla estándar
    }

    private void addCity(String name, int x, int y) {
        int adjustedX = x - 67;
        int adjustedY = y - 35;

        JButton button = new JButton(name);
        button.setBounds(adjustedX - 10, adjustedY - 10, 20, 20);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CityWindow(name, MapPanel.this); // Pasar una referencia de MapPanel como CureListener
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(button);
        cityButtons.put(name, button);

        Random random = new Random();
        double infectionProbability = random.nextDouble();
        Color buttonColor;
        if (infectionProbability < 0.2) {
            buttonColor = Color.YELLOW; // Fase leve
        } else if (infectionProbability < 0.4) {
            buttonColor = Color.RED; // Fase un poco más leve
        } else if (infectionProbability < 0.6) {
            buttonColor = Color.BLUE; // Fase normal
        } else {
            buttonColor = Color.BLACK; // Fase super infectado
        }

        button.setBackground(buttonColor);
        button.setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(worldMap, 0, 0, getWidth(), getHeight(), this);
    }

    public void onCure(String cityName) {
        JButton button = cityButtons.get(cityName);
        if (button != null) {
            button.setBackground(null); // Eliminar el color del botón
        }
    }
}
