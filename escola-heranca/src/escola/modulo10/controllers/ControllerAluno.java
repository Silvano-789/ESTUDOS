package escola.modulo10.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import escola.modulo10.objetos.Aluno;
import escola.modulo10.objetos.Diciplina;

public class ControllerAluno {
	
	List<Aluno> listaAluno = new ArrayList<Aluno>();
	double[] vetnotas = new double[4];
	Diciplina dic = new Diciplina();
	
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
			aluno.setEndereco(JOptionPane.showInputDialog("Endereço aluno:"));
			aluno.setSerie(JOptionPane.showInputDialog("Série aluno:"));
			
			for(int i=1; i<2; i++) {
				Diciplina diciplina = new Diciplina();
				diciplina.setDiciplina(JOptionPane.showInputDialog("Nome da diciplina "+i));
				for(int a=0; a<diciplina.getNota().length; a++) {
					String notas =(JOptionPane.showInputDialog("Nota da diciplina "+i));
					vetnotas[a] = Double.parseDouble(notas);
				
				}
				diciplina.setNota(vetnotas);
				
				
				aluno.getDiciplinas().add(diciplina);
			}
			
			listaAluno.add(aluno);
			JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!", "Salvar", 1);
			
			break;
		case 2:

			for (Aluno alunoL : listaAluno) {				
				JOptionPane.showMessageDialog(null, "Nome: "+alunoL.getNome()
				                                    +"\nSérie: "+alunoL.getSerie()+"º ano"
				                                    +"\nData Matr.: "+alunoL.getDataMatricula()
				                                    +"\nEscola: "+alunoL.getNomeEscola()
				                                    +"\nEndereço: "+alunoL.getEndereco()
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
					  StringBuilder imprime = new StringBuilder();
					    		imprime.append("Nome do Aluno: "+alunoS.getNome());
					      		imprime.append("\nSérie: "+alunoS.getSerie()+"º ano");
					      		imprime.append("\nEscola: "+alunoS.getNomeEscola());
					      		imprime.append("\n----------Diciplinas---------------");
					      		imprime.append("\n"+alunoS.getDiciplinas().toString().replace("[", "").replace("]", "").replace(",",""));
					      		imprime.append("\n----------Notas---------------");
					      		for(Diciplina d: alunoS.getDiciplinas()) {
									  	for(int i=0; i<dic.getNota().length; i++) {
									  		imprime.append("\nNota "+(i+1)+"º bimestre: "+d.getNota()[i]);
								   }  	    
								  }
					      		imprime.append("\nMédia: "+alunoS.calcMedia());
					      		imprime.append("\nSituação: "+alunoS.situacaoAluno());
					      		imprime.append("\n.........sis School 2020.........");
								   
					      		JOptionPane.showMessageDialog(null, imprime.toString());
				}
				ver = false;
			}
			
			if(ver) {
				JOptionPane.showMessageDialog(null, "Aluno não encontrado! \nverifique na lista de alunos no menu.", "Atenção", 0);				
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
						JOptionPane.showMessageDialog(null, "Aluno removido", "Remoção", 1);	
						vf = false;
						}
			          }				
					}
			if(vf) {
				JOptionPane.showMessageDialog(null, "Aluno não encontrado verifique!", "Atenção", 0);
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
