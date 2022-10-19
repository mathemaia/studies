escolha = 0

while escolha != 4:
    # Pede uma entrada e só continua se for inserido um número
    while True:
        escolha = input('Inserir[1] / Ler[2] / Remover[3] / Sair[4]: ')
        try:
            escolha = int(escolha)
        except:
            print('Por favor, escolha uma opção valida.\n')

        if escolha > 4:
            print('Por favor, escolha uma opção valida.\n')
            continue
        else:
            break

    # Insere uma nova linha
    if escolha == 1:
        with open('/home/matheus/PycharmProjects/pythonProject/POD/CRUD/.testes/dados.dat', 'a+') as arquivo:
            print('\nINSERIR:\n')
            nome = str(input('NOME: '))
            idade = int(input('IDADE: '))
            cidade = str(input('CIDADE: '))
            estado = str(input('ESTADO_CIVIL: '))
            arquivo.write(f'\n{nome}||{idade}||{cidade}||{estado}')
            print()
    # Lê e imprime todas as linhas do arquivo
    elif escolha == 2:
        with open('/home/matheus/PycharmProjects/pythonProject/POD/CRUD/.testes/dados.dat', 'r') as arquivo:
            for idx, linha in enumerate(arquivo):
                print(f'{idx}       {linha}', end='')
        print('\n\n')
    # Remove a linha escolhida pela coluna NOME
    elif escolha == 3:
        matriz = []
        f = open('/home/matheus/PycharmProjects/pythonProject/POD/CRUD/.testes/dados.dat', 'r')
        for linha in f:
                matriz.append(linha.strip().split('||'))
        print()
        while True:
            remocao = int(input('Linha a ser removida: '))
            if remocao > len(matriz) + 1:
                print('Por favor, escolha uma opção valida.')
            else:
                break
        matriz.pop(remocao)
        f.close()
        print('A linha', remocao, 'foir removida.')
