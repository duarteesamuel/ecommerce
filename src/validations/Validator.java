package validations;

import java.util.ArrayList;
import java.util.List;

import exceptions.LojaException;

public class Validator {
	
	private static boolean isValid = true;
	
	public static boolean dadosLoja(String nome, String cnpj, List<LojaException> erros) {
		if(nome.isEmpty()) {
			erros.add(new LojaException("O nome não pode ser vazio."));
			isValid = false;
		}
		if(cnpj.isEmpty()) {
			erros.add(new LojaException("O CNPJ não pode ser vazio."));
			isValid = false;
		}
		
		return isValid;
	}
	
	public static boolean dadosProprietario(String nomeCompleto, String cpf, String email, List<LojaException> erros) {
		if(nomeCompleto.isEmpty()) {
			erros.add(new LojaException("Nome do proprietário não pode ser vazio."));
			isValid = false;
		}
		if(cpf.isEmpty()) {
			erros.add(new LojaException("O CPF não pode ser vazio."));
			isValid = false;
		}
		if(email.isEmpty()) {
			erros.add(new LojaException("O E-mail não pode ser vazio."));
			isValid = false;
		}
		
		return isValid;
	}
	
	public static boolean dadosProduto() {
		return isValid;
	}
}
