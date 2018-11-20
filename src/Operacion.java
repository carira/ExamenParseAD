
public class Operacion {
	private String tipo;
	private int cantidad;
	private double precio;
	public Operacion(String tipo, int cantidad, double precio) {
		super();
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Operacion \n tipo=" + tipo + "\n cantidad=" + cantidad + "\n precio=" + precio + "\n ";
	}
	
	
}
