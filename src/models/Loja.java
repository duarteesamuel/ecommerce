package models;

import utils.Utils;

public class Loja {
	
	private static Integer counterId = 1;
	private Integer id;
	private String nome;
	private String cnpj;
	private String estado;
	private String telefone;
	private String registro;
	private Proprietario propietario;
	
	//NoArgsConstructor
	public Loja() {
		
	}
	
	//AllArgsConstructor
	public Loja(String nome, String cnpj, String estado, String telefone) {
		this.id = counterId++;
		this.nome = nome;
		this.cnpj = cnpj;
		this.estado = estado;
		this.telefone = telefone;
		this.registro = Utils.registro();
	}
	
	//Getters & Setters
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRegistro() {
		return registro;
	}

	public Proprietario getPropietario() {
		return propietario;
	}
	
}
