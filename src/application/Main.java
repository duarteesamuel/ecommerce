package application;

import java.util.Locale;
import services.LojaService;
import utils.Utils;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		System.out.println("Carregando sistema...");
		Utils.timeout();
		LojaService.menu();
	}
}
