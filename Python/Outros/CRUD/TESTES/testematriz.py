import random

#
# Script para testar a remoção de elementos da matriz
#

def inc(x: int) -> int:
    x += 1
    return x

# Cria a matriz
letras = ['a', 'b', 'c', 'd', 'e', 'f', 'g']
matriz = [[0 for x in range(4)] for y in range(10)]
for idx, i in enumerate(matriz):
    print(f'{idx}   {i}')

# Remove a linha inserida
linha = int(input('n da linha a ser removida: '))
matriz.pop(linha)

for idx, i in enumerate(matriz):
    print(f'{idx}   {i}')
