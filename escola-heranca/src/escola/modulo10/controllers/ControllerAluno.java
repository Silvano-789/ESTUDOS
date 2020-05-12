package escola.modulo10.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import escola.modulo10.objetos.Aluno;
import escola.modulo10.objetos.Diciplina;

public class ControllerAluno {
	
	List<Aluno> listaAluno = new ArrayList<Aluno>();
	
	public void areaAluno() {		
		int op=0;
		while(op != 5) {
		 op = Integer.parseInt(JOptionPane.showInputDialog("-- Area do Aluno --"
		 												+ "\n1 >> Cadastrar aluno"
		 												+ "\n2 >> Listar Alunos"
		 												+ "\n3 >> Boletim escolar"
		 												+ "\n4 >> Remover"
		 												+ "\n5 >> Sair"));
		 switch (op) {
		case 1:
			Aluno aluno = new Aluno();
			aluno.setNome(JOptionPane.showInputDialog("Nome do aluno:"));
			aluno.setNomeEscola(JOptionPane.showInputDialog("Nome da escola:"));
			aluno.setDataMatricula(JOptionPane.showInputDialog("Data da matricula:"));
			aluno.setEndereco(JOptionPane.showInputDialog("Endere�o aluno:"));
			aluno.setSerie(JOptionPane.showInputDialog("S�rie aluno:"));
			
			for(int i=1; i<5; i++) {
				Diciplina diciplina = new Diciplina();
				diciplina.setDiciplina(JOptionPane.showInputDialog("Nome da diciplina "+i));
				diciplina.setNota(Double.parseDouble(JOptionPane.showInputDialog("Nota da diciplina "+i)));
				
				aluno.getDiciplinas().add(diciplina);
			}
			
			listaAluno.add(aluno);
			JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!", "Salvar", 1);
			
			break;
		case 2:

			for (Aluno alunoL : listaAluno) {				
				JOptionPane.showMessageDialog(null, "Nome: "+alunoL.getNome()
				                                    +"\nS�rie: "+alunoL.getSerie()+"� ano"
				                                    +"\nData Matr.: "+alunoL.getDataMatricula()
				                                    +"\nEscola: "+alunoL.getNomeEscola()
				                                    +"\nEndere�o: "+alunoL.getEndereco()
				                                    +"\nContato: "+alunoL.getTelefone()
				                                    +"\n----------Diciplinas---------------"
				                                    +"\n"+alunoL.getDiciplinas().toString().replace("[", "").replace("]", "").replace(",", "")
				                                    +"\n.........sis School 2020........."
				                                    , "Lista de alunos", 1);
	
			}
			break;
		case 3:
			String busca = JOptionPane.showInputDialog("Informe o nome do aluno:");
			boolean ver = true;
			for (Aluno alunoS : listaAluno) {
				if(alunoS.getNome().equalsIgnoreCase(busca)) {
				JOptionPane.showMessageDialog(null, "Nome do Aluno: "+alunoS.getNome()
				                                    +"\nS�rie: "+alunoS.getSerie()+"� ano"
				                                    +"\nEscola: "+alunoS.getNomeEscola()
				                                    +"\n----------Diciplinas---------------"
				                                    +"\n"+alunoS.getDiciplinas().toString().replace("[", "").replace("]", "").replace(",", "")
				                                    +"\nM�dia: "+alunoS.calcMedia()
				                                    +"\nSitua��o: "+alunoS.situacaoAluno()
				                                    +"\n.........sis School 2020........."
				                                    ,  "Boletim Escolar", 1);
													ver = false;
				}
			}
			if(ver) {
				JOptionPane.showMessageDialog(null, "Aluno n�o encontrado! \nverifique na lista de alunos no menu.", "Aten��o", 0);				
			}
			break;
		case 4:
			String remove = JOptionPane.showInputDialog("Informe o nome do aluno:");
			boolean vf = true;
			for(int b=0; b<listaAluno.size();b++) {
				Aluno aluBuscado = listaAluno.get(b);
				for(int c=0; c<listaAluno.size(); c++) {
					if(aluBuscado.getNome().equalsIgnoreCase(remove)) {
						listaAluno.remove(b);
						JOptionPane.showMessageDialog(null, "Aluno removido", "Remo��o", 1);	
						vf = false;
						}
			          }				
					}
			if(vf) {
				JOptionPane.showMessageDialog(null, "Aluno n�o encontrado verifique!", "Aten��o", 0);
			}
							
			break;
			
			case 5:
				break;
		default:
			break;
		}
	}
  }
}