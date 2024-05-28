import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.util.ArrayList;

public class Datos_partida {
    // Atributos de la clase
    private ArrayList<Ciudad> ciudades;  // Lista de ciudades
    private ArrayList<Virus> virus;  // Lista de virus
    private ArrayList<Vacuna> vacunas;  // Lista de vacunas
    private int brotes;  // Número de brotes
    private int rondas;  // Número de rondas
    private float pDesarrollo;  // Progreso de desarrollo (podría ser desarrollo de la vacuna o cura)
    private int acciones;  // Número de acciones disponibles
    private int brote;  // Contador de brotes

    // Variables para almacenar configuraciones iniciales
    int numCiudadesInfectadasInicio;
    int numCuidadesInfectadasRonda;
    int numEnfermedadesActivasDerrota;
    int numBrotesDerrota;

    // Constructor que inicializa las listas y los contadores
    public Datos_partida() {
        this.ciudades = new ArrayList<>();
        this.virus = new ArrayList<>();
        this.vacunas = new ArrayList<>();
        this.brote = 0;
        this.rondas = 0;
        this.pDesarrollo = 0;
        this.acciones = 0;
    }

    // Método para cargar datos desde un archivo XML
    public void cargarDatos() {
        try {
            // Crear una instancia de File que apunta al archivo XML
            File xmlFile = new File("parametros.xml");
            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            // Crear un DocumentBuilder a partir de la fábrica
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // Parsear el archivo XML y obtener el documento
            Document doc = dBuilder.parse(xmlFile);
            // Normalizar el documento XML
            doc.getDocumentElement().normalize();

            // Obtener todos los elementos "nivel" del documento
            NodeList nivelNodes = doc.getElementsByTagName("nivel");
            for (int i = 0; i < nivelNodes.getLength(); i++) {
                // Obtener el elemento actual de la lista de niveles
                Element nivelElement = (Element) nivelNodes.item(i);
                // Obtener los datos de configuración inicial del elemento actual
                String id = nivelElement.getAttribute("id");
                this.numCiudadesInfectadasInicio = Integer.parseInt(nivelElement.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent());
                this.numCuidadesInfectadasRonda = Integer.parseInt(nivelElement.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent());
                this.numEnfermedadesActivasDerrota = Integer.parseInt(nivelElement.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent());
                this.numBrotesDerrota = Integer.parseInt(nivelElement.getElementsByTagName("numBrotesDerrota").item(0).getTextContent());

                // Aquí puedes manejar los datos del nivel según sea necesario, como almacenarlos en una lista o usarlos directamente
            }
        } catch (Exception e) {
            e.printStackTrace();  // Imprimir la traza del error si ocurre una excepción
        }
    }

    // Getters y setters para acceder y modificar los atributos

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

    public int getNumCiudadesInfectadasInicio() {
        return numCiudadesInfectadasInicio;
    }

    public void setNumCiudadesInfectadasInicio(int numCiudadesInfectadasInicio) {
        this.numCiudadesInfectadasInicio = numCiudadesInfectadasInicio;
    }

    public int getNumCuidadesInfectadasRonda() {
        return numCuidadesInfectadasRonda;
    }

    public void setNumCuidadesInfectadasRonda(int numCuidadesInfectadasRonda) {
        this.numCuidadesInfectadasRonda = numCuidadesInfectadasRonda;
    }

    public int getNumEnfermedadesActivasDerrota() {
        return numEnfermedadesActivasDerrota;
    }

    public void setNumEnfermedadesActivasDerrota(int numEnfermedadesActivasDerrota) {
        this.numEnfermedadesActivasDerrota = numEnfermedadesActivasDerrota;
    }

    public int getNumBrotesDerrota() {
        return numBrotesDerrota;
    }

    public void setNumBrotesDerrota(int numBrotesDerrota) {
        this.numBrotesDerrota = numBrotesDerrota;
    }

    // Método para modificar el nivel de infección de una ciudad específica
    public void modificarCiudad(String nCiudad, int modificacion) {
        for (Ciudad ciudad : ciudades) {
            // Buscar la ciudad por nombre
            if (ciudad.getNombre().equals(nCiudad)) {
                // Realizar la modificación en el nivel de infección
                ciudad.setInfeccion(ciudad.getInfeccion() + modificacion);
                break;
            }
        }
    }

    // Método para modificar la eficacia de una vacuna específica
    public void modificarVacuna(String nVacuna, float modificacion) {
        for (Vacuna vacuna : vacunas) {
            // Buscar la vacuna por nombre
            if (vacuna.getNombre().equals(nVacuna)) {
                // Realizar la modificación en la eficacia de la vacuna
                vacuna.setEficacia(vacuna.getEficacia() + modificacion);
                break;
            }
        }
    }
}
