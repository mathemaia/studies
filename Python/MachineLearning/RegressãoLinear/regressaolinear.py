class RegressaoLinear():
    def __init__(self, X, y, lr, epochs):
        self.X = X
        self.y = y
        self.lr = lr

        self.m, self.n = self.X.shape
        self.epochs = epochs 
        self.w = np.zeros((self.n,1))
        self.b = 0


    # Predição
    def predict(self, X):
        return np.dot(X, self.w) + self.b
    

    # Gradiente
    def gradiente(self, pred):
        '''Calcula as derivadas e os erros que serão elevados ao quadrado na MSE'''
        erro = pred - self.y
        dw = (1 / self.n) * np.dot(self.X.T, erro)
        db = (1 / self.n) * np.sum(erro)
        return dw, db
    

    # Função de Custo
    def MSE(self, pred):
        '''Eleva os erros ao quadrado e faz o somatório'''
        return np.sum((pred - self.y)**2) / self.m


    # Gradiente Descendente
    def GD(self):
        custo_total = []
        for iteracao in range(self.epochs):
            pred   = self.predict(self.X)
            dw, db = self.gradiente(pred)
            self.w = self.w - self.lr * dw
            self.b = self.b - self.lr * db

            custo = self.MSE(pred)
            custo_total.append(custo)
