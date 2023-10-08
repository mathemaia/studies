.data
	nome: .asciiz "Meu nome é Matheus!"

.text	
	.main:
		la $a0, nome		# guarda o valor que será impresso
		jal imprime_nome	# chama a função
		
		li $v0, 10		# termina o programa para impedir uma chamada recursiva infinita
		syscall			#
	
	imprime_nome: 
		li $v0, 4		# configura e faz a impressão
		syscall			#
		
		jr $ra			# volta para a linha que chamou a função