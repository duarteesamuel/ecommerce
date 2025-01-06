package exceptions;

public class LojaException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//Construtor com mensagem personalizada
	public LojaException(String mensagem) {
		super(mensagem);
	}
}
