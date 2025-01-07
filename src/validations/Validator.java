package validations;

import java.util.ArrayList;
import java.util.List;

import exceptions.LojaException;

public class Validator {
	
	private boolean isValid = true;
	
	public boolean dadosLoja(String nome, String cnpj, List<LojaException> erros) {
		if(nome.isEmpty()) {
			erros.add(new LojaException("O nome não pode ser vazio."));
			this.isValid = false;
		}
		if(cnpj.isEmpty()) {
			erros.add(new LojaException("O CNPJ não pode ser vazio."));
			this.isValid = false;
		}
		
		return this.isValid;
	}
	
	public boolean dadosProprietario(String nomeCompleto, String cpf, String email, List<LojaException> erros) {
		if(nomeCompleto.isEmpty()) {
			erros.add(new LojaException("Nome do proprietário não pode ser vazio."));
			this.isValid = false;
		}
		if(cpf.isEmpty()) {
			erros.add(new LojaException("O CPF não pode ser vazio."));
			this.isValid = false;
		}
		if(email.isEmpty()) {
			erros.add(new LojaException("O E-mail não pode ser vazio."));
			this.isValid = false;
		}
		
		return this.isValid;
		
	}
}
