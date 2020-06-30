package paiol.agenda.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paiol.agenda.dao.DaoPessoa;
import paiol.agenda.model.Pessoa;

@WebServlet("/ServletPessoa")
public class ServletPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public ServletPessoa() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("action");
		String pagina = "";
		String msg ="";
		DaoPessoa dao;
		switch (acao) {
		case "del":	
			
			dao = new DaoPessoa();
			String id = request.getParameter("id");
			boolean deletou = dao.deletaContato(Integer.parseInt(id));
			
			List<Pessoa> listaExclusao = dao.listaContato();
			request.setAttribute("lista", listaExclusao);
			pagina = "home.jsp";
			if(deletou) {
				msg = "Contato foi excluido com sucesso!";
			}else {
				msg = "Erro ao excluir o contato!";
			}
			break;
			
		case "upd":
		    dao = new DaoPessoa();
			String cod = request.getParameter("id");
			Pessoa pessoaEdit = dao.buscarContato(Integer.parseInt(cod));
			request.setAttribute("lista", pessoaEdit);
			pagina ="upd.jsp";
			break;
			
		case "list":	
			dao = new DaoPessoa();
			List<Pessoa> lista = dao.listaContato();
			request.setAttribute("lista", lista);
			pagina = "home.jsp";
			break;	
			
		case "listUser":
			dao = new DaoPessoa();
			String nome = request.getParameter("txtFiltro");
			List<Pessoa> listaUsers = dao.ListaUsers(nome);
			request.setAttribute("listaUsuario", listaUsers);
			pagina = "index.jsp";
			break;
		}
		request.setAttribute("msg", msg);
		RequestDispatcher destino = request.getRequestDispatcher(pagina);
		destino.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*instancias dos obejtos*/
	Pessoa pessoa = new Pessoa();
	DaoPessoa dao = new DaoPessoa();
	String msg ="";
	String pagina ="";
	
	String codigo = request.getParameter("txtCodigo");
	String nome =  request.getParameter("txtNome");
	String ramal = request.getParameter("txtRamal");
	String email = request.getParameter("txtEmail");
	
	pessoa.setCodigo(!codigo.isEmpty()? Integer.parseInt(codigo): 0);
	pessoa.setNome(nome);
	pessoa.setRamal(ramal);
	pessoa.setEmail(email);
	
	if(codigo.isEmpty() || codigo == null) {
	boolean gravou = dao.salvaContato(pessoa);
	if(gravou) {
		 msg = "Contato salvo com sucesso";
	}else {
		 msg = "Erro ao salva o contato";
	}
	pagina = "add.jsp";
	}else {
		boolean atualizou = dao.alteraContato(pessoa);
		if(atualizou) {
			 msg = "Contato atualizado com sucesso";
		}else {
			 msg = "Erro ao atualizar o contato";
		}
		pagina = "upd.jsp";
	}
	request.setAttribute("msg", msg);
	RequestDispatcher despacha = request.getRequestDispatcher(pagina);
	despacha.forward(request, response);
	
  }
}
