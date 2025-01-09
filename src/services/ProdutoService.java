package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import enums.Categoria;
import exceptions.ProdutoException;
import models.Eletronico;
import models.Produto;
import models.Smartphone;
import utils.Utils;
import validations.Validator;

public class ProdutoService {
	
	private static Scanner sc = new Scanner(System.in);
	private static List<Produto> produtos = new ArrayList<>();
	private static List<Produto> eletronicos = new ArrayList<>();
	private static List<Produto> smartphones = new ArrayList<>();
	private static Map<Produto, Integer> carrinho = new HashMap<>();
	
	
	
	public static void cadastrarProduto() {
		List<ProdutoException> erros = new ArrayList<>();
		System.out.println("Acessando...");
		Utils.timeout();
		do {
			try {
				erros.clear();
				System.out.println("========================");
				System.out.println("   CADASTRAR PRODUTO    ");
				System.out.println("========================");
				System.out.print("Categoria (SMARTPHONES/ELETRONICOS): ");
				String entradaCate = sc.nextLine().toUpperCase().trim();
				System.out.print("Nome do Produto: ");
				String nome = sc.nextLine();
				System.out.print("Preço: ");
				Double preco = sc.nextDouble();
				sc.nextLine();
				System.out.print("Marca: ");
				String marca = sc.nextLine();
				if(Validator.dadosProduto(entradaCate, nome, preco, marca, erros)) {
					Categoria categoria = Categoria.valueOf(entradaCate);
					if(categoria == Categoria.SMARTPHONES) {
						Produto smartphone = new Smartphone(categoria, nome, preco, marca);
						smartphones.add(smartphone);
						produtos.add(smartphone);
					} else if(categoria == Categoria.ELETRONICOS) {
						Produto eletronico = new Eletronico(categoria, nome, preco, marca);
						eletronicos.add(eletronico);
						produtos.add(eletronico);
					}
					System.out.printf("%s, cadastrado com sucesso!%n", nome);
					System.out.println("====================================");
				} else {
					for (ProdutoException erro : erros) {
						System.out.println(erro.getMessage());
					}
				}
				System.out.print("Digite sim para adicinar um novo produto ou não para retornar a loja: ");
				char resp = sc.next().charAt(0);
				resp = Character.toUpperCase(resp);
				sc.nextLine();
				switch(resp) {
					case 'S':
						cadastrarProduto();
						break;
					case 'N':
						System.out.println("Retornando a loja...");
						Utils.timeout();
						LojaService.acessarLoja();
						break;
					default:
						throw new ProdutoException("Entrada inválida. Digite apenas sim ou não!");
				}
			} catch(ProdutoException e) {
				System.out.println(e.getMessage());
			}
		} while(!erros.isEmpty());
	}
	
	public static void verProdutos() {
		try {
			System.out.println("=======================");
			System.out.println("    LISTAR PRODUTOS    ");
			System.out.println("=======================");
			System.out.println("1 - Smartphones");
			System.out.println("2 - Eletrônicos");
			System.out.print("Selecione a lista de produtos: ");
			int opcao = sc.nextInt();
			sc.nextLine();
			Utils.timeout();
			if(opcao == 1) {
				if(smartphones.isEmpty()) {
					throw new ProdutoException("Nenhum produto encontrado.");
				}
				else {
					for(Produto produto : smartphones) {
						System.out.println(produto);
					}
				}
			}
			else if(opcao == 2) {
				if(eletronicos.isEmpty()) {
					throw new ProdutoException("Nenhum produto encontrado.");
				} else {
					for(Produto produto : eletronicos) {
						System.out.println(produto);
					}
				}
			}
		} catch(ProdutoException e) {
			System.out.println(e.getMessage());
		}
		LojaService.acessarLoja();
	}
	
	public static void comprarProduto() {
		try {
			if(produtos.isEmpty()) {
				throw new ProdutoException("Nenhum produto cadastrado.");
			} 
			
			System.out.println("====================");
			System.out.println("  COMPRAR PRODUTOS  ");
			System.out.println("====================");
			System.out.println("Listando produtos...");
			Utils.timeout();
			System.out.println("=============== PRODUTOS DISPONIVEIS ===============");
			exibirProdutos(produtos);
			
			System.out.print("ID Produto que deseja adicionar ao carrinho: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			boolean isPresent = false;
			
			for(Produto p : produtos) {
				if(p.getIdProduto() == id) {
					int quantidade = 0;
					carrinho.put(p, quantidade + 1);
					
					System.out.println("Produto adicionado ao carrinho.");
					isPresent = true;
					
					if(isPresent) {
						System.out.println("Adicionar outro produto ao carrinho? Sim ou Não: ");
						char resp = sc.next().charAt(0);
						resp = Character.toUpperCase(resp);
						
						if(resp == 'S') {
							comprarProduto();
						}
						else {
							finalizarCompra();
						}
					}
				} else {
					throw new ProdutoException("Produto não encontrado!");
				}
			}
		}
		catch(ProdutoException e) {
			System.out.println(e.getMessage());
		}
		LojaService.acessarLoja();
	}
	
	//Implementar lógica de aumentar quantidade do mesmo produto no carrinho
	public static void finalizarCompra() {
		double valorTotal = 0.0;
		System.out.println("=========================");
		System.out.println("     FINALIZAR COMPRA    ");
		System.out.println("=========================");
		for(Produto p : carrinho.keySet()) {
			int quantidade = carrinho.get(p);
			valorTotal = quantidade * p.getPreco();
			System.out.printf("Produto: %s - Quantidade: x%d%n", p.getNome(), quantidade);
		}
		System.out.println("Valor total da compra: " + Utils.doubleToString(valorTotal));
		carrinho.clear();
		System.out.println("=======================");
		System.out.println("Finalizando compra...");
		Utils.timeout();
		System.out.println("Compra realizada. Obrigado pela preferência!");
	}
	
	public static void verCarrinho() {
		try {
			System.out.println("===================");
			System.out.println("    SEU CARRINHO   ");
			System.out.println("===================");
			if(!carrinho.isEmpty()) {
				for(Produto p : carrinho.keySet()) {
					System.out.printf("| Produto: %s - x%d%n", p, carrinho.get(p));
				}
			} else {
				throw new ProdutoException("Seu carrinho está vazio.");
			}
		}catch(ProdutoException e) {
			System.out.println(e.getMessage());
		}
		LojaService.acessarLoja();
	}
	
	public static void exibirProdutos(List<Produto> produtos) {
		try {
			if(produtos.isEmpty()) {
				throw new ProdutoException("Nenhum produto cadastrado");
			}
			else {
				for (Produto p : produtos) {
					System.out.println(p);
				}
			}
		} catch (ProdutoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean findById(int id) {
		
	}
}
