* **la** - *load addres*: carrega o endereço para o registrador.
* **lw** - *load word*: carrega a palavra (dado) para o endereço que está contido no registrador.
* **li** - *load imediatly*: carrega imediatamente.

# li $v0
Registradores $v0 e $v1 são usados para retorno de funções. Carregar um valor com a instrução *li* a um registrador $v0/$v1 indica que se quer realizar uma função.
* **li $v0, 1**: imprimir inteiro.
* **li $v0, 2**: imprimir float.
* **li $v0, 3**: imprimir double.
* **li $v0, 4**: imprimir String ou char.
* **li $v0, 5**: ler inteiro.
* **li $v0, 6**: ler float.
* **li $v0, 7**: ler double.
* **li $v0, 8**: ler String ou char.
* **li $v0, 10**: encerrar o programa principal.

# Adição
* **add** - *addition*: adiciona o valor de um reg. a outro (usa três reg.).
ex.: add $s0, $t1, $t2 // s0 = t1 + t2
* **addi** - *addition imediate*: adiciona um valor a um reg (usa dois reg.).
ex.: add $s0, $zero, $t1 // s0 = 0 + t1 

# Subtração
* **sub** - *subtraction*: subtrai o valor de um reg. a outro (usa três reg.).


	
