import time

denominador = int(input('denominador: '))
soma = 0

for i in range(0, denominador):
    soma = soma + (1 / ((2 * i) + 1))
    print(f'[{i}] ', soma)
    time.sleep(1)