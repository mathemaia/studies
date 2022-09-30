while True:
    # Pede uma entrada e só continua se for inserido um número
    try:
        escolha = int(input('\nInserir[1] / Ler[2] / Sair[3]: '))
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
    elif escolha == 2:
        # Lê e imprime todas as linhas do arquivo
        with open('/home/matheus/PythonProjects/testes/dados/dados.dat', 'r') as arquivo:
            for idx, linha in enumerate(arquivo):
                print(f'{idx}   {linha}', end='')
    else:
        # Termina o loop
        break
