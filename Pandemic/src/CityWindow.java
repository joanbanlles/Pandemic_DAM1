package pamdemic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class CityWindow extends JFrame {
    public CityWindow(String cityName) {
        setTitle(cityName);
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Crear los botones para agregar fotos
        JButton button1 = new JButton("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\cura.png");
        JButton button2 = new JButton("C:\\\\Users\\\\alumnat\\\\Documents\\\\GitHub\\\\Pandemic_DAM1\\\\Pandemic\\curar.png");

        // Crear el área de texto para el mensaje de cura
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        // Crear los listeners para los botones de fotos
        ActionListener photoButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el mensaje de texto en el área de texto
                textArea.setText("Se hizo clic en el botón de foto.");
            }
        };

        // Agregar listeners a los botones de fotos
        button1.addActionListener(photoButtonListener);
        button2.addActionListener(photoButtonListener);

        // Crear el botón "cura"
        JButton cureButton = new JButton("Cura");
        cureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar el mensaje de ciudad descontaminada
                textArea.setText(cityName + " está descontaminada.");
            }
        });

        // Configurar el layout de la ventana
        setLayout(new BorderLayout());
        add(button1, BorderLayout.NORTH);
        add(button2, BorderLayout.CENTER);
        add(new JScrollPane(textArea), BorderLayout.CENTER); // Agregar el área de texto en un JScrollPane
        add(cureButton, BorderLayout.SOUTH);

        // Mostrar la ventana
        setVisible(true);
    }
}
