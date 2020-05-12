package escola.modulo10.sistema;

import javax.swing.JOptionPane;
import escola.modulo10.controllers.ControllerAluno;
import escola.modulo10.controllers.ControllerDiretor;
import escola.modulo10.controllers.ControllerSecretario;
import escola.modulo10.funcoes.FuncaoAutenticao;
import escola.modulo10.objetos.Secretario;

public class Sistema {

	public static void main(String[] args) {
	
    for(int i=0; i<3; i++) {
    	String user = JOptionPane.showInputDialog("Usuario:");
    	String senha = JOptionPane.showInputDialog("Senha:");
        
    	
    	if(new FuncaoAutenticao(new Secretario(user, senha)).autenticarUsuario()) {
    		Menu();
    		break;
    	}else {
    		JOptionPane.showMessageDialog(null, "Usuario ou senha invalido!", "Atenção", 0);
    	}
      }

	}

	private static void Menu() {
		ControllerDiretor control = new ControllerDiretor();
		ControllerAluno controlA = new ControllerAluno();
		ControllerSecretario controlS = new ControllerSecretario();
		int op= 0;
		while(op != 4) {
			op = Integer.parseInt(JOptionPane.showInputDialog("--- Gerenciador escolar ---"
															  +"\n--- Escolha uma opção ---"
															  +"\n1 >>> Area Diretor"
															  +"\n2 >>> Area Aluno"
															  +"\n3 >>> Area Secretario"
															  +"\n4 >>> Finalizar"));															 			
			
			switch (op) {
			case 1:
				control.areaDiretor();
				break;
			case 2:
				controlA.areaAluno();
				break;
			case 3:
				controlS.areaSecretario();
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Software finalizado!", "Finalizado", 1);
				break;
				
				
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida por favor tente novamente!", "Atenção", 0);
			}
		}		
	}
}
