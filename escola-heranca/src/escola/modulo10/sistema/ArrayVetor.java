package escola.modulo10.sistema;

import javax.swing.JOptionPane;

public class ArrayVetor {

	public static void main(String[] args) {
		
		int pos = Integer.parseInt(JOptionPane.showInputDialog("Qual o tamanho do vetor:"));
		double[] notas = new double [pos];
	
		for(int posi=0; posi<notas.length; posi++) {
			double nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota "+(posi+1)+":"));
			notas[posi] = nota;
		}
				
		//System.out.println(notas[0]+"\n"+notas[1]+"\n"+notas[2]+"\n"+notas[3]);
        System.out.println("------------for-----------------");
		for(int i=0; i<notas.length; i++) {
			System.out.println("Nota "+(i+1)+":"+notas[i]);
		}

		System.out.println("-------------while---------------");
		int n =0;
		while(n <notas.length) {
			System.out.println("Nota "+(n+1)+":"+notas[n]);
			n++;
		}
		System.out.println("--------------média----------------");
		double media = 0.0;
		for(int m=0; m<notas.length; m++) {
			 media += notas[m];
			
		}
		System.out.println("Média: "+media/notas.length);
		
	}

}
