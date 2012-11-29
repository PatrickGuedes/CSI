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
			<h2>Cadastro</h2>
    
           <form action="/jogo/cadastrar.action" id="frmCad" method="POST">
		    
			<div class="height1x">
				<span class="campo">Login<br/><input type="text" name="username" id="login" class="text4x" value="" /></span>
	
			</div>	
            <div class="height1x">
            	<span class="campo">Senha<br /><input type="password" name="password" id="senha" class="text3x" value="" /></span>
            	</div>	
            <div class="height1x">
				
                <input type="submit" class="botao" value="Cadastrar"/>			
			</div>
           </form>
 
		</div><!-- fim conteudo-->	
	
	<div class= "clear"></div><!-- fix bug altura atomática-->
</div><!-- fim container -->
	
	

</body>
</html>
