import json
import pandas as pd

# Foi necessário ajustar o arquivo, pois a indexação estava sendo um problema. 

df = pd.read_json('../data/DadosIES_Sul.json')

dicionario = {}
for i in range(391):
    linha = df.iloc[i].to_dict()
    dicionario.update({i: linha})

with open("../data/Dados_IES_Sul_indexado.json", "w") as f:
    json.dump(dicionario, f)
    