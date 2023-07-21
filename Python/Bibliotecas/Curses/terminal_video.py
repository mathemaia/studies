import curses
import time

# Exemplo de matriz representando um frame de vídeo (substitua com seus frames reais)
video_frame1 = [
    "XXXXXXXXXXXXX",
    "X     O     X",
    "X           X",
    "X           X",
    "X           X",
    "X           X",
    "XXXXXXXXXXXXX",
]

video_frame2 = [
    "XXXXXXXXXXXXX",
    "X           X",
    "X     O     X",
    "X           X",
    "X           X",
    "X           X",
    "XXXXXXXXXXXXX",
]

video_frame3 = [
    "XXXXXXXXXXXXX",
    "X           X",
    "X           X",
    "X     O     X",
    "X           X",
    "X           X",
    "XXXXXXXXXXXXX",
]

video_frame4 = [
    "XXXXXXXXXXXXX",
    "X           X",
    "X           X",
    "X           X",
    "X     O     X",
    "X           X",
    "XXXXXXXXXXXXX",
]

video_frame5 = [
    "XXXXXXXXXXXXX",
    "X           X",
    "X           X",
    "X           X",
    "X           X",
    "X     O     X",
    "XXXXXXXXXXXXX",
]

video_frame6 = [
    "XXXXXXXXXXXXX",
    "X           X",
    "X           X",
    "X           X",
    "X           X",
    "X           X",
    "XXXXXXXXXXXXX",
]

# Função para imprimir o frame na posição especificada
def print_frame(stdscr, frame, y, x):
    for i, row in enumerate(frame):
        stdscr.addstr(y + i, x, row)

def main(stdscr):
    # Configurações iniciais do terminal
    curses.curs_set(0)  # Desativa o cursor
    stdscr.nodelay(True) 
    stdscr.timeout(100)  # Define o tempo de espera por frame (100 ms)

    # Tamanho da tela
    height, width = stdscr.getmaxyx()

    # Posição inicial do frame
    frame_y, frame_x = height // 2 - len(video_frame1) // 2, width // 2 - len(video_frame1[0]) // 2

    # Loop principal do vídeo
    while True:
        # Limpa a tela
        stdscr.clear()
        # Imprime o frame na posição atual
        print_frame(stdscr, video_frame1, frame_y, frame_x)
        # Atualiza a tela
        stdscr.refresh()


        # Aguarda um curto período de tempo antes de atualizar o próximo frame
        time.sleep(1)


        # Limpa a tela
        stdscr.clear()
        # Imprime o próximo frame na mesma posição
        print_frame(stdscr, video_frame2, frame_y, frame_x)
        # Atualiza a tela
        stdscr.refresh()


        # Aguarda um curto período de tempo antes de atualizar o próximo frame
        time.sleep(1)


        # Limpa a tela
        stdscr.clear()
        # Imprime o próximo frame na mesma posição
        print_frame(stdscr, video_frame3, frame_y, frame_x)
        # Atualiza a tela
        stdscr.refresh()


        # Aguarda um curto período de tempo antes de atualizar o próximo frame
        time.sleep(1)


        # Limpa a tela
        stdscr.clear()
        # Imprime o próximo frame na mesma posição
        print_frame(stdscr, video_frame4, frame_y, frame_x)
        # Atualiza a tela
        stdscr.refresh()


        # Aguarda um curto período de tempo antes de atualizar o próximo frame
        time.sleep(1)


        # Limpa a tela
        stdscr.clear()
        # Imprime o próximo frame na mesma posição
        print_frame(stdscr, video_frame5, frame_y, frame_x)
        # Atualiza a tela
        stdscr.refresh()


        # Aguarda um curto período de tempo antes de atualizar o próximo frame
        time.sleep(1)


        # Limpa a tela
        stdscr.clear()
        # Imprime o próximo frame na mesma posição
        print_frame(stdscr, video_frame6, frame_y, frame_x)
        # Atualiza a tela
        stdscr.refresh()

        # Aguarda um curto período de tempo antes de atualizar o próximo frame
        time.sleep(1)

if __name__ == "__main__":
    curses.wrapper(main)

