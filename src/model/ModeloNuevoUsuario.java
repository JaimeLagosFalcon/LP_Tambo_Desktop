package model;

public class ModeloNuevoUsuario {
	
	/*ATRIBUTOS*/
	private String cod_usu,nom_usu,ape_usu,usuario,clave,fnacim,id_tipo;
	
	public ModeloNuevoUsuario(){
		
	}

	public ModeloNuevoUsuario(String cod_usu, String nom_usu, String ape_usu, String usuario, String clave,
			String fnacim, String id_tipo) {
		super();
		this.cod_usu = cod_usu;
		this.nom_usu = nom_usu;
		this.ape_usu = ape_usu;
		this.usuario = usuario;
		this.clave = clave;
		this.fnacim = fnacim;
		this.id_tipo = id_tipo;
	}

	public String getCod_usu() {
		return cod_usu;
	}

	public void setCod_usu(String cod_usu) {
		this.cod_usu = cod_usu;
	}

	public String getNom_usu() {
		return nom_usu;
	}

	public void setNom_usu(String nom_usu) {
		this.nom_usu = nom_usu;
	}

	public String getApe_usu() {
		return ape_usu;
	}

	public void setApe_usu(String ape_usu) {
		this.ape_usu = ape_usu;
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

	public String getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(String id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	
	
}
