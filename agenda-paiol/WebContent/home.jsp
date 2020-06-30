<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../cabecalho.jsp" %>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Painel administrativo
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="glyphicon glyphicon-home"></i>  <a href="index.jsp">Voltar</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> listagem de registros
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">

        <div class="panel-body">

            <a  href="add.jsp" class="btn  btn-primary btn-sm fa fa-plus-square-o" >  Novo Contato</a>
            
        </div>
    </div>
</div>
<!-- /.row -->
<div class="row">
    <div class="panel panel-default">
        <form action="#" method="post">
            <div class="form-group input-group">
                <input type="text" class="form-control" name="txtFiltro" placeholder="Busca contato...">
                                <span class="input-group-btn"><button class="btn btn-default" type="submit"><i class="fa fa-search"></i></button></span>
                            </div>
        </form>
        <div class="panel-body">
         <div class="alert ">
                ${msg}
         </div>          
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Ramal</th>
                        <th>Email</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                  <c:forEach items="${lista}" var="contato">
                    <tr>
                        <td><c:out value="${contato.codigo}"></c:out></td>
                        <td><c:out value="${contato.nome}"></c:out></td>
                        <td><c:out value="${contato.ramal}"></c:out></td>
                        <td><c:out value="${contato.email}"></c:out></td>
                        <td><a href="ServletPessoa?action=upd&id=${contato.codigo}" class="btn  btn-primary btn-sm">Alterar</a>
                            <a href="ServletPessoa?action=del&id=${contato.codigo}" class="btn  btn-danger btn-sm">Excluir</a>
                        </td>
                    </tr>
                    </c:forEach>                   
                </tbody>
            </table>          
                <!-- /.table-responsive -->
            </div>
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
        </div>            
    <%@include file="rodape.jsp" %>
