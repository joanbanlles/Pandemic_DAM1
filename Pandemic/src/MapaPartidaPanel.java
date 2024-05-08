import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;

public class MapaPartidaPanel extends JPanel {
    private Mapa mapa;
    private Partida partida;

    public MapaPartidaPanel() {
        setLayout(new BorderLayout());

        // Crear instancias de Mapa y Partida
        mapa = new Mapa(); // Asegúrate de tener un constructor sin argumentos o proporciona los necesarios
        partida = new Partida(); // Asegúrate de tener un constructor sin argumentos o proporciona los necesarios

        // Aquí se agrega `mapa` y `partida` al `JPanel`
        // Puedes ajustar los layouts según tus necesidades
        add(mapa, BorderLayout.CENTER); // Puedes usar otro BorderLayout según tus necesidades
        add(partida, BorderLayout.SOUTH); // También puedes ajustar la posición según tus necesidades
    }

	private void add(Partida partida2, String south) {
		// TODO Auto-generated method stub
		
	}

    // Puedes agregar métodos adicionales si los necesitas para manejar la integración de Mapa y Partida
}