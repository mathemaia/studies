.text
	li $t1, 75		# carrega imediatamente o inteiro 75 para o registrador $t1
	li $t2, 20		# carrega imediatamente o inteiro 20 para o registrador $t2
	add $t0, $t1, $t2	# adiciona $t1 com $t2
	
	li $v0, 1		# configura o sistema para imprimir inteiros
	move $a0, $t0		# move o valor de $t0 para $a0 - lw não é usado pois não está buscando um valor da memória e sim da própria CPU
	syscall			# faz a impressão