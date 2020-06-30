<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="css/login.css" rel="stylesheet">
<!------ Include the above in your HEAD tag ---------->
<title>Login</title>
</head>
<body>
<div class="sidenav">
         <div class="login-main-text">
            <h2>Agenda<br> Paiol Agrícola</h2>
            <p>Entre com seu usuário.</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label>Usuário</label>
                     <input type="text" class="form-control" placeholder="Usuario" required>
                  </div>
                  <div class="form-group">
                     <label>Senha</label>
                     <input type="password" class="form-control" placeholder="Senha" required>
                  </div>
                  <button type="submit" class="btn btn-black">Entrar</button>
               </form>
            </div>
         </div>
      </div>
      <footer>
      <jsp:include page="rodape.jsp"></jsp:include>
      </footer>
</body>
</html>