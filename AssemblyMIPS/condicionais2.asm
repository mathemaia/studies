# Escreva um programa que lê um número inteiro e imprime se ele é maior, menor ou igual a zero

.data
	msg: .asciiz "Insira um número: "
	maior: .asciiz "O número é MAIOR que zero."
	menor: .asciiz "O número é MENOR que zero."
	igual: .asciiz "O número é IGUAL a zero."

.text
	# imprime a mensagem
	li $v0, 4
	la $a0, msg
	syscall
	
	# recebe o número
	li $v0, 5
	syscall
	move $t0, $v0
	
	# condicionais
	blt $t0, $zero, label_menor
	bgt $t0, $zero, label_maior
	beq $t0, $zero, label_igual
	

	label_menor:
		li $v0, 4
		la $a0, menor
		syscall
		
		li $v0, 10
		syscall
	
	label_maior:
		li $v0, 4
		la $a0, maior
		syscall
		
		li $v0, 10
		syscall
	
	label_igual:
		li $v0, 4
		la $a0, igual
		syscall
		
		li $v0, 10
		syscall