package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	
	private static final NumberFormat valorFormatado = new DecimalFormat("R$ #,##0.00");
	
	public static String doubleToString(Double valor) {
		return valorFormatado.format(valor);
	}
	
	public static String registro() {
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return formatoData.format(data);
	}
	
	public static void timeout() {
		try {
			Thread.sleep(1500);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
