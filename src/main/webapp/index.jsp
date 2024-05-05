<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <c:import url="includes/menu.jsp"></c:import>
  
  <h1> Bem vindo, '${sessionScope.usuLogado.nome}'  ao sistema !</h1>
  
  <img src="images/hightech.jpg" width="200" height="100"/>
  
</body>
</html>