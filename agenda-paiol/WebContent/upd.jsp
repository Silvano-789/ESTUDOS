
<%@include file="../cabecalho.jsp" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Atualização de Contatos
            <small>Painel administrativo</small>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="glyphicon glyphicon-home"></i>  <a href="ServletPessoa?action=list"> Voltar</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Atualizações de contato
            </li>
        </ol>
    </div>
</div>
<!-- /.row -->
<div class="row">
    
    <div class="panel panel-default">
        <div class="panel-heading">
           Atualiza Contato
        </div>
        <div class="panel-body">
            
            <div class="alert ">
                ${msg}
            </div>
            <form action="ServletPessoa" method="post">
               
                <div class="col-lg-6">
                     
                    <div class="form-group">
                        <label>Código</label>
                        <input class="form-control" type="number" name="txtCodigo" readonly value="${lista.getCodigo()}"/>
                    </div>
                    
                    <div class="form-group">
                        <label>Nome</label>
                        <input class="form-control" type="text" name="txtNome" required value="${lista.getNome()}" />
                    </div>
                    <div class="form-group">
                        <label>Ramal</label>
                        <input class="form-control" type="text" name="txtRamal" required value="${lista.getRamal()}" />
                    </div>
                     <div class="form-group">
                        <label>Email</label>
                        <input class="form-control" type="text" name="txtEmail" required value="${lista.getEmail()}" />
                    </div>                    
                <button class="btn btn-primary btn-sm" type="submit">Salvar</button>
               </div>             
            </form>
        </div>
    </div>
</div>
<!-- /.row -->
<%@include file="../rodape.jsp" %>