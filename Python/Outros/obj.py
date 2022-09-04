class Computador:
    ## construtores
    def __init__(self, ram=0, hd=0, gpu='', cpu=''):
        self.ram = ram
        self.hd = hd
        self.gpu = gpu
        self.cpu = cpu

    ## setters
    def set_ram(self, ram):
        self.ram = ram
    def set_hd(self, hd):
        self.hd = hd
    def set_gpu(self, gpu):
        self.gpu = gpu
    def set_cpu(self, cpu):
        self.cpu = cpu

    ## getters
    def get_ram(self):
        return self.ram
    def get_hd(self):
        return self.hd 
    def get_gpu(self):
        return self.gpu 
    def get_cpu(self):
        return self.cpu 
