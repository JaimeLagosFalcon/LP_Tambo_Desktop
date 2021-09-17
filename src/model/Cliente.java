package model;

public class Cliente {
	
	private String cod_cli,usuario,clave,nom_cli,apell_cli,fnacim,correo_cli,telef_cli,cod_dist;
	
	public Cliente(){
		
	}

	public Cliente(String cod_cli, String usuario, String clave, String nom_cli, String apell_cli, String fnacim,
			String correo_cli, String telef_cli, String cod_dist) {
		super();
		this.cod_cli = cod_cli;
		this.usuario = usuario;
		this.clave = clave;
		this.nom_cli = nom_cli;
		this.apell_cli = apell_cli;
		this.fnacim = fnacim;
		this.correo_cli = correo_cli;
		this.telef_cli = telef_cli;
		this.cod_dist = cod_dist;
	}

	public String getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(String cod_cli) {
		this.cod_cli = cod_cli;
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

	public String getNom_cli() {
		return nom_cli;
	}

	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}

	public String getApell_cli() {
		return apell_cli;
	}

	public void setApell_cli(String apell_cli) {
		this.apell_cli = apell_cli;
	}

	public String getFnacim() {
		return fnacim;
	}

	public void setFnacim(String fnacim) {
		this.fnacim = fnacim;
	}

	public String getCorreo_cli() {
		return correo_cli;
	}

	public void setCorreo_cli(String correo_cli) {
		this.correo_cli = correo_cli;
	}

	public String getTelef_cli() {
		return telef_cli;
	}

	public void setTelef_cli(String telef_cli) {
		this.telef_cli = telef_cli;
	}

	public String getCod_dist() {
		return cod_dist;
	}

	public void setCod_dist(String cod_dist) {
		this.cod_dist = cod_dist;
	}
	
	
}
