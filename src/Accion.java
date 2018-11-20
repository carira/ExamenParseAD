import java.util.ArrayList;

public class Accion {
	private String at_nombre;
	private ArrayList <Operacion> Operaciones;
	public Accion(String nombre, ArrayList<Operacion> operaciones) {
		super();
		this.at_nombre = nombre;
		Operaciones = operaciones;
	}
	@Override
	public String toString() {
		return "Accion \n at_nombre=" + at_nombre + "\n Operaciones \n" + Operaciones + "]";
	}
	
	
	
}
