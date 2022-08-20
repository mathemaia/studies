# Beecrowd1052:
#
# Leia um valor inteiro entre 1 e 12, inclusive. Correspondente a este valor, deve ser 
# apresentado como resposta o mês do ano por extenso, em inglês, com a primeira letra maiúscula.
#
# Ex: 4 -> April


meses = ['January', 'February', 'March', 'April', 'May', 'June',
'July', 'August', 'September', 'October', 'November', 'December']

entrada = int(input())

print(f'{meses[entrada - 1]}\n')
