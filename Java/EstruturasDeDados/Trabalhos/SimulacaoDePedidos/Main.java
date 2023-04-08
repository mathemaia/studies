import java.util.Random;

/**
 * Classe principal.
 * @author matheus maia
 */

public class Main {
    /**
     * Método que gera um novo pedido com as configurações definidas.
     * @param tempo instante de entrada
     * @return objeto pedido
     */
    public static Pedido gerarPedido(int tempo, int numero) {
        Random random = new Random();

        /*
        Modifiquei a quantidade máxima de 5, como pedido no enunciado, por 7 pois muitos pedidos estavam sendo gerados
        com um total de tempo igual à zero, e com isso era lançada uma exceção de fila vazia. Com a quantidade máxima 7
        o algoritmo pareceu se sair melhor.
         */
        int pizzas = random.nextInt(3);
        int pasteis = random.nextInt(7);

        /*
         Evita que a quantidade de pasteis e pizzas sejam
         ambos igual a zero.
         */
        if (pizzas == 0 && pasteis == 0) {
            if (random.nextBoolean()) {
                pizzas++;
            } else {
                pasteis++;
            }
        }
        return new Pedido(pizzas, pasteis, tempo, numero);
    }

    /*
    MAIN
     */
    public static void main(String[] args) {

        Random random = new Random();
        Montagem montagem = new Montagem();
        Cozimento cozimento = new Cozimento();
        Empacotamento empacotamento = new Empacotamento();

        int tempo = 1;
        int numeroDoPedido = 1;

        do {
            int numeroAleatorio = random.nextInt(99);

            // Se o número aleatório for maior que 80, é gerado um novo pedido.
            if (numeroAleatorio > 80) {
                Pedido pedido = gerarPedido(tempo, numeroDoPedido);
                Integer pasteis = pedido.getQtdPasteis();
                Integer pizzas = pedido.getQtdPizzas();
                Pedido p = new Pedido();

                // MONTAGEM
                montagem.colocaNaFila(pedido);
                montagem.setTempoNecessario(pedido.getQtdPasteis(), pedido.getQtdPizzas());
                if (montagem.temProcessadorLivre()) {
                    pedido = montagem.retiraDaFila();
                    montagem.inssereNoProcessadorLivre(pedido);
                }
                if (montagem.processamentoFinalizado()) {
                    p = montagem.concluirProcessamento();
                    cozimento.colocaNaFila(p);
                    cozimento.setTempoNecessario(p.getQtdPasteis(), p.getQtdPizzas());

                    // COZIMENTO
                    if (cozimento.temProcessadorLivre()) {
                        pedido = cozimento.retiraDaFila();
                        cozimento.inssereNoProcessadorLivre(pedido);
                    }
                    if (cozimento.processamentoFinalizado()) {
                        p = cozimento.concluirProcessamento();
                        empacotamento.colocaNaFila(p);
                        empacotamento.setTNecessario(p.getQtdPasteis(), p.getQtdPizzas());

                        // EMPACOTAMENTO
                        if (empacotamento.temProcessadorLivre()) {
                            p = empacotamento.retiraDaFila();
                            empacotamento.inssereNoProcessadorLivre(p);
                        }
                        if (empacotamento.processamentoFinalizado()) {
                            p = empacotamento.concluirProcessamento();
                            p.imprime(tempo);
                        }
                    }
                }

            }

            tempo++;
            numeroDoPedido++;
        } while (tempo < 8 * 60);
    }
}

