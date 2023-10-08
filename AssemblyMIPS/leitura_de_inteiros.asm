.data
	forneca_idade: .asciiz "forneca sua idade: "
	idade: .ascii "sua idade eh: "
	
.text
	# mensagem de saudação
	li $v0, 4
	la $a0, forneca_idade
	syscall
	
	# lê a entrada do usuário
	li $v0, 5
	syscall
	
	# salva a entrada em outro registrador
	move $t0, $v0
	
	# imprime a mensagem de idade
	li $v0, 4
	la $a0, idade
	syscall
	
	# imprime a idade
	li $v0, 1
	move $a0, $t0
	syscall
	 