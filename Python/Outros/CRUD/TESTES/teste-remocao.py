# Cria e imprime a matriz
matriz = []
for i in range(10):
    matriz.append([i for x in range(5)])
for idx, i in enumerate(matriz):
    print(f'{idx}  {i}')
print()

# Remoção da linha e impressão da nova matriz
linha = int(input('Linha a ser removida: '))
matriz.pop(linha)
for idx, i in enumerate(matriz):
    print(f'{idx}  {i}')