package models;

import enums.Categoria;

public class Smartphone extends Produto{
	
	public Smartphone(String nome, Double preco, String marca) {
		super(nome, preco, marca);
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
