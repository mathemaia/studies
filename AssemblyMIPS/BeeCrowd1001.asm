# BeeCrowd 1001
# Leia 2 valores inteiros e armazene-os nas variáveis A e B. Efetue a soma de A e B atribuindo o seu resultado na variável X. 
# Imprima X conforme exemplo apresentado abaixo. Não apresente mensagem alguma além daquilo que está sendo especificado e não esqueça 
# de imprimir o fim de linha após o resultado, caso contrário, você receberá "Presentation Error".

.data
	x: .asciiz "X = "

.text
	# recebe A
	li $v0, 5
	syscall
	move $t1, $v0
	
	# recebe B
	li $v0, 5
	syscall
	move $t2, $v0
	
	# faz a soma
	add $s0, $t1, $t2
	
	#imprime o resultado
	li $v0, 4
	la $a0, x
	syscall
	li $v0, 1
	move $a0, $s0
	syscall
	
	