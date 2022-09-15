import numpy as np

class Stack:
    ## Construtor.
    def __init__(self, count = 0):
        self.stack = np.asarray([0] * count)
        self.count = count
        self.last = 0
        
    # SIZE
    def size(self):
        return self.count

    # SIZE_USED



    # IS_EMPTY

    # ADD
    def add(self, element):
        self.stack[self.last] = element
        self.last += 1
    
    # POP

    # TOP
    def top(self):
        return self.stack[self.last - 1]

    # CLEAN

    def visu(self):
        print(self.stack)