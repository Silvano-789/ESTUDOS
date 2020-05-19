package escola.modulo10.sistema;

import java.util.Arrays;
import java.util.List;

public class SplitArray {

	public static void main(String[] args) {
		/*Converte texto para Vetor usando split*/
		String texto = "Silvano, Java, 85, 90, 75, 65";
		
		String[] valorArray = texto.split(",");
		
		System.out.println("Nome: "+ valorArray[0]);
		System.out.println("Curso:"+ valorArray[1]);
		System.out.println("Nota 01:"+ valorArray[2]);
		System.out.println("Nota 02:" + valorArray[3]);
		System.out.println("Nota 03:"+ valorArray[4]);
		System.out.println("Nota 04:"+ valorArray[5]);
		
		/*Converte Vetor para lista*/
		List<String> lista = Arrays.asList(valorArray);
	    
		System.out.println("------------"+"\nNome: "+lista.get(0)+"\nCurso: "+lista.get(1)+"\nNota 01:"+lista.get(2)
		                             +"\nNota 02:"+lista.get(4)+"\nNota 03:"+lista.get(4)+"\nNota 04:"+lista.get(5));

		/*Converte lista para vetor*/
		String[] converteLista = lista.toArray(new String[6]);
		
		System.out.println("------------"+"\nNome: "+converteLista[0]+"\nCurso: "+converteLista[1]+"\nNota 01: "+converteLista[2]
				                        +"\nNota 02: " +converteLista[3]+"\nNota 03: "+converteLista[4]+"\nNota 04: "+converteLista[5]);
		
		
	}

}
