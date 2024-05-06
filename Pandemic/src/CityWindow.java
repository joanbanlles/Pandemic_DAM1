
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CityWindow extends JFrame {

    interface CureListener {
        void onCure(String cityName);
    }

    private CureListener cureListener;

    // Definir colores y niveles de infección
    private final Color[] infectionColors = {Color.YELLOW, Color.RED, Color.BLUE, Color.BLACK};
    private final String[] infectionLevels = {"nivel 1", "nivel 2", "nivel 3", "nivel 4"};

    public CityWindow(String cityName, MapPanel mapPanel) {
        this.cureListener = (CureListener) mapPanel;

        setTitle(cityName);
        setSize(100, 100); // Ajusta el tamaño según tus necesidades
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ImageIcon cureIcon = new ImageIcon("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\tiritacura.png");
        JButton cureButton = new JButton(cureIcon);

        // Establecer un tamaño más pequeño para el botón de cura
        cureButton.setPreferredSize(new Dimension(50, 50));

        cureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Notificar al mapa que la ciudad ha sido curada
                if (mapPanel != null) {
                    cureListener.onCure(cityName);
                }

                // Mostrar un mensaje indicando que la ciudad ha sido curada
                JOptionPane.showMessageDialog(null, "La ciudad " + cityName + " ha sido curada.");
            }
        });

        setLayout(new BorderLayout());
        add(cureButton, BorderLayout.CENTER); // Añade el botón al centro de la ventana

        setVisible(true);
    }
}
