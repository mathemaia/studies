.text
.globl main

main:	li $a0, 2		# Carrega o valor 2 para o reg. $a0
	li $a1, 7		# Carrega o valor 7 para o reg. $a1
	sub $s0, $a0, $a1	# Subtrai $a0(2) de $a1(7) e carrega para $s0(-5)
	subi $s1, $s0, 1	# Subtrai $s0(-5) de 1 e guarda em $s1(-6)