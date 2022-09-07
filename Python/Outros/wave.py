import random
import math

fx = 0
cor = random.randint(0, 255)

print(f'\u001b[38;5;{cor}', end='')

for i in range(-3, 5):
    for j in range(-15, 50):
        fx = round(math.sin(j))
        if fx == i:
            print('⬤ ', end='')
        else:
            print('◯ ', end='')
    print()
