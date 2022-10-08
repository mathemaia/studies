.text
.globl main
main:	li $t1, 2		# Carrega imediatamente 2 no reg. $t1
	addi $t2, $zero, 3	# Adiciona 0+3 e carrega para o reg. $t2
	mul $s0, $t1, $t2	# Multiplica ($t1 * $t2) e guara em $s0
	move $a0, $s0		# Move o valor de $s0 para $a0
	li $v0, 1		# Código para impressão de inteiros
	syscall
	
	li $v0, 10		# Código que finaliza o programa
	syscall