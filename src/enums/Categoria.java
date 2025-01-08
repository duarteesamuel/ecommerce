package enums;

public enum Categoria {
	SMARTPHONES("Celulares"),
	ACESSORIOS("Acessórios"),
	ELETROELETRONICOS("Eletronicos");
	
	private String descricao;
	
	Categoria(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
