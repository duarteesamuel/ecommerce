package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.LojaException;
import models.Loja;
import models.Proprietario;
import utils.Utils;
import services.CrudService;
import validations.Validator;

public class LojaService{
	
	private static Scanner sc = new Scanner(System.in);
	private static List<Loja> lojas = new ArrayList<>();
	private static List<Proprietario> proprietarios = new ArrayList<>();
	private Loja loja;
	private Proprietario proprietario;
	
	public static void menuLoja() {
		System.out.println("=============== MENU LOJA ===============");
		System.out.println("1 - Cadastrar uma Loja.");
		System.out.println("2 - Cadastrar um Proprietario.");
		System.out.println("3 - Atualizar Dados");
		System.out.println("4 - Deletar Dados");
		System.out.println("5 - Informações.");
		System.out.println("6 - Mais Opções.");
		System.out.println("0 - Sair");
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
		Utils.timeout();
		menuLoja();
	}
	
	
	//Methods
	public static void registrarLoja() {
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
			
			if(Validator.dadosLoja(nomeLoja, cnpj, erros)) {
				Loja loja = new Loja(nomeLoja, cnpj);
				lojas.add(loja);
				System.out.println("Loja registrada com sucesso.");
				break;
			} else {
				for (LojaException erro : erros) {
					System.out.println(erro.getMessage());
				}
				System.out.println("PRESSIONE ENTER PARA INSERIR OS DADOS NOVAMENTE.");
			}
			
		} while(!erros.isEmpty());
	}
	
	public static void registrarProprietario() {
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
			System.out.println("=========================");
			
			//Validação
			if(Validator.dadosProprietario(nomeCompleto, cpf, email, erros)) {
				Proprietario proprietario = new Proprietario(nomeCompleto, cpf, email);
				proprietarios.add(proprietario);
				System.out.println("Proprietário registrado com sucesso.");
				break;
			}else {
				for (LojaException erro : erros) {
					System.out.println(erro.getMessage());
				}
				System.out.println("PRESSIONE ENTER PARA INSERIR OS DADOS NOVAMENTE.");
			}
		} while(!erros.isEmpty());
	}
	
	public static void atualizarDados() {
		System.out.println("Acessando...");
		Utils.timeout();
		System.out.println("=================================");
		System.out.println("1 - Atualizar Dados Loja");
		System.out.println("2 - Atualizar Dados Proprietário");
		System.out.println("0 - Retornar ao menu principal");
		System.out.print("Selecione uma opção: ");
		int opcao = sc.nextInt();
		switch(opcao) {
			case 1:
				CrudService.atualizarLoja();
				break;
			case 2:
				CrudService.atualizarProprietario();
				break;
			case 0:
				Utils.timeout();
				menuLoja();
			default:
				throw new LojaException("Opção inválida.");
		}
		Utils.timeout();
		atualizarDados();
	}
	
	public static void deletarDados() {
		//implementar lógica
	}
	
	public static void mostrarInfos() {
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
	
	public static Loja findLojaById(int id) {
		for(Loja loja : lojas) {
			if(loja.getId().equals(id)) {
				return loja;
			} 
		}
		return null;
	}
}
