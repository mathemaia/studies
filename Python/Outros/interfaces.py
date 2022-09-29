from abc import ABC, abstractmethod
from typing import Type
import math

# ESTUDO DE INTERFACES
# A ideia é criar uma interface formas que faz herança com circulo e quadrado para que uma classe calculadora os utilize
# para calcular area e perímetro.

class IFormas(ABC):
    """Classe do tipo interface"""
    @abstractmethod
    def get_area(self):
        """Calcula e retorna a área"""
        pass
    @abstractmethod
    def get_perimetro(self):
        """Calcula e retorna o perímetro"""
        pass


class Circulo(IFormas):
    """Classe filha"""
    def __init__(self, raio: int) -> None:
        self.raio = raio

    def get_area(self) -> int:
        return int(math.pi * math.pow(self.raio, 2))

    def get_perimetro(self) -> int:
        return int(2 * math.pi * self.raio)


class Quadrado(IFormas):
    """Classe filha"""
    def __init__(self, lado: int) -> None:
        self.lado = lado

    def get_area(self) -> int:
        return int(math.pow(self.lado, 2))

    def get_perimetro(self) -> int:
        return int(self.lado * 4)


class Calculadora:
    def __init__(self, forma: str):
        self.forma = forma

    def perimetro(self, forma: Type[IFormas]) -> int:
        return forma.get_perimetro()

    def area(self, forma: Type[IFormas]) -> int:
        return forma.get_area()


if __name__ == '__main__':
    calc = Calculadora('circulo')
    circulo = Circulo(2)
    calc.perimetro(circulo)
