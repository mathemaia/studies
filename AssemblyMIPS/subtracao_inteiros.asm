.text
	## VERSÃO 1
	li $t1, 75		# carrega imediatamente 75 ao registrador $t1
	li $t2, 25		# carrega imediatamente 25 ao registrador $t2
	sub $t0, $t1, $t2	# subtrai $t1 de $t2
	li $v0, 1		# configura o sistema para imprimir inteiros
	move $a0, $t0		# move o valor de $t0 para ser impresso
	syscall			# faz a impressão
	
	## VERSÃO 2
	li $t1, 75		# carrega imediatamente 75 ao registrador $t1
	subi $t0, $t1, 25	# subtrai imediatamente 25 do valor que está em $t1
	li $v0, 1		# configura o sistema para impressão de inteiros
	syscall			# faz a impressão