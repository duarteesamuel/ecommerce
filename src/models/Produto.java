package models;

import java.util.Objects;

import enums.Categoria;
import utils.Utils;

public abstract class Produto {
	private static Integer counterId = 1;
	
	protected Integer idProduto;
	protected Categoria categoria;
	protected String nome;
	protected Double preco;
	protected String marca;	
	
	public Produto() {
		super();
	}
	
	
	public Produto(Categoria categoria,String nome, Double preco, String marca) {
		this.idProduto = counterId++;
		this.categoria = categoria;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
	}
	
	public Categoria getCategoria(){
		return categoria;
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
	
	@Override
	public String toString() {
		return String.format("ID Produto: %d \nProduto: %s \nPreço: %s \nMarca: %s\n",
				getIdProduto(), getNome(), Utils.doubleToString(getPreco()), getMarca());
	}


	@Override
	public int hashCode() {
		return Objects.hash(idProduto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(idProduto, other.idProduto);
	}
	
}
