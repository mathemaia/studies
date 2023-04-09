Disciplina: Coleta, Preparação e Análise de Dados
Professor: Lucas Silveira Kupssinskü

Pessoal, estou trazendo nesse zip o nosso ambiente básico de testes de scraping.
No momento que estou criando esse arquivo existe um bug na aplicação web que 
é corrigido com um pull request que está em aberto. Eu tomei a liberdade de 
pegar as alterações desse pull request e adicionar elas no código para evitar dores
de cabeça desnecessárias.

Requisitos:
 Python 2.X (sugiro utilizar a 2.7)
 Biblioteca pillow ($ python2 -m pip install Pillow)

Sugestão:
 Instalar dependencias via environment conda:
 conda env create -n webscrap --file .\environment.yml

Instruções de uso:
  Executar o script web2py.py usando python 2.X, ao fazer isso uma interface gráfica será
  aberta e vai permitir que você coloque uma senha e comece a usar a aplicação web. Se você
  estiver usando as opções padrão, o endereço no qual você vai acessar o site é http://127.0.0.1:8000/places/


Créditos:
  Framework web: http://www.web2py.com/
  Aplicação web: https://github.com/richardpenman/wswp_places
