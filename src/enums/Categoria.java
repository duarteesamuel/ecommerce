package enums;

public enum Categoria {
	SMARTPHONES("Celulares"),
	ELETROELETRONICOS("Eletrônicos");
	
	private String descricao;
	
	Categoria(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
