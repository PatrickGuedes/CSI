
 $(document).ready(function(){
		
		$('#frmLogin').validate({
            rules:{
                login:{
                    required: true,
                    minlength: 3
                },
                password: {
                    required: true,
                    minlength: 3
                }
                
            },
            messages:{
                login:{
                    required: "O campo login é obrigatorio.",
                    minlength: "O campo login deve conter no mínimo 3 caracteres."
                },
				
                password: {
                    required: "O campo senha é obrigatorio.",
					minlength: "O campo senha deve conter no mínimo 3 caracteres."
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
                    required: true,
					minlength: 6
                    //email: true
                }
                
            },
            messages:{
                username:{
                    required: "O campo login é obrigatorio.",
                    minlength: "O campo login deve conter no mínimo 3 caracteres."
                },
				password:{
                    required: "O campo senha é obrigatorio.",
                    minlength: "O campo senha deve conter no mínimo 6 caracteres."
                },
				
                termos: "Para se cadastrar você deve aceitar os termos de uso."
            }
 			
        });

    });