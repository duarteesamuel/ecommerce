package models;

import enums.Categoria;

public class Eletronicos extends Produto{
	private String marca;

	public Eletronicos(Categoria categoria, String nome, Double preco, String marca) {
		super(categoria, nome, preco);
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
