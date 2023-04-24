import pygame
import sys
import random


def ball_restart():
    global ball_speed_x, ball_speed_y

    ball.center = (WIDTH/2, HEIGHT/2)
    ball_speed_y *= 1.05
    ball_speed_x *= 1.05


def ball_animation():
    '''Método que atualiza a direção da bola'''
    global ball_speed_x, ball_speed_y, player_score, opponent_score

    # define a direção inicial da bola
    ball.x += ball_speed_x
    ball.y += ball_speed_y

    # colisão no sentido vertical / y
    if ball.top <= 0 or ball.bottom >= HEIGHT:
        ball_speed_y *= -1
    # colisão no sentido horizontal / x
    if ball.left <= 0 or ball.right >= WIDTH:
        lost.play()
        ball_restart()
    # colisão com os jogadore
    if ball.colliderect(player) or ball.colliderect(opponent):
        collision.play()
        ball_speed_x *= -1


def player_animation():
    '''Método que define o movimento do player'''
    player.y += player_speed
    if player.top <= 0:
        player.top = 0
    if player.bottom >= HEIGHT:
        player.bottom = HEIGHT


def opponent_ai():
    '''Método que define o movimento do oponente'''
    if opponent.top < ball.y:
        opponent.top += opponent_speed
    if opponent.bottom > ball.y:
        opponent.bottom -= opponent_speed
    if opponent.top <= 0:
        opponent.top = 0
    if opponent.bottom >= HEIGHT:
        opponent.bottom = HEIGHT 


# inicialização do pygame
pygame.init()
clock = pygame.time.Clock()


# configurações sonoras
pygame.mixer.init()
collision = pygame.mixer.Sound('PingPong/collision.wav')
collision.set_volume(0.1)
lost = pygame.mixer.Sound('PingPong/lost.wav')
lost.set_volume(0.2)


# configurações da janela
WIDTH = 1680
HEIGHT = 980
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption('Pong')


# desenho dos objetos
ball = pygame.Rect(WIDTH/2 - 15, HEIGHT/2 - 15, 25, 25)
player = pygame.Rect(WIDTH - 20, HEIGHT/2 - 70, 10, 140)
opponent = pygame.Rect(10, HEIGHT/2 - 70, 10, 140)


# configurações de cores
bg_color = pygame.Color('grey12')
color = (200, 200, 200)


# configurações do comportamento dos objetos
ball_speed_x = 7 * random.choice((1, -1))
ball_speed_y = 7 * random.choice((1, -1))
player_speed = 0
opponent_speed = 7


# iteração de execução do jogo
while True:
    for event in pygame.event.get():
        # checa se o usuário fechou a janela
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_DOWN:
                player_speed += 15
            if event.key == pygame.K_UP:
                player_speed -= 15
        if event.type == pygame.KEYUP:
            if event.key == pygame.K_DOWN:
                player_speed -= 15
            if event.key == pygame.K_UP:
                player_speed += 15

    # atualiza o comportamento dos objetos
    ball_animation()
    player_animation()
    opponent_ai()

    # atualiza os objetos do jogo
    screen.fill(bg_color)
    pygame.draw.rect(screen, color, player)
    pygame.draw.rect(screen, color, opponent)
    pygame.draw.ellipse(screen, color, ball)
    pygame.draw.aaline(screen, color, (WIDTH/2, 0), (WIDTH/2, HEIGHT))

    # atualiza a janela
    pygame.display.flip()
    clock.tick(75)