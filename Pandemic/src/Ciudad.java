import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

public class Ciudad {
	// Atributos de la clase Ciudad
	private int idCiudad;
	private String nombre;
	private String enfermedad;
	private int idColor;
	int nivelInfeccion;
	private int infeccion;
	private int[] coords = new int[2];
	ArrayList<String> colindantes = new ArrayList<>();

	// Constructor de la clase Ciudad
	public Ciudad(String nombre, String enfermedad, int[] coords, ArrayList<String> colindantes) {
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.coords = coords;
		this.colindantes = colindantes;
	}

	// Métodos Getters (obtenedores)
	public int getIdCiudad() {
		return idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public int[] getCoords() {
		return coords;
	}

	public int getIdColor() {
		return idColor;
	}

	public int getNivelInfeccion() {
		return nivelInfeccion;
	}

	public int getInfeccion() {
		return infeccion;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	// Métodos Setters (establecedores)
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCoords(int[] coords) {
		this.coords = coords;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public void setNivelInfeccion(int nivelInfeccion) {
		this.nivelInfeccion = nivelInfeccion;
	}

	public void setInfeccion(int infeccion) {
		this.infeccion = infeccion;
	}

	// Método para obtener la lista de ciudades colindantes
	public ArrayList<String> getColindantes() {
		return colindantes;
	}

	// Método para aumentar el nivel de infección de la ciudad
	public void aumentarInfeccion() {
		this.infeccion++;
	}

	// Método para disminuir el nivel de infección de la ciudad
	public void disminuirInfeccion() {
		if (this.infeccion > 0) {
			this.infeccion--;
		}
	}

	// Método que implementa la lógica para propagar la infección a ciudades adyacentes
	public void propagarInfeccion() {
		// Implementar la lógica para propagar la infección a ciudades colindantes
	}

	// Método toString para la representación en cadena de la ciudad
	@Override
	public String toString() {
		long[] coordenadas = null;
		String enfermedad = null;
		long[] ciudadesColindantes = null;
		return "Ciudad{" +
				"nombre='" + nombre + '\'' +
				", coordenadas=" + Arrays.toString(coordenadas) +
				", enfermedad='" + enfermedad + '\'' +
				", infeccion=" + infeccion +
				", ciudadesColindantes=" + Arrays.toString(ciudadesColindantes) +
				'}';
	}

	// Método para curar la ciudad
	public void curarciudad() {
		if (Mapa.contadorAcciones >= 1) {
			// Reducir el nivel de infección en 1
			this.setInfeccion(this.getInfeccion() - 1);
			// Imprimir el nombre de la ciudad y su nivel de infección actual
			System.out.println("Ciudad curada: " + this.getNombre() + " Nivel de infeccion: " + this.getInfeccion());
			// Si el nivel de infección es menor que 0, ponerlo a 0
			if (this.infeccion < 0) {
				this.infeccion = 0;
			}
			// Actualizar la imagen de la ciudad
			ImageIcon icon = null;

			// Selección de imagen según la enfermedad y el nivel de infección
			switch (this.getEnfermedad()) {
				case "Alfa":
					if (PanelBotones.porcentajeActual3 == 100) {
						this.setInfeccion(0);
						icon = new ImageIcon("0 azul.png");
					}
					if (this.getInfeccion() == 1) {
						icon = new ImageIcon("1 azul.png");
					} else if (this.getInfeccion() == 2) {
						icon = new ImageIcon("2 azul.png");
					} else if (this.getInfeccion() == 0) {
						icon = new ImageIcon("0 azul.png");
					}
					break;
				case "Beta":
					if (PanelBotones.porcentajeActual2 == 100) {
						this.setInfeccion(0);
						icon = new ImageIcon("0 rojo.png");
					}
					if (this.getInfeccion() == 1) {
						icon = new ImageIcon("1 rojo.png");
					} else if (this.getInfeccion() == 2) {
						icon = new ImageIcon("2 rojo.png");
					} else if (this.getInfeccion() == 0) {
						icon = new ImageIcon("0 rojo.png");
					}
					break;
				case "Gama":
					if (PanelBotones.porcentajeActual4 == 100) {
						this.setInfeccion(0);
						icon = new ImageIcon("0 negro.png");
					}
					if (this.infeccion == 1) {
						icon = new ImageIcon("1 negro.png");
					} else if (this.getInfeccion() == 2) {
						icon = new ImageIcon("2 negro.png");
					} else if (this.getInfeccion() == 0) {
						icon = new ImageIcon("0 negro.png");
					}
					break;
				case "Delta":
					if (PanelBotones.porcentajeActual1 == 100) {
						this.setInfeccion(0);
						icon = new ImageIcon("0 amarillo.png");
					}
					if (this.getInfeccion() == 1) {
						icon = new ImageIcon("1 amarillo.png");
					} else if (this.getInfeccion() == 2) {
						icon = new ImageIcon("2 amarillo.png");
					} else if (this.getInfeccion() == 0) {
						icon = new ImageIcon("0 amarillo.png");
					}
					break;
				default:
					// Opcional: manejar el caso en que la enfermedad no sea ninguna de las esperadas
					break;
			}

			// Crear JButton para la ciudad
			JButton botonCiudad = null;
			for (int i = 0; i < Mapa.botonesCiudad.size(); i++) {
				// Buscar el botón con el nombre de la ciudad en Mapa.botonesCiudad
				if (this.getNombre().equals(Mapa.botonesCiudad.get(i).getText())) {
					botonCiudad = Mapa.botonesCiudad.get(i);
					break;
				}
			}

			// Actualizar el ícono del botón si se encuentra
			if (icon != null) {
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(botonCiudad.getWidth(), botonCiudad.getHeight(), java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				botonCiudad.setIcon(icon);
			}

		} else {
			// Si no hay acciones restantes, imprimir mensaje
			System.out.println("No hay acciones restantes");
		}
	}
}
