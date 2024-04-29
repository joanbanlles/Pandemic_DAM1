package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CityWindow extends JFrame {

    interface CureListener {
        void onCure(String cityName);
    }

    private JButton cityButton;
    private CureListener cureListener;

    // Definir colores y niveles de infección
    private final Color[] infectionColors = {Color.YELLOW, Color.RED, Color.BLUE, Color.BLACK};
    private final String[] infectionLevels = {"nivel 1", "nivel 2", "nivel 3", "nivel 4"};

    public CityWindow(String cityName, MapPanel mapPanel) {
        this.cureListener = (CureListener) mapPanel;

        setTitle(cityName);
        setSize(400, 450);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setPreferredSize(new Dimension(300, 200));

        cityButton = new JButton(cityName);

        JButton cureButton = new JButton("Cura");
        cureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el color actual del botón
                Color currentColor = cityButton.getBackground();
                int infectionLevel = -1;

                // Buscar el nivel de infección correspondiente al color
                for (int i = 0; i < infectionColors.length; i++) {
                    if (currentColor.equals(infectionColors[i])) {
                        infectionLevel = i;
                        break;
                    }
                }

                // Mostrar un mensaje indicando el nivel de infección antes de la cura
                if (infectionLevel >= 0 && infectionLevel < infectionLevels.length) {
                    JOptionPane.showMessageDialog(null, "La ciudad " + cityName + " estaba infectada al " + infectionLevels[infectionLevel]);
                }

                // Simular la cura eliminando el color del botón
                cityButton.setBackground(null);

                // Notificar al mapa que la ciudad ha sido curada
                if (mapPanel != null) {
                    mapPanel.onCure(cityName);
                }

                // Mostrar un mensaje indicando que la ciudad ha sido curada
                if (infectionLevel >= 0 && infectionLevel < infectionLevels.length) {
                    JOptionPane.showMessageDialog(null, "La ciudad " + cityName + " se ha curado del " + infectionLevels[infectionLevel]);
                }
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(cureButton, BorderLayout.SOUTH);
        add(cityButton, BorderLayout.WEST);

        setVisible(true);
    }
}
