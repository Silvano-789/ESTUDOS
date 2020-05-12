package escola.modulo10.objetos;

public abstract class Pessoa {
   protected String nome;
   protected String endereco;
   protected String telefone;
   
   public abstract double salario();

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getTelefone() {
	return telefone;
}

public void setTelefone(String telefone) {
	this.telefone = telefone;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
	Pessoa other = (Pessoa) obj;
	if (endereco == null) {
		if (other.endereco != null)
			return false;
	} else if (!endereco.equals(other.endereco))
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	if (telefone == null) {
		if (other.telefone != null)
			return false;
	} else if (!telefone.equals(other.telefone))
		return false;
	return true;
}

@Override
public String toString() {
	return "Pessoa [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
}
 
}
