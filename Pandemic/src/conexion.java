import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Scanner;

public class conexion {

private static final String USER = "DAM1_2324_PAR_ALEJANDRO";
private static final String PWD = "alejandro";
// Si est�is desde casa, la url ser� oracle.ilerna.com y no 192.168.3.26
private static final String URL = "jdbc:oracle:thin:oracle.ilerna.com";

public static void main(String[] args) throws SQLException {
// TODO Auto-generated method stub
Connection con = conectarBaseDatos();







}

static Connection conectarBaseDatos() {
Connection con = null;

System.out.println("Intentando conectarse a la base de datos");



System.out.println("Conectados a la base de datos");

return con;
}



}
