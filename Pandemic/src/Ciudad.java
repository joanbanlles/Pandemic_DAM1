import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

public class Ciudad {
	private int idCiudad;
	private String nombre;
	private String enfermedad;
	private int idColor;
	int nivelInfeccion;
	private int infeccion;
	private int[] coords = new int[2];

	ArrayList<String> colindantes =  new ArrayList<>();

	public Ciudad(String nombre, String enfermedad, int[] coords, ArrayList<String> colindantes) {
		this.nombre = nombre;
		this.enfermedad = enfermedad;
		this.coords = coords;
		this.colindantes = colindantes;
	}



	// Getters
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

	// Setters
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public Dictionary<Object, Object> getColindantes() {
        return null;
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

	public void aumentarInfeccion() {
		this.infeccion++;
	}

	public void disminuirInfeccion() {
		if (this.infeccion > 0) {
			this.infeccion--;
		}
	}

	public void propagarInfeccion() {
		// Implement the logic to propagate the infection to adjacent cities
	}

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

	public void curarciudad() {
		// TODO Auto-generated method stub


	}

}


