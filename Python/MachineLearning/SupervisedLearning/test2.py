import curses

def main(stdscr):
    # Configurar o terminal
    curses.curs_set(0)  # Esconder o cursor
    stdscr.nodelay(True)  # Tornar a leitura de entrada não bloqueante

    # Definir a matriz
    matrix = [
        ['X', 'O', 'X'],
        ['O', 'X', 'O'],
        ['X', 'O', 'X']
    ]

    # Obter o tamanho do terminal
    height, width = stdscr.getmaxyx()

    while True:
        # Limpar o terminal
        stdscr.erase()

        # Imprimir a matriz no centro do terminal
        for i, row in enumerate(matrix):
            y = (height // 2) - (len(matrix) // 2) + i
            x = (width // 2) - (len(row) // 2)
            stdscr.addstr(y, x, ' '.join(row))

        # Atualizar a tela
        stdscr.refresh()

        # Ler a entrada do teclado
        key = stdscr.getch()

        # Mover a matriz para a esquerda se a tecla de seta esquerda for pressionada
        if key == curses.KEY_LEFT:
            for row in matrix:
                row.insert(0, ' ')
                row.pop()

        # Parar o loop se a tecla 'q' for pressionada
        if key == ord('q'):
            break

curses.wrapper(main)
