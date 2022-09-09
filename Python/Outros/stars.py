import random as rand
import time


def qtd_estrelas(lista_simbolos):
    quantidade = rand.randint(0, 1)
    for j in range(int(quantidade)):
        x = rand.randint(1, 45)
        y = rand.randint(1, 200)
        cor = rand.randint(1, 255)
        s = rand.choice(lista_simbolos)

        # Define a cor
        print(f'\u001b[38;5;{cor}m', end='')
        print(f'\u001b[{x};{y}H', end='')
        print(f'{s}', end='')


if __name__ == '__main__':
    simbolos = open('/home/matheus/PycharmProjects/pythonProject/lib/simbolos.txt', 'r').read()
    simbolos = simbolos.split()
    while True:
        # Esconde o cursor
        print('\u001b[?25l')
        # Apaga a tela
        print('\u001b[2J', end='')
        for i in range(100):
            qtd_estrelas(simbolos)
        time.sleep(1)
