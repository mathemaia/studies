.text	
	# atribui um valor inicial a variável de controle
	move $t0, $zero
	
	# loop - chamada recursiva
	while:
		beq $t0, 1000, finish	# checa a condição da variavel de controle
		addi $t0, $t0, 1	# incrementa a variavel de controle
		
		li $v0, 1		# imprime a variavel de controle
		move $a0, $t0		#
		syscall			#
		
		li $v0, 11		# faz a quebra de linha
		la $a0, '\n'		#
		syscall			#
		
		j while			# chama o while
	
	# saida do loop
	finish:		
		li $v0, 10		# fecha o programa
		syscall			#