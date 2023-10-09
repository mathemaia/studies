.data
	top: .word 0x10010000

.text
	la $sp, top
	li $t0, 0	# variavel incrementadora
	li $t1, 3	# variavel para comparação
	
	while_insere:
		beq $t0, $t1, finish_insere		# checa fim do loop
		subi $sp, $sp, 4			# próxima posição da pilha
		add $t0, $t0, 1 			# incrementa
		
		sw $t0, 0($sp)				# grava o valor 
		
		
		j while_insere
	
	finish_insere:
		
		li $t0, 0
		subi $sp, $sp, 4
		while_retira:
			beq $t0, $t1, finish_retira
			addi $sp, $sp, 4
			
			li $v0, 1
			lw $a0, 0($sp)
			syscall
			
			add $t0, $t0, 1
			
			j while_retira
		
		finish_retira:
			li $v0, 10
			syscall
			
