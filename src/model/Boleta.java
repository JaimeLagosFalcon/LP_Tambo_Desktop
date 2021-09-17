package model;

public class Boleta {
	
	private String num_bolet,fec_bolet,hor_bolet,cod_cli,cod_emple;
	private double tot_bol;
	
	public Boleta(String num_bolet, String fec_bolet, String hor_bolet, String cod_cli, String cod_emple,
			double tot_bol) {
		super();
		this.num_bolet = num_bolet;
		this.fec_bolet = fec_bolet;
		this.hor_bolet = hor_bolet;
		this.cod_cli = cod_cli;
		this.cod_emple = cod_emple;
		this.tot_bol = tot_bol;
	}

	public String getNum_bolet() {
		return num_bolet;
	}

	public void setNum_bolet(String num_bolet) {
		this.num_bolet = num_bolet;
	}

	public String getFec_bolet() {
		return fec_bolet;
	}

	public void setFec_bolet(String fec_bolet) {
		this.fec_bolet = fec_bolet;
	}

	public String getHor_bolet() {
		return hor_bolet;
	}

	public void setHor_bolet(String hor_bolet) {
		this.hor_bolet = hor_bolet;
	}

	public String getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(String cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getCod_emple() {
		return cod_emple;
	}

	public void setCod_emple(String cod_emple) {
		this.cod_emple = cod_emple;
	}

	public double getTot_bol() {
		return tot_bol;
	}

	public void setTot_bol(double tot_bol) {
		this.tot_bol = tot_bol;
	}
	
	
	
}
