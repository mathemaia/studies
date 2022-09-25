# Código de estudo de herança múltipla

class A:
    def __str__(self):
        return 'A'

    @staticmethod
    def dados():
        return 'A_dados'

class B:
    def __str__(self):
        return 'B'

    @staticmethod
    def dados():
        return 'B_dados'


class C(A, B):
    def __str__(self):
        return 'C'


class D(C):
    def __str__(self):
        return super().__str__() + ' --> D'
        #return A().__str__() + ' -> D'


if __name__ == '__main__':
    a = A()
    print(a)

    b = B()
    print(b)

    c = C()
    print(c)

    d = D()
    print(d)