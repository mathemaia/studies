from matplotlib.image import imread
import matplotlib.pyplot as plt
import os
from sklearn.cluster import KMeans
import cv2
import numpy as np
import sys

image = cv2.imread('data/eu.jpg')
image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
image = cv2.resize(image, (round(image.shape[1] * (1/5)), round(image.shape[0] * (1/5))))


new_image = np.zeros((image.shape[0], image.shape[1])).astype(int).astype(str)


# .
min = 0
max = 25
mask = (image >= min) & (image <= max)
new_image[mask] = '.'

# -
min = 25
max = 50
mask = (image > min) & (image <= max)
new_image[mask] = '-'

# "
min = 50
max = 75
mask = (image > min) & (image <= max)
new_image[mask] = '"'

# *
min = 75
max = 100
mask = (image > min) & (image <= max)
new_image[mask] = '*'

# !
min = 100
max = 125
mask = (image > min) & (image <= max)
new_image[mask] = ':'

# ?
min = 125
max = 150
mask = (image > min) & (image <= max)
new_image[mask] = ';'

# 1
min = 150
max = 175
mask = (image > min) & (image <= max)
new_image[mask] = '1'

# &
min = 175
max = 200
mask = (image > min) & (image <= max)
new_image[mask] = '&'

# 0
min = 200
max = 225
mask = (image > min) & (image <= max)
new_image[mask] = '0'

# @
min = 225
max = 250
mask = (image > min) & (image <= max)
new_image[mask] = '@'

# Imprimir a matriz formatada com colunas alinhadas
test = np.savetxt(sys.stdout, new_image, delimiter='', fmt='%2s')

