while True:
    # Pede uma entrada e só continua se for inserido um número
    try:
        escolha = int(input('\nInserir[1] / Ler[2] / Remover[3] / Sair[4]: '))
        print()
    except:
        print('Escolha uma opção válida.\n')
    
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
    elif escolha == 3:
        # Remove a linha escolhida
        indice = int(input('Indice da linha : '))
        with open('/home/matheus/PythonProjects/testes/dados/dados.dat', 'w') as arquivo:
            for idx, linha in enumerate(arquivo):
                pass
    else:
        # Termina o loop
        break
