package br.com.hightechcursos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

/**
 * Servlet implementation class Autenticador
 */
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Autenticador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuRetorno = usuarioDAO.autenticar(usuario);
		
		if(usuRetorno!=null) {
			
			
			// criando sessao
			HttpSession sessao = request.getSession();
		    sessao.setAttribute("usuLogado", usuRetorno);
		    
		    // encaminha ao index
			request.getRequestDispatcher("index.jsp").forward(request,response);
			
		}else {
			
			response.sendRedirect("login.html");
			
		}
		
	}

}
