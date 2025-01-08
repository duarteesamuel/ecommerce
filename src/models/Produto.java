package models;

import enums.Categoria;

public abstract class Produto {
	private static Integer counterId = 1;
	
	protected Integer idProduto;
	protected String nome;
	protected Double preco;
	protected String marca;
	
	public Produto(String nome, Double preco, String marca) {
		this.idProduto = counterId++;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
