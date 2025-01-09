package enums;

public enum Categoria {
	SMARTPHONES("Smartphone"),
	ELETRONICOS("Eletrônico");
	
	private String descricao;
	
	Categoria(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
