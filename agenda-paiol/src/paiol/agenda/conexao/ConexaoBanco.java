package paiol.agenda.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
	
	private static String url = "jdbc:postgresql://localhost:5432/paiol";
	private static String usuario = "postgres";
	private static String senha = "admin";
	private static Connection conexao = null;
	
	static {
		conectar();
	}

	public ConexaoBanco() {
		conectar();
	}

	private static void conectar() {
		try {
			if(conexao == null) {
			  Class.forName("org.postgresql.Driver");
			  conexao = DriverManager.getConnection(url, usuario, senha);
			  conexao.setAutoCommit(false);
			}
			
		} catch (Exception e) {
     		e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return conexao;
	}

}
