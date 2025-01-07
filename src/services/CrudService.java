package services;

import java.util.ArrayList;
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
	private static List<Proprietario> proprietario = new ArrayList<>();
	
	public static void atualizarLoja() {
		List<LojaException> erros = new ArrayList<>();
		System.out.print("ID Loja: ");
		int idLoja = sc.nextInt();
		sc.nextLine();
			try {
				Loja buscarLoja = LojaService.findLojaById(idLoja);
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
			}catch(LojaException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Retornando ao menu principal");
			Utils.timeout();
			LojaService.menuLoja();
		}
	
	public static void atualizarProprietario() {
		
	}
		
}
