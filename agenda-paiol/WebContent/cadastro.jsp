<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Contato</title>
</head>
<body>

	<jsp:include page="cabecalho.jsp"></jsp:include>
	<div align="center">
		<h3>Cadastro de Contatos</h3>
    <form action="">
    <label>Nome</label><br/>
    <input type="text" id="nome" name="nome" placeholder="Nome" required/><br/>
    <label>Numero de ramal</label><br/>
    <input type="text" id="numero" name="numero" placeholder="Ramal" required/>
    <br/><br/>
    <input type="submit" value="Salvar"/>
    </form>
	</div>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>