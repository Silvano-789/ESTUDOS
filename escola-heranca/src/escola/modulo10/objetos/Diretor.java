package escola.modulo10.objetos;

import escola.modulo10.interfaces.PermiteAcesso;

public class Diretor extends Pessoa implements PermiteAcesso{	
private String regisEducacao;
private int tempoDirecao;
private String titulacao;
private String usuario;
private String senha;

public Diretor(String user, String senha) {
	this.usuario = user;
	this.senha = senha;
}

public Diretor() {
	
}


public String getRegisEducacao() {
	return regisEducacao;
}
public void setRegisEducacao(String regisEducacao) {
	this.regisEducacao = regisEducacao;
}
public int getTempoDirecao() {
	return tempoDirecao;
}
public void setTempoDirecao(int tempoDirecao) {
	this.tempoDirecao = tempoDirecao;
}
public String getTitulacao() {
	return titulacao;
}
public void setTitulacao(String titulacao) {
	this.titulacao = titulacao;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((regisEducacao == null) ? 0 : regisEducacao.hashCode());
	result = prime * result + tempoDirecao;
	result = prime * result + ((titulacao == null) ? 0 : titulacao.hashCode());
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
	Diretor other = (Diretor) obj;
	if (regisEducacao == null) {
		if (other.regisEducacao != null)
			return false;
	} else if (!regisEducacao.equals(other.regisEducacao))
		return false;
	if (tempoDirecao != other.tempoDirecao)
		return false;
	if (titulacao == null) {
		if (other.titulacao != null)
			return false;
	} else if (!titulacao.equals(other.titulacao))
		return false;
	return true;
}
@Override
public String toString() {
	return "Diretor [regisEducacao=" + regisEducacao + ", tempoDirecao=" + tempoDirecao + ", titulacao=" + titulacao
			+ ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + "]";
}
@Override
public double salario() {
	return 4000.00;
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
	return usuario.equals("secretario") && senha.equals("1234");
}
}
