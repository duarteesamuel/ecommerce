package models;

import utils.Utils;

public class Loja {
	
	//Attributes
	private static Integer counterId = 1;
	private Integer id;
	private String nomeLoja;
	private String cnpj;
	private String dataRegistro;
	private Proprietario proprietario;
	
	//NoArgsConstructor
	public Loja() {
	}
	
	//AllArgsConstructor
	public Loja(String nomeLoja, String cnpj) {
		this.id = counterId++;
		this.nomeLoja = nomeLoja;
		this.cnpj = cnpj;
		this.dataRegistro = Utils.registro();
	}
	
	//Getters & Setters
	public Integer getId() {
		return id;
	}
	
	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	@Override
	public String toString() {
		return String.format("ID Loja: %d \nNome da Loja: %s \nRegistro: %s\n",
				getId(), getNomeLoja(), getDataRegistro());
	}
	
}
