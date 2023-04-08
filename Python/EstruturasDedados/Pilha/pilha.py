# Classe pilha.
# 15-09-2022

class Stack:
    ## Construtor.
    def __init__(self):
        self.stack = []
        self.count = 0

    # SIZE
    def size(self):
        """Retorna a quantidade de elementos da pilha."""
        return self.count
    
    # IS_EMPTY
    def is_empty(self):
        """Retorna true ou false se a pilha estiver ou não vazia."""
        return self.count == 0

    # ADD
    def add(self, element):
        """Adiciona um elemento no topo da pilha."""
        self.stack.append(element)
        self.count += 1
    
    # POP
    def pop(self):
        """Retorna e remove o último elemento da lista."""
        aux = self.stack[-1]
        self.stack.remove(self.stack[-1])
        self.count -= 1
        return aux

    # TOP
    def top(self):
        """Retorna o último elemento da pilha sem removê-lo."""
        return self.stack[-1]

    # CLEAN
    def clear(self):
        """Esvazia a pilha."""
        self.stack = []
        count = 0
