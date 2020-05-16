package escola.modulo10.objetos;

import escola.modulo10.interfaces.PermiteAcesso;

public class Secretario extends Pessoa implements PermiteAcesso {
private String registro;
private String nivelCargo;
private String formacao;
private String usuario;
private String senha;

public Secretario(String user, String senha) {
	this.usuario = user;
	this.senha = senha;
}

public Secretario() {
	
}

public String getRegistro() {
	return registro;
}
public void setRegistro(String registro) {
	this.registro = registro;
}
public String getNivelCargo() {
	return nivelCargo;
}
public void setNivelCargo(String nivelCargo) {
	this.nivelCargo = nivelCargo;
}

public String getFormacao() {
	return formacao;
}
public void setFormacao(String formacao) {
	this.formacao = formacao;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((formacao == null) ? 0 : formacao.hashCode());
	result = prime * result + ((nivelCargo == null) ? 0 : nivelCargo.hashCode());
	result = prime * result + ((registro == null) ? 0 : registro.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Secretario other = (Secretario) obj;
	if (formacao == null) {
		if (other.formacao != null)
			return false;
	} else if (!formacao.equals(other.formacao))
		return false;
	if (nivelCargo == null) {
		if (other.nivelCargo != null)
			return false;
	} else if (!nivelCargo.equals(other.nivelCargo))
		return false;
	if (registro == null) {
		if (other.registro != null)
			return false;
	} else if (!registro.equals(other.registro))
		return false;
	return true;
}
@Override
public String toString() {
	return "Secretario [registro=" + registro + ", nivelCargo=" + nivelCargo + ", formacao=" + formacao + ", nome="
			+ nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
 }
@Override
public double salario() {
   return 3500.00;
}

@Override
public boolean autenticar(String login, String senha) {
	this.usuario =login;
	this.senha = senha;
	return autenticar();
}

@Override
public boolean autenticar() {
	// TODO Auto-generated method stub
	return usuario.equals("adm") && senha.equals("123");
}

}
