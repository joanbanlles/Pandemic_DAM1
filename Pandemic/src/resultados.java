import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class resultados extends JFrame {

    private static final String USER = "DAM1_2324_PAR_ALEJANDRO";
    private static final String PWD = "alejandro";
    private static final String URL = "jdbc:oracle:thin:@oracle.ilerna.com:1521:xe";
    private JTextArea resultadosTextArea;

    public resultados() throws SQLException {
        // Configura el título y el tamaño de la ventana
        setTitle("Resultados de partida");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crea un panel con un fondo de imagen
        JPanel panelConFondo = new PanelConFondo("fonde del menu.jpeg");
        panelConFondo.setLayout(new BorderLayout());

        // Carga las imágenes para los botones
        JButton boton1 = new JButton(new ImageIcon("PUNTUACION F.png"));
        boton1.setPreferredSize(new Dimension(350, 55));
        JButton boton2 = new JButton(new ImageIcon("PUNTUACION M.png"));
        boton2.setPreferredSize(new Dimension(350, 55));
        JButton boton3 = new JButton(new ImageIcon("PUNTUACION D.png"));
        boton3.setPreferredSize(new Dimension(350, 55));
        JButton boton4 = new JButton(new ImageIcon("volver.png"));
        boton4.setPreferredSize(new Dimension(350, 55));

        // Crea un panel para los botones en la parte superior
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.setOpaque(false);

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
        });

        // Agrega el panel de botones al panel con fondo
        panelConFondo.add(panelBotones, BorderLayout.NORTH);

        // Agrega el panel con el fondo al JFrame
        add(panelConFondo);

        // Haz visible la ventana
        setVisible(true);
    }

    // Método para insertar juegos en la base de datos
    public static void insertarJuego(Statement stmt, String nombre, String dificultad, int rondas) throws SQLException {
        String insert = "INSERT INTO Juego (nombre, dificultad, rondas) VALUES ('" + nombre + "', '" + dificultad + "', " + rondas + ")";
        stmt.executeUpdate(insert);
    }

 // Método para consultar juegos por dificultad y mostrar solo un resultado
    public void consultarPorDificultad(Statement stmt, String dificultad) {
        String sql = "SELECT * FROM (SELECT * FROM Juego WHERE dificultad = '" + dificultad + "') WHERE ROWNUM <= 1";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nombre");
            model.addColumn("Rondas");
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                int rondas = rs.getInt("rondas");
                model.addRow(new Object[]{nombre, rondas});
            }
            JTable table = new JTable(model);
            String titulo = "Resultado - " + dificultad; // Título dinámico
            JOptionPane.showMessageDialog(this, new JScrollPane(table), titulo, JOptionPane.PLAIN_MESSAGE);
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
}
