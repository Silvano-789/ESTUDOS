package escola.modulo10.objetos;

import java.util.Arrays;

public class Diciplina {
	double[] nota = new double[4];
	String diciplina;

	public String getDiciplina() {
		return diciplina;
	}

	public void setDiciplina(String diciplina) {
		this.diciplina = diciplina;
	}

	public double[] getNota() {
		return nota;
	}

	public void setNota(double[] nota) {
		this.nota = nota;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diciplina == null) ? 0 : diciplina.hashCode());
		result = prime * result + Arrays.hashCode(nota);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diciplina other = (Diciplina) obj;
		if (diciplina == null) {
			if (other.diciplina != null)
				return false;
		} else if (!diciplina.equals(other.diciplina))
			return false;
		if (!Arrays.equals(nota, other.nota))
			return false;
		return true;
	}
	
	public String retornaNota() {
		for (int i = 0; i < nota.length; i++) {
			 
		}
		return "";
	}

	@Override
	public String toString() {
		return  "Diciplina:"+diciplina;
	}

	double media = 0;
    public double calcMedia() {
    	for(int i=0; i<nota.length; i++) {
    	   media += nota[i];
    	}
    	return media/nota.length;
    }
	
}
