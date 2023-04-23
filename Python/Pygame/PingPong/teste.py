import pygame

pygame.init()

# Configurações da janela
screen_width = 640
screen_height = 480
screen = pygame.display.set_mode((screen_width, screen_height))

# Configurações da fonte
font = pygame.font.Font(None, 36)  # Escolhe a fonte e o tamanho do texto

# Define a pontuação inicial
pontuacao = 0

# Loop principal do jogo
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()

        # Verifica se o jogador ganhou um ponto
        if event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
            pontuacao += 1  # Adiciona um ponto à pontuação

    # Cria uma imagem do texto da pontuação atual
    texto_pontuacao = font.render('Pontuação: {}'.format(pontuacao), True, (255, 255, 255))

    # Define a posição na tela onde o texto será exibido
    posicao_pontuacao = texto_pontuacao.get_rect()
    posicao_pontuacao.centerx = screen.get_rect().centerx
    posicao_pontuacao.centery = screen.get_rect().centery

    # Preenche a tela com uma cor de fundo
    screen.fill((0, 0, 0))

    # Desenha a imagem do texto da pontuação na tela
    screen.blit(texto_pontuacao, posicao_pontuacao)

    # Atualiza a tela
    pygame.display.update()
