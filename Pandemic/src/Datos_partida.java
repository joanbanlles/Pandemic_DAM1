import java.util.ArrayList;
public class Datos_partida {
    private ArrayList<Ciudad> ciudades;
    private ArrayList<Virus> virus;
    private ArrayList<Vacuna> vacunas;
    private int brotes;
    private int rondas;
    private float pDesarrollo;
    private int acciones;
	private int brote;

    public void DatosPartida() {
        this.ciudades = new ArrayList<>();
        this.virus = new ArrayList<>();
        this.vacunas = new ArrayList<>();
        this.brote = 0;
        this.rondas = 0;
        this.pDesarrollo = 0;
        this.acciones = 0;
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public ArrayList<Virus> getVirus() {
        return virus;
    }

    public void setVirus(ArrayList<Virus> virus) {
        this.virus = virus;
    }

    public ArrayList<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(ArrayList<Vacuna> vacunas) {
        this.vacunas = vacunas;
    }

    public int getBrote() {
        return brotes;
    }

    public void setBrote(int brotes) {
        this.brote = brotes;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }

    public float getpDesarrollo() {
        return pDesarrollo;
    }

    public void setpDesarrollo(float pDesarrollo) {
        this.pDesarrollo = pDesarrollo;
    }

    public int getAcciones() {
        return acciones;
    }

    public void setAcciones(int acciones) {
        this.acciones = acciones;
    }

    public void modificarCiudad(String nCiudad, int modificacion) {
        for (Ciudad ciudad : ciudades) {
            if (ciudad.getNombre().equals(nCiudad)) {
                ciudad.setInfeccion(ciudad.aumentarInfeccion() + modificacion);
                break;
            }
        }
    }

    public void modificarVacuna(String nVacuna, float modificacion) {
        for (Vacuna vacuna : vacunas) {
            if (vacuna.getNombre().equals(nVacuna)) {
                vacuna.setEficacia(vacuna.getEficacia() + modificacion);
                break;
            }
        }
    }

    public void cargarDatos() {
        // Implement the logic to load data from a file or a database
    }
}
	
	


