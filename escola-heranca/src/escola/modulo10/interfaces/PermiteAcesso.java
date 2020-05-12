package escola.modulo10.interfaces;

public interface PermiteAcesso {

	public boolean autenticar(String login, String senha);
	
	public boolean autenticar();
}
