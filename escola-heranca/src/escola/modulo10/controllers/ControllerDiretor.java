package escola.modulo10.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import escola.modulo10.objetos.Diretor;

public class ControllerDiretor {
    List<Diretor> listDiretor = new ArrayList<Diretor>();
	
	public  void areaDiretor() {
		
		int op=0;
		while(op!= 4) {
		op = Integer.parseInt(JOptionPane.showInputDialog("--- Area do Diretor ---"
														  +"\n1 >>> Cadastrar"
														  +"\n2 >>> Listar"
														  +"\n3 >>> Remover"
														  +"\n4 >>> Sair"));
			switch (op) {
			case 1:
				Diretor diretor = new Diretor();
				diretor.setNome(JOptionPane.showInputDialog("Informe o nome:"));
				diretor.setRegisEducacao(JOptionPane.showInputDialog("Informe reg. educação:"));
				diretor.setTitulacao(JOptionPane.showInputDialog("Informe a formação:"));
				diretor.setEndereco(JOptionPane.showInputDialog("Informe o endereço:"));
				diretor.setTelefone(JOptionPane.showInputDialog("Informe o telefone:"));
				diretor.setTempoDirecao(Integer.parseInt(JOptionPane.showInputDialog("Informe o tempo de mandato:")));
				
				listDiretor.add(diretor);
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado!", "Sucesso", 2);
				
				break;
				
			case 2:
				for (Diretor listaCadastro : listDiretor) {
					JOptionPane.showMessageDialog(null,"Nome:.. "+listaCadastro.getNome()
													  +"\n..................................................."
													  +"\nEnd:.. "+listaCadastro.getEndereco()
													  +"\nTel:.. "+listaCadastro.getTelefone()
													  +"\nFormação:.. "+listaCadastro.getTitulacao()
													  +"\nMandato:.. "+listaCadastro.getTempoDirecao()+" anos"
													  +"\nReg:....... "+listaCadastro.getRegisEducacao()
													  +"\nSalario:... "+listaCadastro.salario()
													  +"\n..................................................."
													  +"\n...........sis School 2020..........",
													  "Lista de cadastros", 1);
					
				}
				break;
				
			case 3:
				String nome = JOptionPane.showInputDialog("Informe o nome para remover:");
				boolean ver = false;
				
				for(int i=0; i<listDiretor.size(); i++) {
				  Diretor dir = listDiretor.get(i);			  
				  for(int a=0; a<listDiretor.size(); a++) {
					  if(dir.getNome().equalsIgnoreCase(nome)) {
						  listDiretor.remove(i);
						  JOptionPane.showMessageDialog(null, "Cadastro removido!", "Remoção", 1);
						  ver = true;
					  }
				  }				  
				}
				if(ver == false) {
					 JOptionPane.showMessageDialog(null, "Cadastro naão existente!", "Atenção", 0); 
				  }
				break;
			case 4:
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção invalida", "Atenção", 0);
			}
		}
		
		
		
	}

}
