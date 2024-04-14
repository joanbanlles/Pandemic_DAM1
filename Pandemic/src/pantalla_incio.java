import java.util.HashMap;
import java.util.Map;

public class pantalla_incio {
	   private Map<String, Runnable> botonListeners;
	    private Records records;
	    private PantallaGuardado pantallaGuardado;
	    private Partida partida;

	    public PantallaInicio() {
	        this.botonListeners = new HashMap<>();
	        this.records = null;
	        this.pantallaGuardado = null;
	        this.partida = null;
	    }

	    public void addBotonListener(String nombreBoton, Runnable listener) {
	        botonListeners.put(nombreBoton, listener);
	    }

	    public void cargarPantallaInicio() {
	        // Implement the logic to load the main menu
	    }

	    public void cargarRecords() {
	        // Implement the logic to load the records
	    }

	    public void cargarPantallaGuardado() {
	        // Implement the logic to load the saved games menu
	    }

	    public void cargarPartida(Partida partida) {
	        // Implement the logic to load a saved game
	    }

	    public void funBotonNuevaPartida() {
	        // Implement the logic to start a new game
	    }

	    public void funBotonCargarRecords() {
	        // Implement the logic to load the records
	    }

	    public void funBotonCargarGuardado() {
	        // Implement the logic to load the saved games menu
	    }

	    public void setRecords(Records records) {
	        this.records = records;
	    }

	    public void setPantallaGuardado(PantallaGuardado pantallaGuardado) {
	        this.pantallaGuardado = pantallaGuardado;
	    }

	    public void setPartida(Partida partida) {
	        this.partida = partida;
	    }

	    public void executeButtonAction(String nombreBoton) {
	        Runnable listener = botonListeners.get(nombreBoton);
	        if (listener != null) {
	            listener.run();
	        }
	    }
	}

}
