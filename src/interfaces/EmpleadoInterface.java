package interfaces;

import java.util.ArrayList;

import model.Cargo;
import model.Distrito;
import model.Empleado;

public interface EmpleadoInterface {
	
	//Agrega empleado
	public int registrar(Empleado emp);
	
	//eliminar empleado segun codigo
	public int eliminar(String cod_emple);
	
	//actualiza info de empleado
	public int actualizar(Empleado emp);
	
	public ArrayList<Empleado> listado();
	
	//busca empleado segun codigo
	public Empleado buscar(int codigo);
	
	//listado de distritos
	public ArrayList<Distrito> listadoDistrito();
	
	//listado de cargo
	public ArrayList<Cargo> listadoCargo();
	
	public String generarEmpleado();
	
	public ArrayList<Empleado> consulta(String fnacim,String cod_dist,String cod_cargo);
	
}
