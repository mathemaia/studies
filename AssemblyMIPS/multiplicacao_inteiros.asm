.text
	li $t0, 12		# carrega imediatamente o inteiro 12 para o registrador $t0
	addi $t1, $zero, 10	# carrega (ou adiciona com 0) o inteiro 10 para o registrador $t1
	
	mul $s0, $t0, $t1	# faz a multiplicação de $t0 por $t1
	
	li $v0, 1		# configura o sistema para imprimir inteiros
	move $a0, $s0		# move o valor para o registrador que guardará a impressão
	syscall			# faz a impressão