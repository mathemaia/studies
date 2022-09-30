.text
.globl main

main:	la $t0, a	# Carrega o endereço de 'a' e guarda no registrador $t0
	lw $t1, 0($t0)	# Carrega o dado do endereço contido no registrador $t0 e guarda no $t1

.data
a: .word 1
b: .word 2
c: .word 3

