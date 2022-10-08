# Programa que faz multiplicação por potências de 2. Move os bits para a esquerda fazendo com que o número original seja duplicado.
# Ex:	(000110)2 = (6)10   --shift left logic-->   (001100)2 = (12)10

.text
.globl main
main:	li $t0, 2		# Carrega imediatamente 2 para $t0.
	sll $t1, $t0, 1		# Move os bits de $t0 1 casa para a esquerda (duplica).
	move $a0, $t1		# Move o conteúdo de $t1 para $a0 para permitir imprimir.
	li $v0, 1		# Código para impressão de inteiros.
	syscall
	
	li $v0, 10		# Finaliza o programa.
	syscall