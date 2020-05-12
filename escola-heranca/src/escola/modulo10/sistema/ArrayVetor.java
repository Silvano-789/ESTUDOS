package escola.modulo10.sistema;

public class ArrayVetor {

	public static void main(String[] args) {
		
		double[] notas = new double [4];
		
		notas[0] = 5.2;
		notas[1] = 5;
		notas[2] = 5.0;
		notas[3] = 8.0;
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
