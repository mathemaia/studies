.data
	msg1: .asciiz "divisão inteira: "
	msg2: .asciiz "\nresto: "

.text
	li $t1, 5	# atribui o valor 5 para o registrador $t1
	li $t2, 2	# atribui o valor 2 para o registrador $t2
	
	div $t1, $t2	# a parte inteira vai para lo, o resto vai para hi
	
	mflo $s0	# move o valor de lo para o registrador $s0 (move from lo) - resultado da divisão inteira
	mfhi $s1	# move o valor de hi para o registrador $s1 (move from hi) - resultado do resto da divisão
	
	# imprime msg1
	li $v0, 4
	la $a0, msg1
	syscall
	
	# imprime o resultado da divisão inteira
	li $v0, 1
	move $a0, $s0
	syscall
	
	# imprime msg2
	li $v0, 4
	la $a0, msg2
	syscall
	
	# imprime o resto da divisão
	li $v0, 1
	move $a0, $s1
	syscall
	
	# sai do programa
	li $v0, 10
	syscall