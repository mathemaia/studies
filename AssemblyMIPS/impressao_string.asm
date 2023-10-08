.data
	msg: .asciiz "Olá mundo"	# mensagem a ser impressa

.text
	li	$v0, 4			# configura para imprimir strings
	la	$a0, msg		# busca o endereço de 'msg'
	syscall				# faz a impressão
