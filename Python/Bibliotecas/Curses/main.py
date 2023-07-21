import curses


##########################################################################
## Este código 'movimenta' o X no terminal ao pressionar as teclas W,S,A,D
##########################################################################

def main(stdscr):
    # Configurações iniciais do terminal
    stdscr.clear()
    curses.curs_set(0)  # Desativa o cursor

    # Tamanho da tela
    height, width = stdscr.getmaxyx()

    # Posição inicial do jogador
    player_y, player_x = height // 2, width // 2

    # Loop principal do jogo
    while True:
        stdscr.nodelay(True) 

        # Obtém o input do usuário (não bloqueante)
        key = stdscr.getch()

        stdscr.addch(player_y, player_x, ' ')

        # Atualiza a posição do jogador com base na tecla pressionada
        if key == ord('w'):
            player_y -= 1
        elif key == ord('s'):
            player_y += 1
        elif key == ord('a'):
            player_x -= 1
        elif key == ord('d'):
            player_x += 1

        # Limita a posição do jogador dentro dos limites da tela
        player_y = max(0, min(player_y, height - 1))
        player_x = max(0, min(player_x, width - 1))

        # Desenha o jogador na tela
        stdscr.addch(player_y, player_x, 'X')

        # Atualiza a tela
        stdscr.refresh()


if __name__ == "__main__":
    curses.wrapper(main)
