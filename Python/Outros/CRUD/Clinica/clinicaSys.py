from abc import ABC, abstractmethod

class Pessoa(ABC):
    """Classe abstrata"""
    def __init__(self, nome: str, cpf: int, data_nascimento: str, estado_civil: str) -> None:
        self._nome = nome
        self._cpf = cpf
        self._data_nascimento = data_nascimento
        self._estado_civil = estado_civil

    @abstractmethod
    def __str__(self) -> str:
        """Retorna os atributos do objeto em formato string"""
        return f'NOME: {self._nome}\n' \
               f'CPF: {self._cpf}\n' \
               f'D_NASCIMENTO: {self._data_nascimento}\n' \
               f'E_CIVIL: {self._estado_civil}'

    @abstractmethod
    def cadastrar_dados(self):
        pass

    @abstractmethod
    def obter_dados(self):
        pass

# MEDICO
class Medico(Pessoa):
    """Subclasse de Pessoa"""
    def __init__(self, nome: str, cpf: int, data_nascimento: str, estado_civil: str, crm: int) -> None:
        super().__init__(nome, cpf, data_nascimento, estado_civil)
        self._crm = crm

    def __str__(self) -> str:
        """Retorna os atributos do objeto em formato string"""
        return f'NOME: {self._nome}\n' \
               f'CPF: {self._cpf}\n' \
               f'D_NASCIMENTO: {self._data_nascimento}\n' \
               f'E_CIVIL: {self._estado_civil}\n' \
               f'CRM: {self._crm}\n'

    def cadastrar_dados(self):
        pass
    def obter_dados(self):
        pass

# ENFERMEIRO
class Enfermeira(Pessoa):
    """Subclasse de Pessoa"""
    def __str__(self) -> str:
        """Retorna os atributos do objeto em formato string"""
        return f'NOME: {self._nome}\n' \
               f'CPF: {self._cpf}\n' \
               f'D_NASCIMENTO: {self._data_nascimento}\n' \
               f'E_CIVIL: {self._estado_civil}\n'

    def cadastrar_dados(self):
        pass
    def obter_dados(self):
        pass

# PACIENTE
class Paciente(Pessoa):
    """Subclasse de Pessoa"""
    def __str__(self) -> str:
        """Retorna os atributos do objeto em formato string"""
        return f'NOME: {self._nome}\n' \
               f'CPF: {self._cpf}\n' \
               f'D_NASCIMENTO: {self._data_nascimento}\n' \
               f'E_CIVIL: {self._estado_civil}\n'

    def cadastrar_dados(self):
        pass
    def obter_dados(self):
        pass

# SECRETARIA
class Secretaria(Pessoa):
    """Subclasse de Pessoa"""
    def __str__(self) -> str:
        """Retorna os atributos do objeto em formato string"""
        return f'NOME: {self._nome}\n' \
               f'CPF: {self._cpf}\n' \
               f'D_NASCIMENTO: {self._data_nascimento}\n' \
               f'E_CIVIL: {self._estado_civil}\n'

    def cadastrar_dados(self):
        pass
    def obter_dados(self):
        pass

# CONVENIO
class Convenio:
    pass

