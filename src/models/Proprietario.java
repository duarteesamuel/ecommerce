package models;

public class Proprietario {
	
	private String nomeCompleto;
	private String cpf;
	private String email;
	private String telefone;
	
	//NoArgsConstructor
	public Proprietario() {
		
	}

	//AllArgsConstructor
	public Proprietario(String nomeCompleto, String cpf, String email, String telefone) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}
	
	//Getters and Setters
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
