while True:
    # Pede uma entrada e só continua se for inserido um número
    try:
        escolha = int(input('\nInserir[1] / Ler[2] / Remover[3] / Sair[4]: '))
        print()
    except:
        print('\nEscolha uma opção válida.\n')
    
    if escolha == 1:
        # Insere uma nova linha
        with open('/home/matheus/PythonProjects/testes/dados/dados.dat', 'a+') as arquivo:
            print('\n*****Inserir*****')
            nome = str(input('Nome: '))
            idade = int(input('Idade: '))
            cidade = str(input('Cidade: '))
            estado = str(input('Estado_Cívil: '))
            arquivo.write(f'\n{nome}||{idade}||{cidade}||{estado}')
            print()
    elif escolha == 2:
        # Lê e imprime todas as linhas do arquivo
        with open('/home/matheus/PythonProjects/testes/dados/dados.dat', 'r') as arquivo:
            for idx, linha in enumerate(arquivo):
                print(f'{idx}   {linha}', end='')
        print()
    elif escolha == 3:
        # Remove a linha escolhida
        #indice = int(input('Indice da linha : '))
        matriz = []
        f = open('/home/matheus/PythonProjects/testes/dados/dados.dat', 'r')
        for idx, linha in enumerate(f):
                print(f'{idx}   {linha}', end='')
                matriz.append(linha.strip().split('||'))
        print()
        remocao = int(input('Linha a ser removida: '))
        print(matriz[remocao])
        matriz.pop(remocao)
        f.close()
        with open('/home/matheus/PythonProjects/testes/dados/dados.dat', 'w') as arquivo:
            for i in range(len(matriz) - 1):
                arquivo.writelines(f'{matriz[i]}||{matriz[i]}||{matriz[i]}||{matriz[i]}\n')

            print('A linha', remocao, 'foir removida.')
        f = open('/home/matheus/PythonProjects/testes/dados/dados.dat', 'r')
        print(f.read())
        print()
            
    else:
        # Termina o loop
        break
