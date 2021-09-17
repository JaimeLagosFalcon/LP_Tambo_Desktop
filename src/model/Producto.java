package model;

public class Producto {
	
	private String cod_prod,desc_prod,fvenci,cod_cate,cod_prove;
	private double prec_prod;
	private int stock_prod;
	
	public Producto(String cod_prod, String desc_prod, String fvenci,double prec_prod,int stock_prod, String cod_cate, String cod_prove) {
		super();
		this.cod_prod = cod_prod;
		this.desc_prod = desc_prod;
		this.fvenci = fvenci;
		this.cod_cate = cod_cate;
		this.cod_prove = cod_prove;
		this.prec_prod = prec_prod;
		this.stock_prod = stock_prod;
	}

	public String getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(String cod_prod) {
		this.cod_prod = cod_prod;
	}

	public String getDesc_prod() {
		return desc_prod;
	}

	public void setDesc_prod(String desc_prod) {
		this.desc_prod = desc_prod;
	}

	public String getFvenci() {
		return fvenci;
	}

	public void setFvenci(String fvenci) {
		this.fvenci = fvenci;
	}

	public String getCod_cate() {
		return cod_cate;
	}

	public void setCod_cate(String cod_cate) {
		this.cod_cate = cod_cate;
	}

	public String getCod_prove() {
		return cod_prove;
	}

	public void setCod_prove(String cod_prove) {
		this.cod_prove = cod_prove;
	}

	public double getPrec_prod() {
		return prec_prod;
	}

	public void setPrec_prod(double prec_prod) {
		this.prec_prod = prec_prod;
	}

	public int getStock_prod() {
		return stock_prod;
	}

	public void setStock_prod(int stock_prod) {
		this.stock_prod = stock_prod;
	}
	
	
		
}