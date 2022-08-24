# leitura do arquivo e instância de variaveis
entradas = open('intervalos.txt').read().splitlines()
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

# conferindo se o numero posterior ao intervalo atual está no seguinte
for i in range(len(entradas)):
    if i + 1 < len(entradas):
        if (comeco_intervalo[i + 1]) <= (fim_intervalo[i] + 1) <= (fim_intervalo[i + 1]):
            continue
        else: 
            fora_dos_intervalos.append(fim_intervalo[i] + 1)

# encontrando o menor
menor = fora_dos_intervalos[0]
for i in range(1, len(fora_dos_intervalos)):
    pass

print(len(fora_dos_intervalos))