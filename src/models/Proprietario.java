package models;

public class Proprietario {
	
	//Attributes
	private static Integer counterId = 1;
	private Integer id;
	private String nomeCompleto;
	private String cpf;
	private String email;
	
	//NoArgsConstructor
	public Proprietario() {
		
	}

	//AllArgsConstructor
	public Proprietario(String nomeCompleto, String cpf, String email) {
		this.id = counterId++;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.email = email;
	}
	
	//Getters and Setters
	public Integer id() {
		return id;
	}
	
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
	
	@Override
	public String toString() {
		return String.format("Proprietario: %s\nCPF: %s \nE-mail: %s",
				getNomeCompleto(), getCpf(), getEmail());
	}
}
