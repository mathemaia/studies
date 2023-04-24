import pygame
import sys
import random
import time

# classe dos simbolos
class Symbol:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.speed = 40
        self.value = random.choice(green_chars)
    
    def draw(self):
        self.value = random.choice(green_chars)
        self.y = self.y + self.speed if self.y < HEIGHT else -FONT_SIZE * random.randrange(1, 10)
        screen.blit(self.value, (self.x, self.y))


# inicialização do pygame
pygame.init()
clock = pygame.time.Clock()


# configurações de tela
WIDTH = 1280
HEIGHT = 720
screen = pygame.display.set_mode((WIDTH, HEIGHT))
display_surface = pygame.Surface((WIDTH, HEIGHT))


# configurações da letras
katakana = 'アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロワヲン'
hiragana = 'あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをん'
alfabeto = 'ABCDEFGHIJKLMNOPQRSTUVXWYZ'
russo = 'АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ'
grego = 'ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩ'
numeros = '0123456789'
FONT_SIZE = 35
chars = list(katakana + hiragana + alfabeto + russo + grego + numeros)
font = pygame.font.Font('MSMINCHO.ttf', FONT_SIZE)
green_chars = [font.render(char, True, (0, 255, 0)) for char in chars]


# cria uma lista de simbolos
symbols = [Symbol(x, random.randrange(-HEIGHT, 0)) for x in range(0, WIDTH, FONT_SIZE)]


# execução do pygame
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

    # preenche a tela com a cor preta
    screen.blit(display_surface, (0, 0))
    display_surface.fill(pygame.Color('black'))

    # coloca os simbolos na tela
    [symbol.draw() for symbol in symbols]

    # Atualiza a tela
    pygame.display.flip()
    clock.tick(75)

    time.sleep(1)