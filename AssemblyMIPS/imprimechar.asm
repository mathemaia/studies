.data
char: .byte 'A'

.text
.globl main

main:	li $v0, 4	# Instrução para impressão de String ou char.
	la $a0, char	# Carrega o endereço para o registrador $a0
	syscall
	
	li $v0, 10	# Comando que encerra o programa
	syscall