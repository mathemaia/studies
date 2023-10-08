# Faça um programa que pede para usuário definir um valor de parada para o loop e imprima todos os números neste intervalo.

.data
	msg: .asciiz "Forneça uma parada para o loop: "

.text
	# imprime a mensagem
	li $v0, 4
	la $a0, msg
	syscall
	
	# recebe o número de parada
	li $v0, 5
	syscall
	move $s0, $v0
	
	# da um valor inicial a variável de controle
	li $t0, 0
	
	while:
		beq $t0, $s0, finish	# controlador do loop
		addi $t0, $t0, 1	#
		
		li $v0, 1		# imprime a variavel
		move $a0, $t0		#
		syscall			#
		
		li $v0, 11		# imprime a quebra de linha
		li $a0, '\n'		#
		syscall			#
		
		j while			# chama a recursão
	
	finish:
		li $v0, 10		# fecha o programa
		syscall			#
	