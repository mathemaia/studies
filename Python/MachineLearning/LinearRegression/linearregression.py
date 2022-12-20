import pandas as pd
import numpy as np
from matplotlib import pyplot as plt

df = pd.read_csv('dados/house-price.csv')

X_train = df['Area'][:900]
for i in X_train:
    if i != int(i):
        print(i)