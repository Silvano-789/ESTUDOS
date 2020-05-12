package escola.modulo10.funcoes;

import escola.modulo10.interfaces.PermiteAcesso;

public class FuncaoAutenticao {
	
	private PermiteAcesso permiteAcesso;
	
	public boolean autenticarUsuario() {
		
		return permiteAcesso.autenticar();
	}
	
	public FuncaoAutenticao(PermiteAcesso objetoCarregado) {
		this.permiteAcesso = objetoCarregado;
	}
}
