package br.com.hightechcursos.teste;

import java.util.List;

import br.com.hightechcursos.entidades.Usuario;
import br.com.hightechcursos.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {


		//testCadastrar();
		//testAlterar();
		//testExcluir();
		//testBuscarTodos();
		//testAutenticar();
		testBuscarPorId();
		
	}

	private static void testCadastrar() {
		Usuario usu = new Usuario();
		usu.setNome("Virmeson");
		usu.setLogin("vir");
		usu.setSenha("vv123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
	}
	
	private static void testAlterar() {
		Usuario usu = new Usuario();
		usu.setNome("Jao da Silva");
		usu.setLogin("js");
		usu.setSenha("js123");
		usu.setId(2);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		
		
	}

	
	private static void testExcluir() {
		Usuario usu = new Usuario();
		
		usu.setId(5);
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		
	}
	
	
	private static void testBuscarTodos() {
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> listaResultado = usuDAO.buscarTodos();
		
		for(Usuario u:listaResultado) {
			System.out.println(u.getId()+" "+u.getNome()+" "+u.getLogin()+" "+u.getSenha());
		}
		
	}
	
	
	private static void testAutenticar() {
		Usuario usuario = new Usuario();
		usuario.setLogin("zeze");
		usuario.setSenha("678");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		System.out.println(usuarioDAO.autenticar(usuario));
		
	}
	
	
	private static void testBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuRetorno=usuarioDAO.buscarPorId(4);
		if(usuRetorno!=null) {
			System.out.println("nome: "+usuRetorno.getNome());
		}
	}

}
