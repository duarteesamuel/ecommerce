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
			System.out.println("3. Atualizar Dados");
			System.out.println("4. Deletar Dados");
			System.out.println("5. Informações.");
			System.out.println("6. Mais Opções.");
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
					atualizarDados();
					break;
				case 4:
					deletarDados();
					break;
				case 5:
					mostrarInfos();
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
		System.out.println("Acessando...");
		Utils.timeout();
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
				lojas.add(loja);
				System.out.println("Loja registrada com sucesso!");
			} else {
				for(LojaException erro : erros) {
					System.out.println("Erro: " + erro.getMessage());
				}
				System.out.println("Pressione ENTER para digitar os dados novamente.");
			}
			
		}while(!erros.isEmpty());
	}
	
	public void registrarProprietario() {
		List<LojaException> erros = new ArrayList<>();
		System.out.println("Acessando...");
		Utils.timeout();
		do {
			erros.clear();
			System.out.println("=========================");
			System.out.println("  DADOS DO PROPRIETARIO  ");
			System.out.println("=========================");
			sc.nextLine();
			System.out.print("Nome completo: ");
			String nomeCompleto = sc.nextLine();
			System.out.print("CPF: ");
			String cpf = sc.nextLine();
			System.out.print("E-mail: ");
			String email = sc.nextLine();
			
			//Verificações
			if(nomeCompleto.isEmpty()) {
				erros.add(new LojaException("Nome do proprietário não pode ser vazio."));
			}
			if(cpf.isEmpty()) {
				erros.add(new LojaException("CPF não pode ser vazio."));
			}
			if(email.isEmpty()) {
				erros.add(new LojaException("E-mail não pode ser vazio."));
			}
			if(erros.isEmpty()) {
				Proprietario proprietario = new Proprietario(nomeCompleto, cpf, email);
				proprietarios.add(proprietario);
				System.out.println("Proprietário registrado com sucesso!");
			} else {
				for (LojaException erro : erros) {
					System.out.println("Erro: " + erro.getMessage());
				}
				System.out.println("Pressione ENTER para digitar os dados novamente!");
			}
			
		}while(!erros.isEmpty());
	}
	
	public void atualizarDados() {
		//implementar lógica
	}
	
	public void deletarDados() {
		//implementar lógica
	}
	
	public void mostrarInfos() {
		System.out.println("Acessando...");
		Utils.timeout();
		List<LojaException> infos = new ArrayList<>();
		if(lojas.isEmpty()) {
			infos.add(new LojaException("Nenhuma loja registrada."));
		} else {
			for (Loja loja : lojas) {
				System.out.println(loja);
			}
		}
		
		if(proprietarios.isEmpty()) {
			infos.add(new LojaException("Nenhum proprietario registrado."));
		} else {
			for (Proprietario proprietario : proprietarios) {
				System.out.println(proprietario);
			}
		}
		
		for(LojaException info : infos) {
			System.out.println(info.getMessage());
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
