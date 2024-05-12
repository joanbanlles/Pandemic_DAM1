import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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

        // Configurar el ActionListener para boton1 (Fácil)
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realiza la conexión a la base de datos y ejecuta el insert para "Fácil"
                try (Connection con = DriverManager.getConnection(URL, USER, PWD);
                     Statement stmt = con.createStatement()) {
                    insertarJuego(stmt, "mamame el bicho", "Fácil", 10);
                    System.out.println("Insert para Fácil ejecutado correctamente.");
                    consultarPorDificultad(stmt, "Fácil");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

			private void insertarJuego(Statement stmt, String string, String string2, int i) {
				// TODO Auto-generated method stub
				
			}
        });

        // Configurar el ActionListener para boton2 (Medio)
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realiza la conexión a la base de datos y ejecuta el insert para "Medio"
                try (Connection con = DriverManager.getConnection(URL, USER, PWD);
                     Statement stmt = con.createStatement()) {
                    insertarJuego(stmt, "doremon", "Medio", 30);
                    System.out.println("Insert para Medio ejecutado correctamente.");
                    consultarPorDificultad(stmt, "Medio");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

			private void insertarJuego(Statement stmt, String string, String string2, int i) {
				// TODO Auto-generated method stub
				
			}
        });

        // Configurar el ActionListener para boton3 (Difícil)
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realiza la conexión a la base de datos y ejecuta el insert para "Difícil"
                try (Connection con = DriverManager.getConnection(URL, USER, PWD);
                     Statement stmt = con.createStatement()) {
                    insertarJuego(stmt, "muente puelco", "Difícil", 50);
                    System.out.println("Insert para Difícil ejecutado correctamente.");
                    consultarPorDificultad(stmt, "Difícil");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

			private void insertarJuego(Statement stmt, String string, String string2, int i) {
				// TODO Auto-generated method stub
				
			}
        });

        // Añade el panel de botones a la parte superior del panel con fondo
        panelConFondo.add(panelBotones, BorderLayout.NORTH);

        // Añade el panel con fondo al JFrame
        add(panelConFondo);

        // Haz visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crea una instancia de la ventana para mostrarla
        SwingUtilities.invokeLater(() -> {
            try {
                new resultados();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

 // Método para insertar juegos en la base de datos
    public static void insertarJuegos(Statement stmt) throws SQLException {
        // Inserta los juegos en la tabla Juego
        String insert1 = "INSERT INTO Juego (nombre, dificultad, rondas) VALUES ('mamame el bicho', 'Fácil', 10)";
        String insert2 = "INSERT INTO Juego (nombre, dificultad, rondas) VALUES ('muente puelco', 'Difícil', 50)";
        String insert3 = "INSERT INTO Juego (nombre, dificultad, rondas) VALUES ('doremon', 'Medio', 30)";
        stmt.executeUpdate(insert1);
        stmt.executeUpdate(insert2);
        stmt.executeUpdate(insert3);
    }


    // Método para consultar juegos por dificultad
    public static void consultarPorDificultad(Statement stmt, String dificultad) throws SQLException {
        String sql = "SELECT * FROM Juego WHERE dificultad = '" + dificultad + "'";
        ResultSet rs = stmt.executeQuery(sql);

        // Imprimir los resultados en la consola estándar
        while (rs.next()) {
            // Aquí debes usar el nombre correcto de la columna y asegurarte de que estás obteniendo el tipo de dato correcto
            String nombre = rs.getString("nombre"); // Ejemplo: Si "nombre" es una cadena en la base de datos
            String dific = rs.getString("dificultad"); // Obtener la dificultad como cadena
            int rondas = rs.getInt("rondas"); // Obtener el número de rondas como entero

            // Imprimir los resultados en la consola estándar
            System.out.printf("nombre: %s, dificultad: %s, rondas: %d%n", nombre, dific, rondas);
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
    }
}
