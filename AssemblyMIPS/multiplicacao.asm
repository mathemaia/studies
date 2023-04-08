.data
A: .word 12
B: .word 7
C: .word 0

.text
.globl main
main:	la $t0, a	# Carrega o endereço de A para $t0 
	lw $t1, 0($t0)	# Carrega o conteúdo de A para $t1
	la $t2, b	
	lw $t3, 4($t0)
	