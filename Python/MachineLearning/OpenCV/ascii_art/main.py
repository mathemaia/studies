import curses
import time
import numpy as np
from image_conversor import convert_image
import cv2
import os
import sys

# Exemplo de array NumPy representando um frame de vídeo
video_frame1 = convert_image(cv2.imread('./frames/frame55.jpg'))
video_frame2 = convert_image(cv2.imread('./frames/frame56.jpg'))
video_frame3 = convert_image(cv2.imread('./frames/frame57.jpg'))
video_frame4 = convert_image(cv2.imread('./frames/frame58.jpg'))
video_frame5 = convert_image(cv2.imread('./frames/frame59.jpg'))
video_frame6 = convert_image(cv2.imread('./frames/frame60.jpg'))

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
frame_y = rows // 2 - video_frame1.shape[0] // 2
frame_x = columns // 2 - video_frame1.shape[1] * (1 + 2) // 2  # Contabiliza o espaço entre os caracteres



cap = cv2.VideoCapture(0)
while True:
	ret, frame = cap.read()

	print_frame(convert_image(frame))
	
	if cv2.waitKey(1) & 0xFF == ord('q'):
		break


cap.release()
cv2.destroyAllWindows()

'''# Loop principal do vídeo
while True:
    # Imprime o frame 1 na posição atual
    print_frame(video_frame1)

    # Aguarda um curto período de tempo antes de atualizar o próximo frame
    time.sleep(0.1)

    # Imprime o frame 2 na posição atual
    print_frame(video_frame2)

    # Aguarda um curto período de tempo antes de atualizar o próximo frame
    time.sleep(0.1)

    # Imprime o frame 1 na posição atual
    print_frame(video_frame3)

    # Aguarda um curto período de tempo antes de atualizar o próximo frame
    time.sleep(0.1)

    # Imprime o frame 2 na posição atual
    print_frame(video_frame4)

    # Aguarda um curto período de tempo antes de atualizar o próximo frame
    time.sleep(0.1)

    # Imprime o frame 1 na posição atual
    print_frame(video_frame5)

    # Aguarda um curto período de tempo antes de atualizar o próximo frame
    time.sleep(0.1)

    # Imprime o frame 2 na posição atual
    print_frame(video_frame6)

    # Aguarda um curto período de tempo antes de atualizar o próximo frame
    time.sleep(1)'''