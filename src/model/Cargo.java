package model;

public class Cargo {
	private String cod_cargo, desc_cargo;

	public Cargo(String cod_cargo, String desc_cargo) {
		super();
		this.cod_cargo = cod_cargo;
		this.desc_cargo = desc_cargo;
	}

	public String getCod_cargo() {
		return cod_cargo;
	}

	public void setCod_cargo(String cod_cargo) {
		this.cod_cargo = cod_cargo;
	}

	public String getDesc_cargo() {
		return desc_cargo;
	}

	public void setDesc_cargo(String desc_cargo) {
		this.desc_cargo = desc_cargo;
	}
	

}