package hola;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase para manejar el evento del botón de información
class InfoButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
                "-----REGLAS Y NORMAS PARA EL JUEGO-----\n" +
                "\n"+
                "---GESTIÓN DE CIUDADES---\n" +
                "Creación de Ciudades: El juego debe permitir la creación de ciudades con un nombre único, coordenadas (X,Y), y una enfermedad principal.\n" +
                "Niveles de Infección: Cada ciudad tiene un nivel de infección entre 0 y 3. Un aumento en el nivel de infección debe ocurrir cada ronda.\n" +
                "Ciudades Adyacentes: Mantener un registro de las ciudades adyacentes a cada ciudad.\n" +
                "Propagación de la Enfermedad: Si el nivel de infección de una ciudad supera 3, la enfermedad se propaga a las ciudades adyacentes, y se incrementa el contador de brotes.\n" +
                "\n"+
                "---GESTIÓN DE PARTIDAS---\n" +
                "Sesiones de Juego: Cada sesión de juego recibe un número de partida único.\n" +
                "Lista de Ciudades y Vacunas: Mantener una lista de ciudades y vacunas disponibles en cada partida.\n" +
                "Acciones por Ronda: Los jugadores están limitados a 4 acciones por ronda.\n" +
                "Investigación de Vacunas: Después de 4 acciones dedicadas a la investigación, el porcentaje de desarrollo de la vacuna aumenta en un 25%.\n" +
                "Curación de Ciudades: Al curar una ciudad, el nivel de infección disminuye a 2 si era 3 y no hay vacuna desarrollada.\n" +
                "\n"+
                "---GESTIÓN DE VACUNAS---\n" +
                "Identificación de Vacunas: Cada vacuna tiene un identificador de color y un porcentaje de desarrollo.\n" +
                "Progreso de Desarrollo: Cada 4 acciones dedicadas a la investigación, el desarrollo de la vacuna aumenta en un 25%, hasta alcanzar el 100%.\n" +
                "\n"+
                "---INTERFAZ DE USUARIO---\n" +
                "Amigable e Intuitiva: El juego debe ser fácil de usar para jugadores de cualquier edad entre 12 y 99 años.\n" +
                "\n"+
                "---DESEMPEÑO---\n" +
                "Respuesta Fluida: El juego debe mantener un desempeño fluido y sin retrasos para una experiencia óptima.\n" +
                "\n"+
                "---CONFIGURACIÓN---\n" +
                "Configuración del Juego: El usuario debe poder configurar el número de ciudades infectadas, el número de ciudades infectadas en cada ronda, y el número de enfermedades activas para cada partida.\n" +
                "\n"+
                "---DESARROLLO DE VACUNAS---\n" +
                "Proceso Realista: El desarrollo de la vacuna debe seguir un proceso realista y ofrecer un desafío equilibrado para el jugador.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }
}