# Código da aula da cadeira de Programação Orientada a Dados para estudo de @classmethod, @staticmethod e herança.

class Pessoa:
    # Exemplo de classe que armazena nome e idade de pessoas.
    contar = 0

    @classmethod
    def inc_inst(cls):
        """Método de classe que incrementa contar em +1"""
        cls.contar += 1

    def __init__(self, nome, idade):
        """Construtor"""
        Pessoa.inc_inst()
        self._nome = nome
        self._idade = idade

    def __str__(self):
        """Método para visualizar uma representação em string objeto"""
        return f'\n#count: {self.contar}\n{self._nome} possui {str(self._idade)} anos'

    def aniversario(self):
        """Incrementa idade em +1"""
        self._idade += 1

    def testa_adolescente(self):
        """Testa se idade esta entre 11 e 20"""
        return 11 < self._idade < 20


class Estudante(Pessoa):
    def __init__(self, nome, idade, ano):
        super().__init__(nome, idade)
        self._ano = ano

    # Extensão
    def __str__(self):
        return super(Estudante, self).__str__() + f' e ingressou em {self._ano}.'

    # Override
    def aniversario(self):
        """Sobreescreve a variavel _idade para +2"""
        self._idade += 2


if __name__ == '__main__':
    p1 = Pessoa('Matheus', 25)
    print(p1)

    p2 = Pessoa('Vitor', 19)
    print(p2)

    e1 = Estudante('João', 22, 2021)
    e1.aniversario()
    print(e1)
