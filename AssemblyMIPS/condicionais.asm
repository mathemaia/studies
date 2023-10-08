# Escreva um programa que lê um número inteiro e imprime se ele é par ou impar

.data
	msg: .asciiz "Forneça um número: "
	par: .asciiz "O número é PAR"
	impar: .asciiz "O número é IMPAR"

.text
	# imprime a mensagem
	li $v0, 4
	la $a0, msg
	syscall
	
	# recebe o número
	li $v0, 5
	syscall
	move $t1, $v0
	
	# faz a divisao
	li $t0, 2
	div $t1, $t0
	mfhi $s1
	
	# faz a comparação - se o resto for 0, então é par
	beq $s1, $zero, imprime_par
	li $v0, 4
	la $a0, impar
	syscall
	
	# encerra o programa
	li $v0, 10
	syscall
	
	imprime_par:
		li $v0, 4
		la $a0, par
		syscall