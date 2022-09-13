import java.util.Random;

public class Main {
    /**
     * Método que gera um novo pedido com as configurações definidas.
     * @param tempo instante de entrada
     * @return objeto pedido
     */
    public static Pedido gerarPedido(int tempo, int numero) {
        Random random = new Random();

        int pizzas = random.nextInt(3);
        int pasteis = random.nextInt(5);

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

    // MAIN
    public static void main(String[] args) throws InterruptedException {
        Pedido saida;
        Random random = new Random();
        Montagem montagem = new Montagem();
        Cozimento cozimento = new Cozimento();
        Empacotamento empacotamento = new Empacotamento();

        int tempo = 0;
        int numeroDoPedido = 1;

        do {
            int numeroAleatorio = random.nextInt(99);

            // Se o número aleatório for maior que 80, é gerado um novo pedido.
            if (numeroAleatorio > 50) {
                Pedido pedido = gerarPedido(tempo, numeroDoPedido);
                Integer pasteis = pedido.getQtdPasteis();
                Integer pizzas = pedido.getQtdPizzas();

                // MONTAGEM
                montagem.colocaNaFila(pedido);
                montagem.setTempoNecessario(pedido.getQtdPasteis(), pedido.getQtdPizzas());
                if (montagem.temProcessadorLivre()) {
                    pedido = montagem.retiraDaFila();
                    montagem.atribuiAoProcessadorLivre(pedido);
                }
                if (montagem.processamentoFinalizado()) {
                    Pedido p = montagem.concluirProcessamento();
                    cozimento.colocaNaFila(p);
                    cozimento.setTempoNecessario(p.getQtdPasteis(), p.getQtdPizzas());

                    // COZIMENTO
                    if (cozimento.temProcessadorLivre()) {
                        pedido = cozimento.retiraDaFila();
                        cozimento.atribuiAoProcessadorLivre(pedido);
                    }
                    if (cozimento.processamentoFinalizado()) {
                        p = cozimento.concluirProcessamento();
                        empacotamento.colocaNaFila(p);
                        empacotamento.setTempoNecessario(p.getQtdPasteis(), p.getQtdPizzas());

                        // EMPACOTAMENTO
                        if (empacotamento.temProcessadorLivre()) {
                            p = empacotamento.retiraDaFila();
                            empacotamento.atribuiAoProcessadorLivre(p);
                        }
                        if (empacotamento.processamentoFinalizado()) {
                            p = empacotamento.concluirProcessamento();
                            p.imprime();
                        }
                    }


                }












            }

            /*
            while (montagem.temProcessadorLivre()) {
                montagem.atribuiAoProcessadorLivre(montagem.retiraDaFila());
                System.out.println(saida + "saiu da fila e está sendo processado.");
            }
             */


            //Thread.sleep(500);
            tempo++;
            numeroDoPedido++;
        } while (tempo < 8 * 60);
    }
}

