package models;

import enums.Categoria;

public class Smartphone extends Produto{
	
	private String marca;

	public Smartphone(Categoria categoria, String nome, Double preco, String marca) {
		super(categoria, nome, preco);
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
