# E = A + B + D - 5 + F
.data
A: .word 1	# 0($t0)
B: .word 2	# 4($t0)
D: .word 3	# 8($t0)
E: .word 0	# 12($t0)
F: .word 4	# 16($t0)

.text
.globl main
main:	la $t0, A
	lw $t1, 0($t0)		# Conteúdo de A
	lw $t2, 4($t0)		# Conteúdo de B
	lw $t3, 8($t0)		# Conteúdo de D
	lw $t4, 16($t0)		# Conteúdo de F
	
	addu $s0, $t1, $t2	# $s0 = A + B
	addiu $s1, $t3, -5 	# $s0 = D - 5
	addu $s0, $s0, $s1	# $s0 = A + B + D - 5
	addu $s0, $s0, $t4	# $s0 = A + B + D - 5 + F
	sw $s0, 12($t0)		# E = $s0
	
	lw $a0, 12($t0)		# Código para impressão
	li $v0, 1		#
	syscall			#
	
	li $v0, 10		# Código que finaliza o programa
	syscall			#