import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class resultados extends JFrame {
    private static final String USER = "DAM1_2324_PAR_ALEJANDRO";
    private static final String PWD = "alejandro";
    private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";

    public resultados() throws SQLException {
        // Configura el título y el tamaño de la ventana
        setTitle("Resultados de partida");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crea un panel con un fondo de imagen
        JPanel panelConFondo = new PanelConFondo("fonde del menu.jpeg");
        panelConFondo.setLayout(new BorderLayout());

        // Crea un panel para los botones en la parte superior
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setOpaque(false);

        // Carga las imágenes para los botones
        JButton boton1 = new JButton(new ImageIcon("PUNTUACION F.png"));
        boton1.setPreferredSize(new Dimension(350, 55));
        JButton boton2 = new JButton(new ImageIcon("PUNTUACION M.png"));
        boton2.setPreferredSize(new Dimension(350, 55));
        JButton boton3 = new JButton(new ImageIcon("PUNTUACION D.png"));
        boton3.setPreferredSize(new Dimension(350, 55));
        JButton boton4 = new JButton(new ImageIcon("volver.png"));
        boton4.setPreferredSize(new Dimension(350, 55));

        // Añade los botones al panel
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);

        // Configurar el ActionListener para boton4
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana de GameMenu
                new GameMenu().setVisible(true);
                // Cierra la ventana actual de resultados
                dispose();
            }
        });

        // Añade el panel de botones a la parte superior del panel con fondo
        panelConFondo.add(panelBotones, BorderLayout.NORTH);

        // Añade el panel con fondo al JFrame
        add(panelConFondo);

        // Haz visible la ventana
        setVisible(true);

        // Consulta la base de datos después de que la ventana se haya creado y hecho visible
        consultarPorDificultad(null, "facil");
    }

    public static void main(String[] args) {
        // Crea una instancia de la ventana para mostrarla
        SwingUtilities.invokeLater(() -> {
			try {
				new resultados();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
    }


    private static Connection conectarBaseDatos() {
    	
        Connection con = conexion.conectarBaseDatos();
        return con;
        }

     // Método para consultar juegos por dificultad
        public static void consultarPorDificultad(Statement stmt, String dificultad) throws SQLException {
            String sql = "SELECT * FROM Juego WHERE dificultad = '" + dificultad + "'";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                // Aquí debes usar el nombre correcto de la columna y asegurarte de que estás obteniendo el tipo de dato correcto
                String nombre = rs.getString("nombre"); // Ejemplo: Si "nombre" es una cadena en la base de datos
                String dific = rs.getString("dificultad"); // Obtener la dificultad como cadena
                int rondas = rs.getInt("rondas"); // Obtener el número de rondas como entero

                // Luego, puedes imprimir o hacer lo que necesites con estos valores
                System.out.println("nombre: " + nombre +
                        ", dificultad: " + dific +
                        ", rondas: " + rondas);
            }
            rs.close();
        }



 

class PanelConFondo extends JPanel {
    private Image fondo;

    public PanelConFondo(String rutaFondo) {
        fondo = new ImageIcon(rutaFondo).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
    }
}}
