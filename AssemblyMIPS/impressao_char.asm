.data
	char: .byte 'A'		# aspas simples para char e duplas para strings

.text
	li $v0, 4		# configura para imprimir char/string
	la $a0, char		# carrega o valor de char
	syscall			# fimprime o caractere
	
	li $v0, 10		# configura para terminar o programa
	syscall			# termina o programa