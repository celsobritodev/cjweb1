
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agora usando JSTL</title>
</head>

<body>


   <table border="1">

  <tr bgcolor="#CCCCC">
   <th>ID </th> <th>Nome</th> <th>Login</th> <th>Senha</th> <th> Acao </th>
  </tr>
  


<c:forEach items="${requestScope.lista}" var="usu">
	 
	<tr> 
        <td> ${usu.id}    </td>
        <td> ${usu.nome}  </td>
        <td> ${usu.login} </td>
        <td> ${usu.senha} </td>
        <td>
        
         <a href="usucontroller.do?acao=exc&id=${usu.id}"> Excluir </a>
         | 
         <a href="usucontroller.do?acao=alt&id=${usu.id}"> Alterar </a>
        
        </td>
    </tr>


</c:forEach>

</table>


</body>
</html>