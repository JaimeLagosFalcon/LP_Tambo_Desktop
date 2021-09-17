package model;

public class Categoria {
	
	private String cod_cate,desc_cat;

	public Categoria(String cod_cate, String desc_cat) {
		super();
		this.cod_cate = cod_cate;
		this.desc_cat = desc_cat;
	}

	public String getCod_cate() {
		return cod_cate;
	}

	public void setCod_cate(String cod_cate) {
		this.cod_cate = cod_cate;
	}

	public String getDesc_cat() {
		return desc_cat;
	}

	public void setDesc_cat(String desc_cat) {
		this.desc_cat = desc_cat;
	}
	
	
	
}
