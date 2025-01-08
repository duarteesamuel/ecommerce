package validations;

import java.util.List;

import exceptions.LojaException;
import exceptions.ProdutoException;

public class Validator {
	
	private static boolean isValid = true;
	private static String numeros = ".*\\d.*";
	private static String simbolos = ".*[\\p{Punct}].*";
	
	
	//Verificar os dados da Loja
	public static boolean dadosLoja(String nome, String cnpj, List<LojaException> erros) {
		if(nome.isEmpty() || nome == null || cnpj.isEmpty() || cnpj == null) {
			erros.add(new LojaException("Registro negado: Preencha todos os campos."));
			isValid = false;
		}
		if(isStringValid(nome, numeros)) {
			erros.add(new LojaException("Registro negado: O nome da loja não pode conter números."));
			isValid = false;
		}
		if(isStringValid(nome, simbolos)) {
			erros.add(new LojaException("Registro negado: O nome da loja não pode conter caracteres especiais."));
			isValid = false;
		}
		
		
		return isValid;
	}
	
	//Verificar os dados do Proprietario
	public static boolean dadosProprietario(String nomeCompleto, String cpf, String email, List<LojaException> erros) {
		if(nomeCompleto.isEmpty() || nomeCompleto == null || cpf.isEmpty() || cpf == null || email.isEmpty() || email == null) {
			erros.add(new LojaException("Registro negado: Preencha todos os campos."));
			isValid = false;
		}
		if(isStringValid(nomeCompleto, numeros)) {
			erros.add(new LojaException("Registro negado: Nome não pode conter números."));
			isValid = false;
		}
		if(isStringValid(nomeCompleto, simbolos)) {
			erros.add(new LojaException("Registro negado: Nome não pode conter caracteres especiais."));
		}
		
		return isValid;
	}
	
	//Verificar os Dados do Produto
	public static boolean dadosProduto(String categoria,String nome, Double preco, String marca, List<ProdutoException> erros) {
		if(categoria == null || categoria.isEmpty() || nome == null || nome.isEmpty() || marca == null || marca.isEmpty()) {
			erros.add(new ProdutoException("Produto recusado: Preencha todos os Campos."));
			isValid = false;
		}
		
		if(isStringValid(categoria, numeros) || isStringValid(nome, numeros) || isStringValid(marca, numeros)) {
			erros.add(new ProdutoException("Produto recusado: Categoria, Nome e Marca não podem conter números."));
			isValid = false;
		}
		
		if(isStringValid(categoria, simbolos)|| isStringValid(nome, simbolos) || isStringValid(marca, simbolos)) {
			erros.add(new ProdutoException("Produto recusado: Categoria, Nome e Marca não podem conter caracteres especiais."));
			isValid = false;
		}
		
		if(preco == null || preco <= 0) {
			erros.add(new ProdutoException("Preço recusado: Insira um valor monetário válido (Ex: 1200,00)"));
		}
		
		return isValid;
		
	}
	
	
	public static boolean isStringValid(String entrada, String pattern) {
		return entrada != null && entrada.matches(pattern);
	}
}
