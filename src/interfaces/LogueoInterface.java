package interfaces;

import java.util.ArrayList;

import model.Cliente;
import model.ConsultarUsuario;
import model.Empleado;
import model.ModeloNuevoUsuario;
import model.TipoUsuario;
import vista.ConsultaUsuarios;


public interface LogueoInterface {
	
	public ArrayList<TipoUsuario> listadodetipo();
	
	public int registrar(ModeloNuevoUsuario nu);
	
	public String generarCodigoUsuario();
	
	public String generarUsuarioAdmmin();
	
	public String generarUsuarioCajero();
	
	public String generarUsuarioCliente();
	
	public ModeloNuevoUsuario validarAcceso(String usuario,String clave);
	
	public String generarMantenimiento();
	
	public Cliente buscarCliente(String cod_cli);
	
	public Empleado buscarEmpleado(String cod_emple);
	
	public int actualizarDatosCliente(Cliente cli);
	
	public int actualizarDatosEmpleado(Empleado em);
	
	public ArrayList<ConsultarUsuario> listadousuarios();

}
