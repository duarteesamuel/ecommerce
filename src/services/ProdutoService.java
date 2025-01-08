package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exceptions.ProdutoException;
import models.Eletronicos;
import models.Produto;
import utils.Utils;
import validations.Validator;

public class ProdutoService {
	
	private static Scanner sc = new Scanner(System.in);
	private static List<Produto> produtos = new ArrayList<>();
	
	
	
	public static void cadastrarProduto() {
		List<ProdutoException> erros = new ArrayList<>();
		System.out.println("Acessando...");
		Utils.timeout();
		do {
			erros.clear();
			System.out.println("===================");
			System.out.println("   DADOS PRODUTO   ");
			System.out.println("===================");
			System.out.println("Categoria: ");
			String categoria = sc.nextLine();
			System.out.print("Nome do produto: ");
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			Double preco = sc.nextDouble();
			System.out.println("===================");
		} while (!erros.isEmpty());
	}
	
	public static void comprarProduto() {
		
	}
	
	public static void verProdutos() {
		
	}
	
	public static void verCarrinho() {
		
	}
	
}
