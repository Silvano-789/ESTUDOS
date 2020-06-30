<%@include file="../cabecalhohome.jsp" %>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.quicksearch/2.3.1/jquery.quicksearch.js"></script>

<%
       Pessoa pessoa = new Pessoa();
       DaoPessoa dao = new DaoPessoa();
       List<Pessoa> lista = dao.listaContato();
  %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
           Quer falar com quem hoje?  
        </h1>
        <br/>
    </div>
</div>

<!-- /.row -->
<div class="inicial">
    <div class="panel panel-default">
            <div class="form-group input-group">
                 <span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
                 <input name="consulta" id="txt_consulta" placeholder="Digite o nome aqui..." type="text" class="form-control">
            </div>
        <div class="panel-body">
        <div class="table-responsive">
            <table id="tabela" class="table table-bordered table-hover">
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
			 <script>
                $('input#txt_consulta').quicksearch('table#tabela tbody tr');
            </script>
            </div>
        </div>
        <!-- /.panel-body -->
    </div>
    <!-- /.panel -->
        </div>  
<%@include file="../rodape.jsp" %>