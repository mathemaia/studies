.text
.globl main

main:	la 	$a0, A		# Carrega o endereço de A em $a0
	lw 	$a1, 0($a0)	# Le o valor de $a0 para $a1
	la 	$t0, B		# Carrega o endereço de B em $t0
	lw 	$t1, 0($t0)	# Le o valor de $t0 para $t1
	addu 	$s0, $a1, $t1	# $s0 recebe $a1(A) + $t1(B)
	la 	$s1, C		# Carrega o endereço de C em $s1
	sw 	$s0, 0($s1)	# C = A + B
	
	li 	$v0, 10	
	syscall
	
.data
A: .word 1
B: .word 2
C: .word 0

