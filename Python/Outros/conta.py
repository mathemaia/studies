class Conta:
    # Construtor.
    def __init__(self, numero=None, nome=None, binicial=None, tipo=None):
        self._numero = numero
        self._nome = nome
        self._binicial = binicial
        self._tipo = tipo

    # Getters.
    @property
    def numero(self):
        return self._numero

    @property
    def nome(self):
        return self._nome

    @property
    def binicial(self):
        return self._binicial

    @property
    def tipo(self):
        return self._tipo

    # Setters.
    @numero.setter
    def numero(self, numero):
        self._numero = numero

    @nome.setter
    def nome(self, nome):
        self._nome = nome

    @binicial.setter
    def binicial(self, binicial):
        self._binicial = binicial

    @tipo.setter
    def tipo(self, tipo):
        self._tipo = tipo

    # Outros
    def __str__(self):
        return f'numero: {self.numero}\nnome: {self.nome}\nb_inicial: {self.binicial}\ntipo: {self.tipo}'

    def deposito(self, quantidade):
        self._binicial += quantidade

    def saque(self, quantidade):
        self._binicial = self._binicial - quantidade
        return quantidade

    def saldo(self):
        return self.binicial


if __name__ == '__main__':
    conta1 = Conta('001', 'Caetano', 10.05, 'corrente')
    conta2 = Conta('002', 'Guilherme', 23.55, 'poupanca')
    conta3 = Conta('003', 'Dalvan', 12.45, 'investimento')

    print(conta1)
    print()
    print(conta2)
    print()
    print(conta3)
    print()

    conta1.deposito(44.45)
    conta1.saque(33.33)
    print('Saldo: ', conta1.saldo())
