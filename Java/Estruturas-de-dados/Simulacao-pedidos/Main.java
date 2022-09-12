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

                // Montagem do pedido
                montagem.colocaNaFila(pedido);
                montagem.setTempoNecessario(pedido.getQtdPasteis(), pedido.getQtdPizzas());
                if (montagem.temProcessadorLivre()) {
                    System.out.printf("PROCESSADOR #%d LIVRE\n", montagem.getIndiceProcessadorLivre());
                    montagem.retiraDaFila();
                    montagem.atribuiAoProcessadorLivre(pedido);
                }






            }

            /*
            while (montagem.temProcessadorLivre()) {
                montagem.atribuiAoProcessadorLivre(montagem.retiraDaFila());
                System.out.println(saida + "saiu da fila e está sendo processado.");
            }
             */


            Thread.sleep(2500);
            tempo++;
            numeroDoPedido++;
        } while (tempo < 8 * 60);
    }
}

