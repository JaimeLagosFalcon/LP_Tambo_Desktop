package interfaces;

import java.util.ArrayList;

import model.Boleta;
import model.DetalleBoleta;
import model.Empleado;

public interface VentaInterface {
	
	public String generarBoleta();
	
	public int realizarVenta(Boleta bl,ArrayList<DetalleBoleta> db);
	
	public Empleado buscar(String usuario);
}
