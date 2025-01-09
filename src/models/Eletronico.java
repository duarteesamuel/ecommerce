package models;

import enums.Categoria;
import utils.Utils;

public class Eletronico extends Produto{

	
	public Eletronico() {
		
	}
	
	
	public Eletronico(Categoria categoria, String nome, Double preco, String marca) {
		super(categoria, nome, preco, marca);
	}
	
}
