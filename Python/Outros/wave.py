import random
import math

#◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ 
#◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ 
#⬤ ◯ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ 
#◯ ⬤ ◯ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯
#◯ ◯ ⬤ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ 
#◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ 

fx = 0
cor = random.randint(0, 255)

for i in range(-3, 5):
    for j in range(-15, 50):
        fx = round(math.sin(j))
        if fx == i:
            print('⬤ ', end='')
        else:
            print('◯ ', end='')
    print()
