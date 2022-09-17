class Produto:
    def __init__(self, nome, preco):
        self.nome = nome
        self.preco = preco
    
    def desconto(self, percentual):
        self.preco = self.preco - (self.preco (percentual / 100))

    # Getters.
    @property
    def preco(self):
        return self.preco
    
    @property
    def nome(self):
        return self.nome

    # Setters.
    @preco.setter
    def set_preco(self, valor):
        if isinstance(valor, str):
            valor = float(valor.replace('R$', ''))

    @nome.setter
    def set_preco(self, nome):
        self.nome = nome
        

if __name__ == '__main__':
    pass    