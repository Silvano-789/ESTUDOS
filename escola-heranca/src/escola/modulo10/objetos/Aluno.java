package escola.modulo10.objetos;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
  private String serie;
  private String nomeEscola;
  private String dataMatricula;
	List<Diciplina> diciplinas = new ArrayList<Diciplina>();
	Diciplina dic = new Diciplina();
	
	public List<Diciplina> getDiciplinas() {
			return diciplinas;
	}
	
	public void setDiciplinas(List<Diciplina> diciplinas) {
			this.diciplinas = diciplinas;
	}  
	  
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getNomeEscola() {
		return nomeEscola;
	}
	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}
	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataMatricula == null) ? 0 : dataMatricula.hashCode());
		result = prime * result + ((nomeEscola == null) ? 0 : nomeEscola.hashCode());
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
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
		Aluno other = (Aluno) obj;
		if (dataMatricula == null) {
			if (other.dataMatricula != null)
				return false;
		} else if (!dataMatricula.equals(other.dataMatricula))
			return false;
		if (nomeEscola == null) {
			if (other.nomeEscola != null)
				return false;
		} else if (!nomeEscola.equals(other.nomeEscola))
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [serie=" + serie + ", nomeEscola=" + nomeEscola + ", dataMatricula=" + dataMatricula
				+ ", diciplinas=" + diciplinas + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ "]";
	}

	@Override
	public double salario() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
