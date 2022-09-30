import random as rand

# Colunas
nome_completo = []
idade = []
cidade = []
estado_civil = []

# Listas auxiliares
nomes = ['Matheus ', 'Rafaela ', 'João ', 'Vitória ', 'Fernando ', 'Nicoly ', 'Gabriel ', 'Luiza ', 'Gean ', 'Lucia ', 'Lucas ', 'Virgínia ']
sobrenomes = ['Silva', 'Rosa', 'Fernandes', 'Mayer', 'Fagundes', 'Cardoso', 'Correia', 'Borges', 'Medeiros', 'Dias', 'Duarte', 'Lima']
estados = ['Solteiro(a)', 'Casado(a)']
cidades = ['Porto Alegre', 'Alvorada', 'Canoas', 'Cachoeirinha', 'Gravataí', 'Viamão', 'Guaíba', 'Eldorado do Sul', 'Esteio', 'Sapucaia do Sul', 'São Leopoldo', 'Novo Hamburgo']

# Loop que constrói as colunas
for i in range(len(nomes)):
    nome_completo.append(nomes[rand.randint(0, 11)] + sobrenomes[rand.randint(0, 11)])
    idade.append(rand.randint(20, 30))
    cidade.append(cidades[rand.randint(0, len(cidades) - 1)])
    estado_civil.append(estados[rand.randint(0, 1)])

# Imprime as listas das colunas
print(nome_completo)
print(idade)
print(cidade)
print(estado_civil)
print()

# Formata a saída das linhas
for i in range(len(nomes)):
    print(f'NOME: {nome_completo[i]}\nIDADE: {idade[i]}\nCIDADE: {cidade[i]}\nESTADO_CIVIL: {estado_civil[i]}')
    print()

#with open('/home/matheus/PythonProjects/testes/dados/dados.csv', 'w',  newline='\n') as dados:
#    for i in range(20):
#        dados.writelines(f'{i}\n')
#    print(dados.fileno())
 