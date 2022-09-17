import random as rand

arquivo = open('/home/matheus/Python-projects/sales/df.csv', 'r')

lista = []
linha = []
soma = 0

for i, frase in enumerate(arquivo):
    if i != 0:
        linha = frase.split(',')
        linha[len(linha) - 1].replace('\n', '')

        for j in range(len(linha)):
            if j != 0 and j != len(linha) - 1:
                linha[j] = rand.randint(0, 80000)
                soma = soma + linha[j]

        linha[len(linha) - 1] = soma
    lista.append(linha)

print(lista)
    

        
            
