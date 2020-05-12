package escola.modulo10.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import escola.modulo10.objetos.Secretario;

public class ControllerSecretario {
	List<Secretario> listaSecretario = new ArrayList<Secretario>();
	public void areaSecretario() {
		int op =0;
		while(op != 4) {
			 op = Integer.parseInt(JOptionPane.showInputDialog("-- Area do Aluno --"
															 + "\n1 >> Cadastrar secret�rio"
															 + "\n2 >> Listar cadastros"
															 + "\n3 >> Remover"
															 + "\n4 >> Sair"));
			 switch (op) {
				case 1:
					Secretario secretario = new Secretario();
					secretario.setNome(JOptionPane.showInputDialog("Nome do secretario:"));
					secretario.setRegistro(JOptionPane.showInputDialog("n� de registro:"));
					secretario.setFormacao(JOptionPane.showInputDialog("Forma��o:"));
					secretario.setNivelCargo(JOptionPane.showInputDialog("Nivel de cargo:"));
				    secretario.setEndereco(JOptionPane.showInputDialog("Endere�o:"));
					secretario.setTelefone(JOptionPane.showInputDialog("Telefone:"));
					
					listaSecretario.add(secretario);
					JOptionPane.showMessageDialog(null, "Secretario salvo com sucesso!", "Salvar", 1);
					
					break;
				case 2:
					for (Secretario secret : listaSecretario) {
						JOptionPane.showMessageDialog(null, "Nome:.. "+secret.getNome()
														  +"\n-----------------------------------"
														  +"\nNivel Cargo:.. "+secret.getNivelCargo()
														  +"\nSalario:.. "+secret.salario()
														  +"\nForma��o:.. "+secret.getFormacao()
														  +"\n...........sis School 2020..........","Cadastros", 1);
					}
					break;
				case 3:
					String busca = JOptionPane.showInputDialog("Nome para remo��o:");
					for(int i=0; i<listaSecretario.size(); i++) {
						Secretario sec = listaSecretario.get(i);
						for(int b=0; b<listaSecretario.size();b++) {
							if(sec.getNome().equalsIgnoreCase(busca)) {
								listaSecretario.remove(i);
								JOptionPane.showMessageDialog(null, "Remo��o realizada!", "Remo��o", 1);
							}
						}
						
					}
				case 4:
					break;
					default:
						JOptionPane.showMessageDialog(null, "Op��o invalida!", "Aten��o", 0);
						break;
		  }
	
		}
	}
}
