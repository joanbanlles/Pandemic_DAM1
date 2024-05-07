import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
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

    public Datos_partida() {
        this.ciudades = new ArrayList<>();
        this.virus = new ArrayList<>();
        this.vacunas = new ArrayList<>();
        this.brote = 0;
        this.rondas = 0;
        this.pDesarrollo = 0;
        this.acciones = 0;
    }

    public void cargarDatos() {
        try {
            File xmlFile = new File("C:\\Users\\alumnat\\Documents\\GitHub\\Pandemic_DAM1\\Pandemic/parametros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nivelNodes = doc.getElementsByTagName("nivel");
            for (int i = 0; i < nivelNodes.getLength(); i++) {
                Element nivelElement = (Element) nivelNodes.item(i);
                String id = nivelElement.getAttribute("id");
                int numCiudadesInfectadasInicio = Integer.parseInt(nivelElement.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent());
                int numCuidadesInfectadasRonda = Integer.parseInt(nivelElement.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent());
                int numEnfermedadesActivasDerrota = Integer.parseInt(nivelElement.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent());
                int numBrotesDerrota = Integer.parseInt(nivelElement.getElementsByTagName("numBrotesDerrota").item(0).getTextContent());

                // Aquí puedes hacer lo que necesites con los datos del nivel, como almacenarlos en un ArrayList
                // o utilizarlos de alguna otra manera.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}

	


