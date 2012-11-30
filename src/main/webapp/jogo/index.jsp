<%@ include file="/jogo/inc/init.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ include file="/jogo/inc/taghead.jsp" %>

<body>

<div class="container">

<!-- ##################################CABEÇALHO############################## -->
	<div class="divcabecalhologin">
    	<div class="marcalogin float-left"></div>
		<div class="bg_login">
		</div>
	</div><!-- fim cabecalho -->

			
<!-- ##################################CONTEÚDO################################### -->				
		<div class="divconteudo float-left">
			<h2>Login</h2>
			
			<%
			String message = (String) session.getAttribute("LoginMessage");
			if (message != null) {
				out.print("<div class=\"mensagem_erro\">");
				out.print( message );
				out.print("</div><br/>");
			}
			%>
    
           <form action="/jogo/login.action" id="frmLogin" method="POST">
           <div class="height1x">
				<span class="campo">Usuário<br/><input type="text" name="login" id="nome" class="text4x" value="" /></span>
			</div>	
            <div class="height1x">
            	<span class="campo">Senha<br /><input type="password" name="password" id="senha" class="text3x" value="" /></span>
           	</div>
            <div class="height1x">
				<input type="submit" class="botao" value="Jogar"/>
                <input type="button" class="botao" onclick="javascript:document.location.replace('cadastro.jsp');"  value="Cadastrar"/>			
			</div>
           </form>
 
		</div><!-- fim conteudo-->	
	
	<div class= "clear"></div><!-- fix bug altura atomática-->
</div><!-- fim container -->

</body>
</html>
