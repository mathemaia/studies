# leitura do arquivo e instância de variaveis
entradas = open('teste.txt').read().splitlines()
inter = [0] * len(entradas)
comeco_intervalo = [0] * len(entradas)
fim_intervalo = [0] * len(entradas)
fora_dos_intervalos = []

# separação dos começos e fins dos intervalos em diferentes vetores
for linhas, intervalos in enumerate(entradas):
    inter[linhas] = intervalos

for i, elementos in enumerate(inter):
    comeco_intervalo[i] = int(elementos.split('-')[0])
    fim_intervalo[i] = int(elementos.split('-')[1])

# identifica o intervalo cujo primeiro número é o menor
menor = comeco_intervalo[0]
indice = 0
for i in range(1, len(comeco_intervalo)):
    if menor > comeco_intervalo[i]:
        menor = comeco_intervalo[i]
        indice = i + 1

# checa se o útimo número e o posterior pertencem a um intervalo
count = 0
numero = menor
while True:
    if (indice != count) and (comeco_intervalo[count] <= numero <= fim_intervalo[count]):
        numero = fim_intervalo[count]
        indice = count
    else:
        for idx, i in enumerate(fim_intervalo):
            if comeco_intervalo[idx] <= (numero + 1) <= fim_intervalo[idx]:
                break
            else:
                fora_dos_intervalos.append(numero + 1)
    count += 1
        


