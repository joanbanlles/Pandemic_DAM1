import java.util.ArrayList;
public class control_datos {
	private String url;
    private String user;
    private String password;
    private String ficheroTxt;
    private String ficheroBin;
    private String ficheroXML;

    public void ControlDeDatos(String url, String user, String password, String ficheroTxt, String ficheroBin, String ficheroXML) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.ficheroTxt = ficheroTxt;
        this.ficheroBin = ficheroBin;
        this.ficheroXML = ficheroXML;
    }

    public ArrayList<Ciudad> cargarCiudades() {
        // Implement the logic to load cities from a file or a database
        return new ArrayList<>();
    }

    public ArrayList<Vacuna> cargarVacunas() {
        // Implement the logic to load vaccines from a file or a database
        return new ArrayList<>();
    }

    public ArrayList<Virus> cargarVirus() {
        // Implement the logic to load viruses from a file or a database
        return new ArrayList<>();
    }

    public void cargarPartida() {
        // Implement the logic to load a game from a file or a database
    }

    public void guardarPartida() {
        // Implement the logic to save a game to a file or a database
    }

    public void cargarRecord() {
        // Implement the logic to load records from a file or a database
    }

    public void guardarRecord() {
        // Implement the logic to save records to a file or a database
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFicheroTxt() {
        return ficheroTxt;
    }

    public void setFicheroTxt(String ficheroTxt) {
        this.ficheroTxt = ficheroTxt;
    }

    public String getFicheroBin() {
        return ficheroBin;
    }

    public void setFicheroBin(String ficheroBin) {
        this.ficheroBin = ficheroBin;
    }

    public String getFicheroXML() {
        return ficheroXML;
    }

    public void setFicheroXML(String ficheroXML) {
        this.ficheroXML = ficheroXML;
    }
}


