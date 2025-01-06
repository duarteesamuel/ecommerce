package application;

import models.Loja;
import services.LojaService;
import utils.Utils;

public class Main {

	public static void main(String[] args) {
		LojaService iniciar = new LojaService();
		
		System.out.println("Carregando o sistema...");
		Utils.timeout();
		iniciar.menu();
	}

}
