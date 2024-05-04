package br.com.hightechcursos.controller;

import jakarta.servlet.RequestDispatcher;
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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Chamando o Metodo GET");


		String acao = request.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if((acao!=null) && acao.equals("exc")) {
			
			String id = request.getParameter("id");
			Usuario usuario = new Usuario();
			usuario.setId(Integer.parseInt(id));
			usuarioDAO.excluir(usuario);
			// redirecionando pelo cliente
			response.sendRedirect("usucontroller.do?acao=lis");
			
		}
		
        if((acao!=null) && acao.equals("alt")) {
			
			String id = request.getParameter("id");
	        Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
			request.setAttribute("usuario", usuario);
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp"); 	
			saida.forward(request,response);
		
			
		}
       
        
       if((acao!=null) && acao.equals("cad")) {
			
	        Usuario usuario = new Usuario();
	        usuario.setId(0);
	        usuario.setNome("");
	        usuario.setLogin("");
	        usuario.setSenha("");
			request.setAttribute("usuario", usuario);
			RequestDispatcher saida = request.getRequestDispatcher("frmusuario.jsp"); 	
			saida.forward(request,response);
			
		}
		
		
        if((acao!=null) && acao.equals("lis")) {
		// 1 Obter a lista
		List<Usuario> lista = usuarioDAO.buscarTodos();
		
		// Engavetar no request a lista
		request.setAttribute("lista", lista);
		// Encaminhamento ao JSP
	    RequestDispatcher saida = request.getRequestDispatcher("listausuarios.jsp"); 	
		saida.forward(request,response);
        }
        
        
        
				
		
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
