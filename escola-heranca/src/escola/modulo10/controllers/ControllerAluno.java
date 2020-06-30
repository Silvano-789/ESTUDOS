package escola.modulo10.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import escola.modulo10.objetos.Aluno;
import escola.modulo10.objetos.Diciplina;
import escola.modulo10.status.StatusAluno;

public class ControllerAluno {
	
	List<Aluno> listaAluno = new ArrayList<Aluno>();

	public void areaAluno() {		
		int op=0;
		while(op != 6) {
		 op = Integer.parseInt(JOptionPane.showInputDialog("-- Area do Aluno --"
		 												+ "\n1 >> Cadastrar aluno"
		 												+ "\n2 >> Listar Alunos"
		 												+ "\n3 >> Boletim escolar"
		 												+ "\n4 >> Remover"
		 												+ "\n5 >> Lista aprova��o"
		 												+ "\n6 >> Sair"));
		 switch (op) {
		case 1:
			Aluno aluno = new Aluno();
			
			aluno.setNome(JOptionPane.showInputDialog("Nome do aluno:"));
			aluno.setNomeEscola(JOptionPane.showInputDialog("Nome da escola:"));
			aluno.setDataMatricula(JOptionPane.showInputDialog("Data da matricula:"));
			aluno.setEndereco(JOptionPane.showInputDialog("Endere�o aluno:"));
			aluno.setSerie(JOptionPane.showInputDialog("S�rie aluno:"));
			
			for(int i=0; i<2; i++) {
				double[] vetnotas = new double[4];
				Diciplina diciplina = new Diciplina();
				diciplina.setDiciplina(JOptionPane.showInputDialog("Nome da diciplina "+(i+1)));
				for(int a=0; a<diciplina.getNota().length; a++) {
					String nota =(JOptionPane.showInputDialog("Nota do "+(a+1)+"� bimestre:"));
					vetnotas[a] = Double.parseDouble(nota);
					
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
					  StringBuilder imprime = new StringBuilder();
					    		imprime.append("Nome do Aluno: "+alunoS.getNome());
					      		imprime.append("\nS�rie: "+alunoS.getSerie()+"� ano");
					      		imprime.append("\nEscola: "+alunoS.getNomeEscola());
					      		imprime.append("\n----------Diciplinas---------------");
					      		/**/
					      		
					      		for(Diciplina d: alunoS.getDiciplinas()) {
						      		imprime.append("\nDiciplina: "+d.getDiciplina());
						      		imprime.append("\n----------Notas---------------");
						      		    double aux = 0;
						      		    double menor = 0;
						      		    double media = 0;
									  	for(int i=0; i<d.getNota().length; i++) {
									  		imprime.append("\nNota "+(i+1)+"� bimestre: "+d.getNota()[i]);
									  		if(i == 0) {
									  		   aux = d.getNota()[i];	
									  		}else if(d.getNota()[i] > aux) {
									  		   aux = d.getNota()[i];
									  		}
									  		if(i == 0) {
										  		   menor = d.getNota()[i];	
										  		}else if(d.getNota()[i] < menor) {
										  		   menor = d.getNota()[i];
										  		}
									  
									  		media += d.getNota()[i]/4;
									  		
								   }
									imprime.append("\nM�dia: "+media);
									imprime.append("\nMaior nota: "+aux);
									imprime.append("\nMenor nota: "+menor);
									
								  }
					      		
					      		imprime.append("\n.........sis School 2020.........");  
					      		JOptionPane.showMessageDialog(null, imprime.toString(), "Boletim escolar", 1);
				}
				ver = false;
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
				String buscAluno = JOptionPane.showInputDialog("Informe o nome do aluno:");
				boolean v = true;
				int cont =0;
				for (Aluno alun : listaAluno) {
					StringBuilder imp = new StringBuilder();
					if(alun.getNome().equalsIgnoreCase(buscAluno)) {
						double m =0;
						imp.append("---- Disciplinas ----");
						for(Diciplina di : alun.getDiciplinas()) {
							for(int b=0; b<di.getNota().length; b++) {
								m += di.getNota()[b];
							}
							imp.append("\nDici: "+alun.getDiciplinas().get(cont));
							if(m >= 70) {
									imp.append("\nSitu: "+StatusAluno.APROVADO);
							}else if(m >= 50 && m < 70) {
									imp.append("\nSitu:"+StatusAluno.RECUPERACAO);
							}else {
								   imp.append("\nSitu: "+StatusAluno.REPROVADO);
							}
							cont ++;
						  }
						}
						
					  JOptionPane.showMessageDialog(null, imp.toString(), "Aprova��o", 1);
					  v = false;
					  
					}
				if(v) {
					JOptionPane.showMessageDialog(null, "Aluno n�o cadastrado!", "Aten��o", 0);
				}
				break;
				
			case 6:
				
				break;
		default:
			break;
		}
	}
  }
}
