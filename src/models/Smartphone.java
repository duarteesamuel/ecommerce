package models;

import enums.Categoria;

public class Smartphone extends Produto{
	
	
	public Smartphone() {
		
	}
	
	public Smartphone(Categoria categoria, String nome, Double preco, String marca) {
		super(categoria, nome, preco, marca);
	}
	
}
