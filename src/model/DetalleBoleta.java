package model;

public class DetalleBoleta {
	
	private String num_bolet,cod_prod;
	private int cant_prod;
	private double prec_prod,importetotal;
	
	public DetalleBoleta(String num_bolet, String cod_prod, int cant_prod, double prec_prod, double importetotal) {
		super();
		this.num_bolet = num_bolet;
		this.cod_prod = cod_prod;
		this.cant_prod = cant_prod;
		this.prec_prod = prec_prod;
		this.importetotal = importetotal;
	}

	public String getNum_bolet() {
		return num_bolet;
	}

	public void setNum_bolet(String num_bolet) {
		this.num_bolet = num_bolet;
	}

	public String getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(String cod_prod) {
		this.cod_prod = cod_prod;
	}

	public int getCant_prod() {
		return cant_prod;
	}

	public void setCant_prod(int cant_prod) {
		this.cant_prod = cant_prod;
	}

	public double getPrec_prod() {
		return prec_prod;
	}

	public void setPrec_prod(double prec_prod) {
		this.prec_prod = prec_prod;
	}

	public double getImportetotal() {
		return importetotal;
	}

	public void setImportetotal(double importetotal) {
		this.importetotal = importetotal;
	}
	
	
}
