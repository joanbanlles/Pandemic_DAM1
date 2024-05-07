import java.util.HashMap;
import java.util.Map;

public class pantalla_partida {


	public class PantallaPartida {
	    private Map<String, Runnable> botonListeners;
	    private Partida partida;

	    public PantallaPartida() {
	        this.botonListeners = new HashMap<>();
	        this.partida = null;
	    }

	    public void addBotonListener(String nombreBoton, Runnable listener) {
	        botonListeners.put(nombreBoton, listener);
	    }

	    public void empezarNuevaPartida() {
	        // Implement the logic to start a new game
	    }

	    public void empezarPartidaGuardada(String id) {
	        // Implement the logic to start a saved game
	    }

	    public void funBotonCurarCiudad(String nCiudad) {
	        // Implement the logic to cure a city
	    }

	    public void funBotonDesarrollarVacuna(String nVacuna) {
	        // Implement the logic to develop a vaccine
	    }

	    public void funBotonFinalizarTurno() {
	        // Implement the logic to end the turn
	    }

	    public void funBotonGuardarPartida() {
	        // Implement the logic to save the game
	    }

	    public void funBotonNuevaPartida() {
	        // Implement the logic to start a new game
	    }

	    public void funBotonVolverInicio() {
	        // Implement the logic to return to the main menu
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
	

	}}
