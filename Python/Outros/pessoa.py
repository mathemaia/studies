from datetime import datetime

class Pessoa:
    ano_atual = int(datetime.strftime(datetime.now(), '%Y'))


    # Construtor
    def __init__(self, nome, idade, comendo = False, falando = False):
        self.nome = nome
        self.idade = idade
        self.comendo = comendo
        self.falando = falando


    # Método para começar a falar
    def falar(self, assunto):
        if self.comendo:
            print(f'{self.nome} não é mal educado e não vai falar comendo.')
            return
        
        if self.falando:
            print(f'{self.nome} já está falando.')
            return
        
        print(f'{self.nome} está falando sobre {assunto}!')
        self.falando = True


    # Método para parar de falar
    def parar_de_falar(self):
        if not self.falando:
            print(f'{self.nome} não pode parar de falar pois nem começou!')
            return
        
        print(f'{self.nome} parou de falar.')
        self.falando = False


    # Método para começar a comer
    def comer(self, comida):
        if self.comendo:
            print(f'{self.nome} já está comendo...')
            return

        if self.falando:
            print(f'{self.nome} não pode comer porque está falando!')
            return

        print(f'{self.nome} está comendo {comida}!')
        self.comendo = True


    # Método para parar de comer
    def parar_de_comer(self):
        if not self.comendo:
            print(f'{self.nome} não está comendo!')
            return

        print(f'Ok, {self.nome} parou de comer.')
        self.comendo = False


    # Método que retorna o ano de nascimento
    def get_ano_nascimento(self):
        return self.ano_atual - self.idade


    # Método de classe para calcular o ano de nascimento
    @classmethod
    def por_ano_nascimento(cls, nome, ano_nascimendo):
        idade = cls.ano_atual - ano_nascimendo
        return cls(nome, idade)
    

## MAIN
if __name__ == '__main__':
    p1 = Pessoa()

