package services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exceptions.LojaException;
import models.Loja;
import models.Proprietario;
import utils.Utils;
import validations.Validator;

public class CrudService {
	
	private static Scanner sc = new Scanner(System.in);
	private Loja loja;
	private static List<Loja> lojas = new ArrayList<>();
	private static List<Proprietario> proprietarios = new ArrayList<>();
	
	//CREATE
	public static void registrarLoja() {
		List<LojaException> erros = new ArrayList<>();
		System.out.println("Acessando...");
		Utils.timeout();
		do {
			erros.clear();
			System.out.println("====================");
			System.out.println("   DADOS DA LOJA   ");
			System.out.println("====================");
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
			}
		} while(!erros.isEmpty());
	}
	
	//UPDATE
	public static void atualizarLoja() {
		List<LojaException> erros = new ArrayList<>();
		System.out.println("Acessando...");
		Utils.timeout();
		System.out.println("==========================");
		System.out.println("      ATUALIZAR LOJA      ");
		System.out.println("==========================");
		System.out.print("ID Loja: ");
		int idLoja = sc.nextInt();
		sc.nextLine();
			try {
				Loja buscarLoja = findById(idLoja);
				if(buscarLoja != null) {
					do {
						erros.clear();
						System.out.print("Novo nome: ");
						String novoNome = sc.nextLine();
						System.out.print("Novo CNPJ: ");
						String novoCnpj = sc.nextLine();
						if(Validator.dadosLoja(novoNome, novoCnpj, erros)) {
							buscarLoja.setNomeLoja(novoNome);
							buscarLoja.setCnpj(novoCnpj);
							System.out.println("Dados atualizados com sucesso.");
							break;
						} else {
							for(LojaException erro : erros) {
								System.out.println(erro.getMessage());
							}
						}
					} while(!erros.isEmpty());
				} else {
					throw new LojaException("ID não encontrado");
				}
			} catch(LojaException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("Retornando ao menu principal");
			Utils.timeout();
			LojaService.menu();
		}
	
	public static void atualizarProprietario() {
		List<LojaException> erros = new ArrayList<>();
		System.out.println("Acessando...");
		Utils.timeout();
		System.out.println("=============================");
		System.out.println("    ATUALIZAR PROPRIETÁRIO   ");
		System.out.println("=============================");
		System.out.print("Informe o CPF do proprietário: ");
		String cpf = sc.nextLine();
		System.out.println("Buscando...");
		Utils.timeout();
		try {
			Proprietario buscarCpf = findByCpf(cpf);
			if(buscarCpf != null) {
				do {
					erros.clear();
					System.out.println("=================================================");
					System.out.print("Novo Proprietário: ");
					String novoNome = sc.nextLine();
					System.out.print("Novo CPF: ");
					String novoCpf = sc.nextLine();
					System.out.print("Novo E-mail: ");
					String novoEmail = sc.nextLine();
					if(Validator.dadosProprietario(novoNome, novoCpf, novoEmail, erros)) {
						buscarCpf.setNomeCompleto(novoNome);
						buscarCpf.setCpf(novoCpf);
						buscarCpf.setEmail(novoEmail);
						System.out.println("Atualizando...");
						Utils.timeout();
						System.out.println("Dados atualizados com sucesso!");
						break;
					} else {
						for (LojaException erro : erros) {
							System.out.println(erro.getMessage());
						}
					}
				} while(!erros.isEmpty());
			} else {
				System.out.println("============================================");
				throw new LojaException("CPF não encontrado!");
			}
		}
		catch (LojaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Retornando ao menu principal...");
		System.out.println("============================================");
		Utils.timeout();
		LojaService.menu();
	}
	
	//DELETE
	public static void deletarLoja() {
		System.out.println("Acessando...");
		Utils.timeout();
		System.out.println("=============================");
		System.out.println("        DELETAR LOJA         ");
		System.out.println("=============================");
		System.out.print("Informe o ID da Loja: ");
		int idLoja = sc.nextInt();
		sc.nextLine();
		try {
			Loja deletarLoja = findById(idLoja);
			if(deletarLoja != null) {
				System.out.println("Deletando...");
				Utils.timeout();
				lojas.remove(deletarLoja);
				System.out.println("Loja removida com sucesso.");
			}else {
				throw new LojaException("ID não encontado!");
			}
		} catch(LojaException e) {
			System.out.println(e.getMessage());
		}
		Utils.timeout();
		LojaService.menu();
	}
	
	public static void deletarProprietario() {
		System.out.println("Acessando...");
		Utils.timeout();
		System.out.println("=============================");
		System.out.println("     DELETAR PROPRIETÁRIO    ");
		System.out.println("=============================");
		System.out.print("Informe o CPF do Proprietário: ");
		String cpf = sc.nextLine();
		try {
			Proprietario buscarCpf = findByCpf(cpf);
			if(buscarCpf != null) {
				System.out.println("Deletando...");
				Utils.timeout();
				proprietarios.remove(buscarCpf);
				System.out.println("Proprietário deletado com sucesso.");
			} else {
				throw new LojaException("CPF não encontrado.");
			}
		} catch(LojaException e) {
			System.out.println(e.getMessage());
		} 
	}
	
	//ListAll
	public static void mostrarInfos() {
		System.out.println("Listando...");
		Utils.timeout();
		System.out.println("=============================");
		System.out.println("      DETALHES DA LOJA       ");
		System.out.println("=============================");
		List<LojaException> infos = new ArrayList<>();
		if(lojas.isEmpty()) {
			infos.add(new LojaException("Nenhuma loja cadastrada."));
		} else {
			for (Loja loja : lojas) {
				System.out.println(loja);
			}
		}
		
		if(proprietarios.isEmpty()) {
			infos.add(new LojaException("Nenhum proprietario cadastrado."));
		} else {
			for (Proprietario proprietario : proprietarios) {
				System.out.println(proprietario);
			}
		}
		
		for(LojaException info : infos) {
			System.out.println(info.getMessage());
		}
		Utils.timeout();
	}
	
	//Buscar pelo id
	public static Loja findById(int id) {
		for(Loja loja : lojas) {
			if(loja.getId() == id) {
				return loja;
			} 
		}
		return null;
	}
	
	//Buscar pelo cpf
	public static Proprietario findByCpf(String cpf) {
		for (Proprietario prop : proprietarios) {
			if(prop.getCpf().equals(cpf)) {
				return prop;
			}
		}
		
		return null;
	}
	
	//Get Lojas && Proprietarios
	public static List<Loja> getLojas(){
		return lojas;
	}
	
	public static List<Proprietario> getProprietarios(){
		return proprietarios;
	}
		
}
