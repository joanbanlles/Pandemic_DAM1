
public class Vacuna {
    private int idVacuna;
    private String nombre;
    private String desarrollador;
	private String color;
	private float porcentaje;

public Vacuna(String nombre, String color) {
    this.nombre = nombre;
    this.color = color;
    this.porcentaje = 0;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getColor() {
    return color;
}

public void setColor(String color) {
    this.color = color;
}

public float getPorcentaje() {
    return porcentaje;
}

public void setPorcentaje(float porcentaje) {
    this.porcentaje = porcentaje;
}

public void desarrollarVacuna(float porcentaje) {
    this.porcentaje = porcentaje;
}

public float getEficacia() {
	// TODO Auto-generated method stub
	return 0;
}

public void setEficacia(float f) {
	// TODO Auto-generated method stub
	
}
}

