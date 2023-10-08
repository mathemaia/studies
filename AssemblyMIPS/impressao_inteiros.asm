.data
	idade: .word 56

.text
	li $v0, 1		# configura o sistema para imprimir inteiros
	lw $a0, idade		# carrega o endereço de 'idade'
	syscall			# imprime inteiros
				
	li $v0, 10		# configura o sistema para encerrar o programa
	syscall			# encerra o programa