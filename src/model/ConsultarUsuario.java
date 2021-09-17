package model;

public class ConsultarUsuario {
	
	private String codigo_usu,nombre,apellido,usuario,clave,fnacim,des_tipo;

	public ConsultarUsuario(String codigo_usu, String nombre, String apellido, String usuario, String clave,
			String fnacim, String des_tipo) {
		super();
		this.codigo_usu = codigo_usu;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.fnacim = fnacim;
		this.des_tipo = des_tipo;
	}

	public String getCodigo_usu() {
		return codigo_usu;
	}

	public void setCodigo_usu(String codigo_usu) {
		this.codigo_usu = codigo_usu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFnacim() {
		return fnacim;
	}

	public void setFnacim(String fnacim) {
		this.fnacim = fnacim;
	}

	public String getDes_tipo() {
		return des_tipo;
	}

	public void setDes_tipo(String des_tipo) {
		this.des_tipo = des_tipo;
	}
	
	

}
