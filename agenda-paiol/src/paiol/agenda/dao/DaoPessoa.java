package paiol.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import paiol.agenda.conexao.ConexaoBanco;
import paiol.agenda.model.Pessoa;

public class DaoPessoa {
	private Connection conexao;

	public DaoPessoa() {
		conexao = ConexaoBanco.getConnection();
	}

	public boolean salvaContato(Pessoa pessoa) {
		String sql = "insert into ramal (nome,numero, email) values (?,?,?)";
		try {
			PreparedStatement insert = conexao.prepareStatement(sql);
			insert.setString(1, pessoa.getNome());
			insert.setString(2, pessoa.getRamal());
			insert.setString(3, pessoa.getEmail());
			insert.execute();

			conexao.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Pessoa> listaContato() {
		List<Pessoa> lista = new ArrayList<Pessoa>();

		String sql = "select * from ramal order by nome";
		try {
			PreparedStatement busca = conexao.prepareStatement(sql);
			ResultSet resultado = busca.executeQuery();

			while (resultado.next()) {
				Pessoa pessoa = new Pessoa();
				pessoa.setCodigo(resultado.getInt("id"));
				pessoa.setNome(resultado.getString("nome"));
				pessoa.setRamal(resultado.getString("numero"));
				pessoa.setEmail(resultado.getString("email"));

				lista.add(pessoa);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public boolean deletaContato(int id) {
		String sql = "delete from ramal where id = ?";

		try {
			PreparedStatement deleta = conexao.prepareStatement(sql);
			deleta.setInt(1, id);
			deleta.executeUpdate();
			conexao.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Pessoa buscarContato(int id) {
		String sql = "select * from ramal where id=" + id;
		try {
			PreparedStatement atualiza = conexao.prepareStatement(sql);
			ResultSet resul = atualiza.executeQuery();

			if (resul.next()) {
				Pessoa contato = new Pessoa();
				contato.setCodigo(resul.getInt("id"));
				contato.setNome(resul.getString("nome"));
				contato.setRamal(resul.getString("numero"));
				contato.setEmail(resul.getString("email"));

				return contato;
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
	}

	public boolean alteraContato(Pessoa pessoa) {
		String sql = "UPDATE ramal SET nome=?, numero=?, email=? WHERE id =" + pessoa.getCodigo();
		try {
			PreparedStatement atualiza = conexao.prepareStatement(sql);
			atualiza.setString(1, pessoa.getNome());
			atualiza.setString(2, pessoa.getRamal());
			atualiza.setString(3, pessoa.getEmail());
			atualiza.executeUpdate();
			conexao.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conexao.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return false;

	}

	public List<Pessoa> ListaUsers(String nome) {
		List<Pessoa> lista = new ArrayList<Pessoa>();
		String sql = "select * from ramal where nome like "+"'%"+nome+"%'";
		try {
			PreparedStatement resultado = conexao.prepareStatement(sql);
			ResultSet buscaUsers = resultado.executeQuery();

			while (buscaUsers.next()) {
				Pessoa user = new Pessoa();
				user.setCodigo(buscaUsers.getInt("id"));
				user.setNome(buscaUsers.getString("nome"));
				user.setRamal(buscaUsers.getString("numero"));
				user.setEmail(buscaUsers.getString("email"));

				lista.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
