<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.hightechcursos.entidades.Usuario" %>    
<%@ page import="java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


   <table border="1">

  <tr bgcolor="#CCCCC">
   <th>ID </th> <th>Nome</th> <th>Login</th> <th>Senha</th>
  </tr>
  

<%

 List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");

 
for(Usuario usu: lista) {
%>
	 
	<tr> 
        <td> <%=usu.getId() %>    </td>
        <td> <% out.println(usu.getNome()); %>  </td>
        <td> <%=usu.getLogin() %> </td>
        <td> <%=usu.getSenha() %> </td>
    </tr>



<%  
}

%>
</table>


</body>
</html>