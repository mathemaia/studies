.data
	msg: .asciiz "Ola mundo" 	# Guarda a string na variável msg.

.text
	li $v0, 4 	# Instrução para impressão de string.
	la $a0, msg	# Carrega o endereço de para o registrador
	syscall 	# Realiza a instrução final