package escola.modulo10.sistema;

public class Matriz {

	public static void main(String[] args) {
		
		double[][] notas = new double[2][4];
		
		notas [0][0] = 95;
		notas [0][1] = 80;
		notas [0][2] = 75;
		notas [0][3] = 65;
		
		notas [1][0] = 50;
		notas [1][1] = 70;
		notas [1][2] = 85;
		notas [1][3] = 74;
		
		for(int linhas=0; linhas<notas.length; linhas++) {
			System.out.println("-----linha "+linhas+"-----");
			System.out.println("--------------------");
			for(int colunas=0; colunas<notas[linhas].length; colunas++) {
				
				System.out.println("Coluna: "+colunas+" valor: "+notas[linhas][colunas]);
				System.out.println("--------------------");
				
			}
		}
		

	}

}
