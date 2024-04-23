package br.com.hightechcursos.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usucontroller.do") 
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando o Metodo GET");
		
		UsuarioDAO  usuarioDAO = new UsuarioDAO();
		List<Usuario> lista = usuarioDAO.buscarTodos();
		
		PrintWriter saida = response.getWriter();
		saida.println(lista);
		
				
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando o metodo POST");
		
		String id=request.getParameter("txtid");	
		String nome=request.getParameter("txtnome");
		String login=request.getParameter("txtlogin");
		String senha=request.getParameter("txtsenha");
		
		Usuario usuario = new Usuario();
		
		if(id!=null && id!="" && id!="0" ) {
			usuario.setId(Integer.parseInt(id));
		}
		
		
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		usuarioDAO.salvar(usuario);
		
		PrintWriter saida = response.getWriter();
		saida.print("Salvo com sucesso!");
		
		
		
		
	}

}
