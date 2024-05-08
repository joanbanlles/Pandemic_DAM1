import java.util.HashMap;
import java.util.Map;
public class control_partida<Partida> {
	   private Map<String, Partida> partidasGuardadas;
	    private Partida partidaActual;

	    public void ControlPartida() {
	        this.partidasGuardadas = new HashMap<>();
	        this.partidaActual = null;
	    }

	    public void iniciarPartida() {
	        // Implement the logic to start a new game
	    }

	    public void iniciarPartidaGuardada(String id) {
	        // Implement the logic to start a saved game
	    }

	    public void gestionarTurno() {
	        // Implement the logic to manage a turn
	    }

	    public void gestionarVacuna() {
	        // Implement the logic to manage vaccines
	    }

	    public void gestionarInfeccion() {
	        // Implement the logic to manage infections
	    }

	    public void gestionarBrote() {
	        // Implement the logic to manage outbreaks
	    }

	    public void gestionarFinPartida() {
	        // Implement the logic to manage the end of the game
	    }

	    public void gestionarFrases() {
	        // Implement the logic to manage phrases
	    }

	    public void gestionarCura() {
	        // Implement the logic to manage cures
	    }

	    public void guardarPartida(String id) {
	        // Implement the logic to save a game
	    }

	    public void cargarPartida(String id) {
	        // Implement the logic to load a saved game
	    }
	}

