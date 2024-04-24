import java.util.HashMap;
import java.util.Map;
public class Codigo_morse {
    private static final Map<Character, String> MORSE_CODE = new HashMap<>();

    static {
        MORSE_CODE.put('A', ".-");
        MORSE_CODE.put('B', "-...");
        MORSE_CODE.put('C', "-.-.");
        MORSE_CODE.put('D', "-..");
        MORSE_CODE.put('E', ".");
        MORSE_CODE.put('F', "..-.");
        MORSE_CODE.put('G', "--.");
        MORSE_CODE.put('H', "....");
        MORSE_CODE.put('I', "..");
        MORSE_CODE.put('J', ".---");
        MORSE_CODE.put('K', "-.-");
        MORSE_CODE.put('L', ".-..");
        MORSE_CODE.put('M', "--");
        MORSE_CODE.put('N', "-.");
        MORSE_CODE.put('O', "---");
        MORSE_CODE.put('P', ".--.");
        MORSE_CODE.put('Q', "--.-");
        MORSE_CODE.put('R', ".-.");
        MORSE_CODE.put('S', "...");
        MORSE_CODE.put('T', "-");
        MORSE_CODE.put('U', "..-");
        MORSE_CODE.put('V', "...-");
        MORSE_CODE.put('W', ".--");
        MORSE_CODE.put('X', "-..-");
        MORSE_CODE.put('Y', "-.--");
        MORSE_CODE.put('Z', "--..");
    }

    public static String convertirMorse(String mensaje) {
        StringBuilder morse = new StringBuilder();
        for (char c : mensaje.toCharArray()) {
            String morseCode = MORSE_CODE.get(Character.toUpperCase(c));
            if (morseCode != null) {
                morse.append(morseCode).append(" ");
            }
        }
        return morse.toString();
    }

    public static String convertirLetras(String morse) {
        StringBuilder mensaje = new StringBuilder();
        String[] palabras = morse.split("   ");
        for (String palabra : palabras) {
            String[] codigos = palabra.split(" ");
            for (String codigo : codigos) {
                for (Map.Entry<Character, String> entry : MORSE_CODE.entrySet()) {
                    if (entry.getValue().equals(codigo)) {
                        mensaje.append(entry.getKey());
                        break;
                    }
                }
            }
            mensaje.append(" ");
        }
        return mensaje.toString();
    }

    public static boolean verificarMorse(String morse) {
        String[] palabras = morse.split("   ");
        for (String palabra : palabras) {
            String[] codigos = palabra.split(" ");
            for (String codigo : codigos) {
                if (!MORSE_CODE.containsValue(codigo)) {
                    return false;
                }
            }
        }
        return true;
    }
}
