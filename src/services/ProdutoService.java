package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import exceptions.ProdutoException;
import models.Produto;
import utils.Utils;

public class ProdutoService {
	
	private static Scanner sc = new Scanner(System.in);
	private static List<Produto> produtos = new ArrayList<>();
	private static Map<Produto, Integer> carrinho = new HashMap<>();
	
	
	
	public static void cadastrarProduto() {
		List<ProdutoException> erros = new ArrayList<>();
		System.out.println("Acessando...");
		Utils.timeout();
		do {
			erros.clear();
			System.out.println("===================");
			System.out.println("   DADOS PRODUTO   ");
			System.out.println("===================");
			System.out.print("Nome do produto: ");
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			Double preco = sc.nextDouble();
			System.out.print("Marca: ");
			String marca = sc.nextLine();
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
