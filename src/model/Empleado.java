package model;

public class Empleado {
	
	private String cod_emple,usuario,clave,nom_emple,apell_emple,fnacim,correo_emple,telef_emple,cod_dist,cod_cargo;

	public Empleado(String cod_emple, String usuario, String clave, String nom_emple, String apell_emple, String fnacim,
			String correo_emple, String telef_emple, String cod_dist, String cod_cargo) {
		super();
		this.cod_emple = cod_emple;
		this.usuario = usuario;
		this.clave = clave;
		this.nom_emple = nom_emple;
		this.apell_emple = apell_emple;
		this.fnacim = fnacim;
		this.correo_emple = correo_emple;
		this.telef_emple = telef_emple;
		this.cod_dist = cod_dist;
		this.cod_cargo = cod_cargo;
	}

	public String getCod_emple() {
		return cod_emple;
	}

	public void setCod_emple(String cod_emple) {
		this.cod_emple = cod_emple;
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

	public String getNom_emple() {
		return nom_emple;
	}

	public void setNom_emple(String nom_emple) {
		this.nom_emple = nom_emple;
	}

	public String getApell_emple() {
		return apell_emple;
	}

	public void setApell_emple(String apell_emple) {
		this.apell_emple = apell_emple;
	}

	public String getFnacim() {
		return fnacim;
	}

	public void setFnacim(String fnacim) {
		this.fnacim = fnacim;
	}

	public String getCorreo_emple() {
		return correo_emple;
	}

	public void setCorreo_emple(String correo_emple) {
		this.correo_emple = correo_emple;
	}

	public String getTelef_emple() {
		return telef_emple;
	}

	public void setTelef_emple(String telef_emple) {
		this.telef_emple = telef_emple;
	}

	public String getCod_dist() {
		return cod_dist;
	}

	public void setCod_dist(String cod_dist) {
		this.cod_dist = cod_dist;
	}

	public String getCod_cargo() {
		return cod_cargo;
	}

	public void setCod_cargo(String cod_cargo) {
		this.cod_cargo = cod_cargo;
	}
	
	
}
