# Escreva uma função que verifica se um número inteiro positivo é par ou impar

.data
	msg: .asciiz "Forneça um número inteiro positivo: "
	par: .asciiz "O número é PAR!"
	impar: .asciiz "O número é IMPAR!"

.text
	.main:
		# imprime a mensagem
		la $a0, msg
		jal imprime_msg
		
		# recebe o número
		jal le_inteiro
		move $a0, $v0
		
		# chama a função
		jal divide
		
		beq $v0, $zero, eh_par
		li $v0, 4
		la $a0, impar
		syscall
		
		# termina o programa
		li $v0, 10
		syscall
		
	
	eh_par:
		li $v0, 4	
		la $a0, par	
		syscall		
			
		li $v0, 10	
		syscall		
		
	imprime_msg:
		li $v0, 4
		syscall
		jr $ra
		
	le_inteiro:
		li $v0, 5
		syscall
		jr $ra
	
	divide:
		li $t0, 2	
		div $a0, $t0
		mfhi $v0
		jr $ra
