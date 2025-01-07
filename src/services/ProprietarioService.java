package services;

import java.util.Scanner;

import exceptions.LojaException;

import java.util.List;
import java.util.ArrayList;

import models.Proprietario;
import utils.Utils;
import validations.Validator;

public class ProprietarioService {
	
	private static Scanner sc = new Scanner(System.in);
	private static List<Proprietario> proprietarios = new ArrayList<>();
	
	private Proprietario proprietario;
	

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
				System.out.println("PRESSIONE ENTER PARA INSERIR OS DADOS NOVAMENTE.");
			}
		} while(!erros.isEmpty());
	}
	
	public static Proprietario findByCpf(String cpf) {
		for (Proprietario prop : proprietarios) {
			if(prop.getCpf().equals(cpf)) {
				return prop;
			}
		}
		
		return null;
	}
	
	public static void atualizarNome() {
		List<LojaException> erros = new ArrayList<>();
		//Implementar lógica
		
	}
	
	public static void atualizarEmail() {
		List<LojaException> erros = new ArrayList<>();
		//Implementar lógica
	}
}
