package model;

public class Proveedor {
	
	private String cod_prove,nom_prove,correo_prove,telef_prove,cod_dist;

	public Proveedor(String cod_prove, String nom_prove, String correo_prove, String telef_prove, String cod_dist) {
		super();
		this.cod_prove = cod_prove;
		this.nom_prove = nom_prove;
		this.correo_prove = correo_prove;
		this.telef_prove = telef_prove;
		this.cod_dist = cod_dist;
	}

	public String getCod_prove() {
		return cod_prove;
	}

	public void setCod_prove(String cod_prove) {
		this.cod_prove = cod_prove;
	}

	public String getNom_prove() {
		return nom_prove;
	}

	public void setNom_prove(String nom_prove) {
		this.nom_prove = nom_prove;
	}

	public String getCorreo_prove() {
		return correo_prove;
	}

	public void setCorreo_prove(String correo_prove) {
		this.correo_prove = correo_prove;
	}

	public String getTelef_prove() {
		return telef_prove;
	}

	public void setTelef_prove(String telef_prove) {
		this.telef_prove = telef_prove;
	}

	public String getCod_dist() {
		return cod_dist;
	}

	public void setCod_dist(String cod_dist) {
		this.cod_dist = cod_dist;
	}
	
	
}
