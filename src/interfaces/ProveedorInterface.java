package interfaces;

import java.util.ArrayList;

import model.Proveedor;

public interface ProveedorInterface {
    
	public int registrar(Proveedor p);
	
	public int eliminar(String cod_prove);
	
	public int actualizar(Proveedor p);
	
	public ArrayList<Proveedor> listado();
	
	public ArrayList<Proveedor> consultaxnombre(String nom_prove);
	
	public String generarProveedor();
	
	public ArrayList<Proveedor> consulta(String cod_dist);

}