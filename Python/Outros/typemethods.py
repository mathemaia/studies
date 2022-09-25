import time

# Classe de teste de implementação de metodos de classe e estaticos.
# A saída do programa mostra que o contador da classe continua sempre incrementando mesmo que seu último objeto
# instânciado tenha sido deletado

class Pessoa:
    _contador = 0

    def __init__(self):
        self.inc()

    def __str__(self):
        return f'{self._contador}'

    @classmethod
    def inc(cls):
        cls._contador += 1


if __name__ == '__main__':
    while True:
        obj = Pessoa()
        print(obj)
        print('memory_id: ', id(obj))
        print()
        del obj
        time.sleep(1)
