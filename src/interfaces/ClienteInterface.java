package interfaces;

import java.util.ArrayList;

import model.Cliente;
import model.Distrito;

public interface ClienteInterface {

		// Agregar Cliente
		public int registrar(Cliente cli);
		
		// Eliminar Cliente
		public int eliminar(String cod_cli);
		
		// Actualizar Cliente
		public int actualizar(Cliente cli);
		
		//listado de distritos
		public ArrayList<Distrito> listadoDistrito();
		
		public String generarCliente();
		
		public ArrayList<Cliente> listadoCliente();
		
		public ArrayList<Cliente>  consultar(String fnacim,String cod_dist);
}



