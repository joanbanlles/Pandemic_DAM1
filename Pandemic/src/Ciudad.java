import java.util.Arrays;

public class Ciudad {
    private int idCiudad;
    private String nombre;
    private float coordenadaX;
    private float coordenadaY;
    private int idColor;
    int nivelInfeccion;
	private int infeccion;
	public Object getNombre() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getLatitud() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getLongitud() {
		// TODO Auto-generated method stub
		return null;
	}
	public String[] getColindantes() {
		// TODO Auto-generated method stub
		return null;
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
		public Object getNivelInfeccion() {
			// TODO Auto-generated method stub
			return null;
		}
		public static int size() {
			// TODO Auto-generated method stub
			return 0;
		}
	}


