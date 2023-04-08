.data
	idade: .word 25
.text
.globl main

main:	li $v0, 1	# Imprime inteiro.
	lw $a0, idade	# Le o valor idade para $a0
	syscall		# Executa o programa
	
	li $v0, 10	# Encerra o programa
	syscall