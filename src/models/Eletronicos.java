package models;

import enums.Categoria;

public class Eletronicos extends Produto{

	public Eletronicos(String nome, Double preco, String marca) {
		super(nome, preco, marca);
	}
	
	@Override
	public String toString() {
		return "";
	}
}
