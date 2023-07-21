import curses
import time
import numpy as np
from image_conversor import convert_image
import cv2
import os
import sys


def print_frame(frame):
    # Sequência de escape ANSI para limpar a tela
    print("\033[2J", end='')

    np.savetxt(sys.stdout, frame, delimiter='', fmt='%2s')

    # Sequência de escape ANSI para posicionar o cursor no início da tela
    print("\033[H", end='')



# Tamanho da tela
rows, columns = os.popen('stty size', 'r').read().split()
rows, columns = int(rows), int(columns)

# Posição inicial do frame (no centro da tela)
frame_y = rows // 2 - 480 // 2
frame_x = columns // 2 - 640 * (1 + 2) // 2  # Contabiliza o espaço entre os caracteres



cap = cv2.VideoCapture(0)
while True:
	ret, frame = cap.read()

	print_frame(convert_image(frame))