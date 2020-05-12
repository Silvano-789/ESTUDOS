package escola.modulo10.objetos;

public class Diciplina {
	Double nota;
	String diciplina;

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getDiciplina() {
		return diciplina;
	}

	public void setDiciplina(String diciplina) {
		this.diciplina = diciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diciplina == null) ? 0 : diciplina.hashCode());
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
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
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  "Diciplina: "+ diciplina + "\nNota: " +nota+"\n";
	}	
}
