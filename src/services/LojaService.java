package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.LojaException;
import models.Loja;
import models.Proprietario;
import utils.Utils;
import validations.Validator;

public class LojaService{
	
	private static Scanner sc = new Scanner(System.in);
	private static List<Loja> lojas = new ArrayList<>();
	
	public static void menu() {
		System.out.println("=============== MENU PRINCIPAL ===============");
		System.out.println("| 1 - Registrar uma Loja.");
		System.out.println("| 2 - Registrar um Proprietario.");
		System.out.println("| 3 - Atualizar Dados");
		System.out.println("| 4 - Deletar Dados");
		System.out.println("| 5 - Acessar Loja");
		System.out.println("| 6 - Informações da Loja");
		System.out.println("| 0 - Sair");
		System.out.println("==============================================");
		System.out.print("Selecione uma opção: ");
		int opcao = sc.nextInt();
		sc.nextLine();
		switch(opcao) {
			case 1:
				CrudService.registrarLoja();
				break;
			case 2:
				CrudService.registrarProprietario();
				break;
			case 3:
				atualizarDados();
				break;
			case 4:
				deletarDados();
				break;
			case 5:
				acessarLoja();
				break;
			case 6:
				CrudService.mostrarInfos();
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
		menu();
	}
	
	public static void menuLoja() {
		System.out.println("========================");
		System.out.println("        MENU LOJA        ");
		System.out.println("========================");
		System.out.println("| 1 - Cadastrar Produto ");
		System.out.println("| 2 - Listar Produtos   ");
		System.out.println("| 3 - Comprar           "); 
		System.out.println("| 4 - Ver Carrinho      ");
		System.out.println("| 0 - Retornar ao menu principal");
		System.out.print("Selecione uma opção: ");
		int opcao = sc.nextInt();
		sc.nextLine();
		switch(opcao) {
			case 1:
				ProdutoService.cadastrarProduto();
				break;
			case 2:
				ProdutoService.verProdutos();
				break;
			case 3:
				ProdutoService.comprarProduto();
				break;
			case 4:
				ProdutoService.verCarrinho();
				break;
			case 0:
				System.out.println("Retornando ao menu principal...");
				Utils.timeout();
				menu();
		}
	}
	
	public static void acessarLoja() {
		System.out.println("Acessando...");
		Utils.timeout();
		try {
			if(CrudService.getLojas().isEmpty()) {
				throw new LojaException("Nenhuma loja registrada.");
			}else {
				menuLoja();
			}
		} catch(LojaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void atualizarDados() {
		System.out.println("Acessando...");
		Utils.timeout();
		System.out.println("================================");
		System.out.println("        ATUALIZAR DADOS         ");
		System.out.println("================================");
		System.out.println("1 - Atualizar Dados Loja");
		System.out.println("2 - Atualizar Dados Proprietário");
		System.out.println("0 - Retornar ao menu principal");
		System.out.print("Selecione uma opção: ");
		int opcao = sc.nextInt();
		sc.nextLine();
		switch(opcao) {
			case 1:
				CrudService.atualizarLoja();
				break;
			case 2:
				CrudService.atualizarProprietario();
			case 0:
				Utils.timeout();
				menu();
			default:
				throw new LojaException("Opção inválida.");
		}
		Utils.timeout();
	}
	
	public static void deletarDados() {
		System.out.println("Acessando...");
		Utils.timeout();
		System.out.println("================================");
		System.out.println("         DELETAR DADOS          ");
		System.out.println("================================");
		System.out.println("1 - Excluir Loja");
		System.out.println("2 - Excluir Proprietário");
		System.out.println("0 - Retornar ao menu principal");
		System.out.print("Selecione uma opção: ");
		int opcao = sc.nextInt();
		sc.nextLine();
		switch(opcao) {
		case 1:
			CrudService.deletarLoja();
			break;
		case 2:
			CrudService.deletarProprietario();
		case 0:
			Utils.timeout();
			menu();
		default:
			throw new LojaException("Opção inválida.");
	}
	Utils.timeout();
	}
	
	
}
