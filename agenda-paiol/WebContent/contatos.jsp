<%@include file="cabecalho.jsp" %>
 <%
       Pessoa pessoa = new Pessoa();
       DaoPessoa dao = new DaoPessoa();
       List<Pessoa> lista = dao.listaContato();
  %>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Agenda interna Paiol Agricola

        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="glyphicon glyphicon-home"></i>  <a href="index.jsp">Listagem</a>
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

            <a  href="add.jsp" class="btn  btn-primary btn-sm fa fa-plus-square-o" >Novo Contato</a>
            
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
            ${msg} 
        
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome</th>
                        <th>Ramal</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                   <% for(Pessoa registros: lista){ %>
                    <tr>
                        <td><%= registros.getCodigo()%></td>
                        <td><%= registros.getNome() %></td>
                        <td><%= registros.getRamal() %></td>
                        <td><%= registros.getEmail() %></td>
                    </tr>
                    <%
                      }
                    %>                   
                </tbody>
            </table>          
                <!-- /.table-responsive -->
            </div>

        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
        </div>            
    <%@include file="modalExcluir.jsp" %>
    <%@include file="rodape.jsp" %>
