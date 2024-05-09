import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

class Partida {
	private List<Ciudad> ciudades;
	private int desarrolloVacuna; // Rango de 0 a 100
	private int rondas;

	private JFrame frame;
	private JTextArea estadoTextArea;
	private JTextField rondaTextField;
	private JTextField desarrolloVacunaTextField;
	private Partida partida;

	public Partida() {
	    this.ciudades = new ArrayList<>();
	    this.ciudades.add(new Ciudad());
	    this.ciudades.add(new Ciudad());
	    this.ciudades.add(new Ciudad());
	    this.ciudades.add(new Ciudad());
	    this.desarrolloVacuna = 0;
	    this.rondas = 0;
	    
	    // Eliminar la línea partida = new Partida();

	    frame = new JFrame("Juego");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setLayout(new BorderLayout());

	    // Resto del código de la clase JuegoSwing...

	    // Panel para mostrar el estado
	    estadoTextArea = new JTextArea(10, 30);
	    estadoTextArea.setEditable(false);
	    JScrollPane estadoScrollPane = new JScrollPane(estadoTextArea);
	    frame.add(estadoScrollPane, BorderLayout.CENTER);

	    // Panel para la entrada y los botones
	    JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(2, 1));

	    // Panel superior
	    JPanel panelSuperior = new JPanel();
	    panelSuperior.setLayout(new GridLayout(2, 2));

	    JLabel rondaLabel = new JLabel("Ronda:");
	    rondaTextField = new JTextField();
	    rondaTextField.setEditable(false);
	    rondaTextField.setText(String.valueOf(this.rondas));

	    JLabel desarrolloVacunaLabel = new JLabel("Desarrollo de la vacuna:");
	    desarrolloVacunaTextField = new JTextField();
	    desarrolloVacunaTextField.setEditable(false);
	    desarrolloVacunaTextField.setText(String.valueOf(this.desarrolloVacuna));

	    panelSuperior.add(rondaLabel);
	    panelSuperior.add(rondaTextField);
	    panelSuperior.add(desarrolloVacunaLabel);
	    panelSuperior.add(desarrolloVacunaTextField);

	    panel.add(panelSuperior);

	    // Panel inferior para los botones
	    JPanel panelInferior = new JPanel();
	    panelInferior.setLayout(new GridLayout(1, 5));

	    JButton curarButton = new JButton("Curar ciudad");
	    curarButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Obtener el índice de la ciudad seleccionada.
	            int indiceCiudad = obtenerCiudadSeleccionada();
	            
	            // Verificar si el índice de la ciudad seleccionada es válido.
	            if (indiceCiudad >= 0 && indiceCiudad < ciudades.size()) {
	                // Curar la ciudad con el índice seleccionado.
	                curarCiudad(indiceCiudad);
	                
	                // Actualizar el estado después de curar la ciudad.
	                actualizarEstado();
	            } else {
	                // Mostrar un mensaje de error si la ciudad seleccionada no es válida.
	                JOptionPane.showMessageDialog(frame, "Ciudad seleccionada inválida. Por favor, seleccione una ciudad válida.");
	            }
	        }
	    });




	    JButton finalizarButton = new JButton("Finalizar turno");
	    finalizarButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            finalizarTurno();
	            actualizarEstado();
	        }
	    });

	    panelInferior.add(curarButton);



	    panelInferior.add(finalizarButton);

	    panel.add(panelInferior);

	    frame.add(panel, BorderLayout.SOUTH);

	    // Configurar el tamaño y visibilidad de la ventana
	    frame.pack();
	    frame.setVisible(true);

	    if (this.partida != null) {
	        this.partida.actualizarEstado();
	    }

		panelInferior.add(curarButton);



		
		panelInferior.add(finalizarButton);

		panel.add(panelInferior);

		frame.add(panel, BorderLayout.SOUTH);

		// Configurar el tamaño y visibilidad de la ventana
		frame.pack();
		frame.setVisible(true);

		actualizarEstado();
	}

	protected int obtenerCiudadSeleccionada() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void curarCiudad(int indiceCiudad) {
		if (indiceCiudad >= 0 && indiceCiudad < ciudades.size()) {
			ciudades.get(indiceCiudad).curarciudad();
		}
	}





	public void finalizarTurno() {
		rondas++;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public int getRondas() {
		return rondas;
	}

	public int getDesarrolloVacuna() {
		return desarrolloVacuna;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Partida::new);
	}

	private void actualizarEstado() {
		// Actualizar el área de texto con el estado actual del juego
		StringBuilder estado = new StringBuilder();
		estado.append("Ronda: ").append(partida.getRondas()).append("\n");
		estado.append("Desarrollo de la vacuna: ").append(partida.getDesarrolloVacuna()).append("\n");
		estado.append("Ciudades:\n");
		for (Ciudad ciudad : partida.getCiudades()) {
			estado.append(ciudad).append("\n");
		}
		estadoTextArea.setText(estado.toString());

		// Actualizar los campos de texto con el estado actual
		rondaTextField.setText(String.valueOf(partida.getRondas()));
		desarrolloVacunaTextField.setText(String.valueOf(partida.getDesarrolloVacuna()));
	}
}

