import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Pedido[] pedidos = new Pedido[5000];
        Pedido p;
        UnidadeDeProcessamento montagem = new UnidadeDeProcessamento();
        UnidadeDeProcessamento cozimento = new UnidadeDeProcessamento();
        UnidadeDeProcessamento empacotamento = new UnidadeDeProcessamento();

        // Inicializa cada pedido do vetor
        for (int i = 0; i < pedidos.length; i++) {
            pedidos[i] = new Pedido(Integer.toString(i));
            pedidos[i].setTempoTotal(pedidos[i].tempoEmpacotamento(),pedidos[i].tempoCozimento(),pedidos[i].tempoMontagem());
        }

        for (int i = 0; i < pedidos.length; i++) {
            montagem.setEntrada(pedidos[i]);
            montagem.processamento();
        }
    }
}

