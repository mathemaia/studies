from abc import ABC, abstractmethod

class Pessoa(ABC):
    """Classe abstrata"""
    def __init__(self, nome, cpf, data_nascimento, estado_civil) -> None:
        self._nome = nome
        self._cpf = cpf
        self._data_nascimento = data_nascimento
        self._estado_civil = estado_civil

    @abstractmethod
    def cadastrar_dados():
        pass

    @abstractmethod
    def obter_dados():
        pass

class Medico(Pessoa):
    """Subclasse de Pessoa"""
    pass

class Enfermeiro(Pessoa):
    """Subclasse de Pessoa"""
    pass

class Paciente(Pessoa):
    """Subclasse de Pessoa"""
    pass

class Secretaria(Pessoa):
    """Subclasse de Pessoa"""
    pass

class Convenio:
    pass

