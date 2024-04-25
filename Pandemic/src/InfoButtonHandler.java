import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase para manejar el evento del botón de información
class InfoButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Carga la imagen original
        ImageIcon originalImage = new ImageIcon("C:\\Users\\miquel\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic\\imatge de informacio.png");

        // Redimensiona la imagen a un tamaño más pequeño, por ejemplo, 200x200 píxeles
        Image scaledImage = originalImage.getImage().getScaledInstance(850, 850, Image.SCALE_SMOOTH);

        // Crea un nuevo ImageIcon con la imagen redimensionada
        ImageIcon smallerImage = new ImageIcon(scaledImage);

        // Muestra la imagen redimensionada en un JOptionPane
        JOptionPane.showMessageDialog(
            null,
            new JLabel(smallerImage), // Imagen para mostrar
            "Información",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
