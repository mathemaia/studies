import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
from sklearn.cluster import KMeans
from sklearn.datasets import make_blobs

# Gerar dados aleatórios com 4 clusters em 3 dimensões
X, y = make_blobs(n_samples=500, centers=4, random_state=42, n_features=3)

# Treinar o modelo K-Means com 4 clusters
kmeans = KMeans(n_clusters=4, random_state=42)
kmeans.fit(X)

# Obter os rótulos de cluster para cada ponto
labels = kmeans.labels_

# Plotar o gráfico de dispersão dos dados em 3D, com pontos coloridos por cluster
fig = plt.figure()
ax = fig.add_subplot(111, projection='3d')
ax.scatter(X[:, 0], X[:, 1], X[:, 2], c=labels, cmap='viridis')

# Plotar os centróides dos clusters como esferas brancas
centers = kmeans.cluster_centers_
ax.scatter(centers[:, 0], centers[:, 1], centers[:, 2], marker='o', s=200, color='white')

# Definir os rótulos dos eixos e mostrar o gráfico
ax.set_xlabel("Feature 1")
ax.set_ylabel("Feature 2")
ax.set_zlabel("Feature 3")
plt.show()