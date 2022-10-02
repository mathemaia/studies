.text
.globl main

main:	li $a0, 5		# Carrega o valor 5 para o reg. $a0
	li $a1, 2		# Carrega o valor 2 para o reg. $a1
	add $s0, $a0, $a1	# Soma $a0 com $a1 e carrega para o reg. $s0
	addi $s1, $s0, 1	# Soma o valor de $s0 com 1