package br.com.hightechcursos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/bancocjweb1";
	public static final String USER_LOGIN = "root";
	public static final String USER_PASSWD = "admin";

	
	Connection con;
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName(DRIVER); // força o carregamento do driver
			con = DriverManager.getConnection(URL, USER_LOGIN, USER_PASSWD);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {

			System.out.println("Não pode conectar:" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado!");
			
		}
		return con;
	}

}
