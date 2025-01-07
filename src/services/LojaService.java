package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.LojaException;
import models.Loja;
import models.Proprietario;
import utils.Utils;

public class LojaService{
	
	private static Scanner sc = new Scanner(System.in);
	private List<Loja> lojas = new ArrayList<>();
	private List<Proprietario> proprietarios = new ArrayList<>();
	
	public void menuLoja() {
		try {
			System.out.println("=============== MENU LOJA ===============");
			System.out.println("1. Cadastrar uma Loja.");
			System.out.println("2. Cadastrar um Proprietario.");
			System.out.println("3. Adicionar produtos ao estoque.");
			System.out.println("4. Atualizar produtos do estoque.");
			System.out.println("5. Remover Produtos do estoque.");
			System.out.println("6. Listar Produtos do estoque.");
			System.out.println("0. Sair");
			System.out.println("=========================================");
			System.out.print("Selecione uma opção: ");
			int opcao = sc.nextInt();
			switch(opcao) {
				case 1:
					registrarLoja();
					break;
				case 2:
					registrarProprietario();
					break;
				case 3:
					adicionarProduto();
					break;
				case 4:
					atualizarProduto();
					break;
				case 5:
					deletarProduto();
					break;
				case 6:
					listarProdutos();
					break;
				case 0:
					System.out.println("Saindo...");
					Utils.timeout();
					System.out.println("Obrigado por utilzar, Volte sempre!");
					System.exit(0);
				default:
					throw new LojaException("Digite um número inteiro válido.");
			}
		}
		catch(LojaException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		Utils.timeout();
		menuLoja();
	}
	
	
	//Methods
	public void registrarLoja() {
		List<LojaException> erros = new ArrayList<>();
		
		do {
			erros.clear();
			System.out.println("====================");
			System.out.println("   DADOS DA LOJA   ");
			System.out.println("====================");
			sc.nextLine();
			System.out.print("Nome da Loja: ");
			String nomeLoja = sc.nextLine();
			System.out.print("CNPJ: ");
			String cnpj = sc.nextLine();
			System.out.println("====================");
			//Verificações
			if(nomeLoja.isEmpty()) {
				erros.add(new LojaException("Nome da loja não pode ser vazio."));
			}
			if(cnpj.isEmpty()) {
				erros.add(new LojaException("CNPJ não pode ser vazio."));
			}
			if(erros.isEmpty()) {
				Loja loja = new Loja(nomeLoja, cnpj);
				System.out.println("Loja registrada com sucesso!");
			} else {
				for(LojaException erro : erros) {
					System.out.println("Erro: " + erro.getMessage());
				}
				System.out.println("Pressione ENTER para digitar novamente.");
			}
			
		}while(!erros.isEmpty());
	}
	
	public void registrarProprietario() {
		try {
			//Implementar lógica
		}
		catch(LojaException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void adicionarProduto() {
		try {
			//Implementar lógica
		}
		catch (LojaException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void atualizarProduto() {
		try {
			//Implementar lógica
		}
		catch (LojaException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void deletarProduto() {
		try {
			//Implementar lógica
		}
		catch (LojaException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void listarProdutos() {
		try {
			//Implementar lógica
		}
		catch (LojaException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void findById(int id) {
		try {
			//Implementar lógica
		}
		catch (LojaException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
