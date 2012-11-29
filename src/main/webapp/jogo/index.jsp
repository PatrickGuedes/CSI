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
    
           <form action="" method="get">
           <div class="height1x">
				<span class="campo">Nome<br/><input type="text" name="nome" id="nome" class="text7x" value="" /></span>
	
			</div>	
            <div class="height1x">
            	<span class="campo">Senha<br /><input type="password" name="senha" id="senha" class="text3x" value="" /></span>
            	</div>	
            <div class="height1x">
				<input type="button" class="botao" onclick="javascript:document.location.replace('casos.html')"  value="Jogar"/>
                <input type="button" class="botao" onclick="javascript:document.location.replace('casos.html')"  value="Cadastrar"/>			
			</div>
           </form>
 
		</div><!-- fim conteudo-->	
	
	<div class= "clear"></div><!-- fix bug altura atomática-->
</div><!-- fim container -->

</body>
</html>
