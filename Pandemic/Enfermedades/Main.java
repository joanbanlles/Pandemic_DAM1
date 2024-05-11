package hola;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("CCP.bin");
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            String explicacion = dataInputStream.readUTF();
            System.out.println(explicacion);

            String[] enfermedades = new String[4];

            for (int i = 0; i < 4; i++) {
                int codigoEnfermedad = dataInputStream.readInt();
                String nombreEnfermedad = dataInputStream.readUTF();
                String colorEnfermedad = dataInputStream.readUTF();
                enfermedades[i] = nombreEnfermedad;
            }

            dataInputStream.close();

            FileOutputStream fileOutputStream = new FileOutputStream("ciudades-enfermedad.bin");
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            BufferedReader bufferedReader = new BufferedReader(new FileReader("ciudades.txt"));
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] partes = linea.split(";");

                String[] ciudades = partes[0].split(","); 
                String primeraCiudad = ciudades[0]; 

                int numeroEnfermedad = Integer.parseInt(partes[1]);

                String nombreEnfermedad = (numeroEnfermedad >= 0 && numeroEnfermedad < enfermedades.length) ? enfermedades[numeroEnfermedad] : "Desconocida";

                dataOutputStream.writeUTF(primeraCiudad + ": " + nombreEnfermedad);
            }

            bufferedReader.close();
            dataOutputStream.close();

            System.out.println("El archivo ciudades-enfermedad.bin ha sido creado con éxito.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
