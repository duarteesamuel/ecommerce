package models;

import enums.Categoria;

public abstract class Produto {
	private static Integer counterId = 1;
	
	protected Integer idProduto;
	protected String nome;
	protected Double preco;
	protected Categoria categoria;
	
	public Produto(Categoria categoria, String nome, Double preco) {
		this.idProduto = counterId++;
		this.categoria = categoria;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
}
