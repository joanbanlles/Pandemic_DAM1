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

	    this.desarrolloVacuna = 0;
	    this.rondas = 0;
	    

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


