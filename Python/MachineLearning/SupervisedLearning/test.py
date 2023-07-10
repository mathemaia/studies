from matplotlib.image import imread
import matplotlib.pyplot as plt
import os
from sklearn.cluster import KMeans
import cv2
import numpy as np
import sys

image = cv2.imread('data/girassol.jpg')
image = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
image = cv2.resize(image, (round(image.shape[1] * (1/20)), round(image.shape[0] * (1/20))))
X = image.reshape(-1, 1)
kmeans = KMeans(n_clusters=4).fit(X)

segmented_img = kmeans.cluster_centers_[kmeans.labels_]
segmented_img = segmented_img.reshape(image.shape)

segmented_img = segmented_img.astype(int)

# Configurar opções de impressão
np.set_printoptions(linewidth=100)

# Imprimir a matriz formatada com colunas alinhadas
test = np.savetxt(sys.stdout, segmented_img, delimiter='', fmt='%4d')

print(test)
