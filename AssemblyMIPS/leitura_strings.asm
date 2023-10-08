.data
	nome: .space 8
	pergunta: .asciiz "Qual o seu nome? "
	saudacao: .asciiz "\nOlá, "

.text
	# imprime saudacao
	li $v0, 4
	la $a0, pergunta
	syscall
	
	# leitura do nome
	li $v0, 8
	la $a0, nome
	la $a1, 8
	syscall
	
	# imprime saudacao
	li $v0, 4
	la $a0, saudacao
	syscall
	
	# imprime nome
	li $v0, 4
	la $a0, nome
	syscall