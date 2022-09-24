import random
import math

# This code produces this output on terminal:
# ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ 
# ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯
# ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤ ◯ ◯ ⬤
# ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯ ⬤ ⬤ ◯ ◯ ◯ ◯
# ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ ◯ 

fx = 0

for i in range(-3, 5):
    for j in range(-15, 50):
        fx = round(math.sin(j))
        if fx == i:
            print('⬤ ', end='')
        else:
            print('◯ ', end='')
    print()
