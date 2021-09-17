package interfaces;

import java.util.ArrayList;

import model.Producto;

public interface ProductoInterface {
	
	//registra nuevo producto
	public int registrar(Producto p);
	
	//elimina producto con el codigo
	public int eliminar(String cod_prod);
	
	//actualiza info de producto segun codigo
	public int actualizar(Producto p);
	
	public ArrayList<Producto> listado();
	
	//busca producto con codigo
	public Producto buscar(String cod_prod);
	
	public String generarProducto();
	
	public ArrayList<Producto> consultar(String fvenci,String cod_cate,String cod_prove);
}
