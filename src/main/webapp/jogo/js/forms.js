 $(document).ready(function(){
		
		$('#frmLogin').validate({
            rules:{
                nome:{
                    required: true,
                    minlength: 3
                },
                senha: {
                    required: true,
                    minlength: 3
                }
                
            },
            messages:{
                nome:{
                    required: "O campo nome � obrigatorio.",
                    minlength: "O campo nome deve conter no m�nimo 3 caracteres."
                },
				
                senha: {
                    required: "O campo senha � obrigatorio.",
					minlength: "O campo senha deve conter no m�nimo 3 caracteres."
                }
            }
 			
        });
        
		
		$('#frmCad').validate({
            rules:{
                username:{
                    required: true,
                    minlength: 3
                },
                password: {
                    required: true
					minlength: 6
                    //email: true
                }
                
            },
            messages:{
                username:{
                    required: "O campo login � obrigatorio.",
                    minlength: "O campo login deve conter no m�nimo 3 caracteres."
                },
				password:{
                    required: "O campo senha � obrigatorio.",
                    minlength: "O campo senha deve conter no m�nimo 6 caracteres."
                },
				
                termos: "Para se cadastrar voc� deve aceitar os termos de uso."
            }
 			
        });
    });