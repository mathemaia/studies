from tkinter import *

janela = Tk()

# Configurações
WIDTH = 500
HEIGHT = 250
janela.geometry(f'{str(WIDTH)}x{str(HEIGHT)}')
janela.title('∫ dx')
janela.config(background='#242424')

# Label
label = Label(janela, text='∫f(x)dx', font=('Times New Roman', 40), bg='#242424', fg='white')
label.place()

if __name__ == '__main__':
    janela.mainloop()
