package autocar.veiculos.objetos;

import java.util.ArrayList;
import java.util.List;

import autocar.veiculos.status.StatusVeiculo;

public class Carro {
	
	private String nome;
	private String modelo;
	private String cor;
	private double valor;
	private String placa;
	private int ano;
	private boolean alugado;
	
    List<Marca> marca = new ArrayList<Marca>();
	
	public List<Marca> getMarca() {
		return marca;
	}
	
	public void setMarca(List<Marca> marca) {
		this.marca = marca;
	}

	
	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Carro other = (Carro) obj;
		if (ano != other.ano)
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Carro [nome=" + nome + ", modelo=" + modelo + ", cor=" + cor + ", valor=" + valor + ", placa=" + placa
				+ ", ano=" + ano + ", marca=" + marca + ", getMarca()=" + getMarca() + ", getAno()=" + getAno()
				+ ", getPlaca()=" + getPlaca() + ", getNome()=" + getNome() + ", getModelo()=" + getModelo()
				+ ", getCor()=" + getCor() + ", getValor()=" + getValor() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
	public String AlugaCarro() {
		if(alugado == true) {
			return StatusVeiculo.ALUGADO;
		}else {
			return StatusVeiculo.LIVRE;
		}
		
	}
}