package escola.modulo10.sistema;

import javax.swing.JOptionPane;

import escola.modulo10.objetos.Aluno;
import escola.modulo10.objetos.Diciplina;

public class ArrayObjeto {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		Diciplina disciplina = new Diciplina();
		Diciplina disciplina2 = new Diciplina();
		double[] notasDici = {70,7.5,80,95};
		double[] notasDici2 = {95,80,75,65};
		
		aluno.setNome("Marcos");
		aluno.setSerie("7");
		aluno.setNomeEscola("Lucas");
		aluno.setTelefone("66 99969-9693");
		aluno.setEndereco("Rua 26");
		aluno.setDataMatricula("30/01/2010");
		
		disciplina.setDiciplina("Matematica");
		disciplina.setNota(notasDici);
		disciplina2.setDiciplina("Portugues");
		disciplina2.setNota(notasDici2);
		
		aluno.getDiciplinas().add(disciplina);
		aluno.getDiciplinas().add(disciplina2);
		
		
		Aluno[] arrayObj = new Aluno[1];
		
		arrayObj[0] = aluno;
		
		StringBuilder imp = new StringBuilder();
		for(int i=0; i<arrayObj.length; i++) {
			imp.append("Nome aluno: "+arrayObj[i].getNome());
			
			for(Diciplina d: arrayObj[i].getDiciplinas()) {
			imp.append("\nDisciplina: "+d.getDiciplina());
			  for(int pos=0; pos <d.getNota().length; pos++) {
				 imp.append("\nNota: "+(pos+1)+": "+d.getNota()[pos]); 
			  }
			}
			
		}
		JOptionPane.showMessageDialog(null,imp.toString(), "Boletim", 1);
		
	}

}
