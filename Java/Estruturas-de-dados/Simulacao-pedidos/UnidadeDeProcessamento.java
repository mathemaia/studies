public class UnidadeDeProcessamento {
    private final Fila filaDeEspera = new Fila();
    private final Pedido[] processadores = new Pedido[3];
    private Pedido entrada = null;
    private Pedido saida = null;

    // Setters
    public void setEntrada(Pedido entrada) {
        this.entrada = entrada;
    }
    public void setSaida(Pedido saida) {
        this.saida = saida;
    }

    // Getters
    public Pedido getEntrada() {
        return entrada;
    }
    public Pedido getSaida() {
        return this.saida;
    }

    // Método que faz o processamento da entrada e devolve a saida
    public void processamento() throws InterruptedException {
        int idxProcessador = 0;
        int idxNull = 0;
        boolean temEspaco = false;

        // Checa se existe algum processador livre.
        for (int j = 0; j < processadores.length; j++) {
            if (processadores[j] == null) {
                temEspaco = true;
                idxProcessador = j;
            }
        }

        Pedido p = getEntrada();
        filaDeEspera.inserir(p);

        // Se sim, entra para o vetor de processadores o próximo pedido da lista de espera.
        // Se não, vai para fila de espera.
        if (temEspaco) {
            processadores[idxProcessador] = filaDeEspera.retirar();
            System.out.println(processadores[idxProcessador].getId() + " alocado em [" + idxProcessador + "].\n");
        } else {
            System.out.println(p.getId() + " entrou para a fila de espera...");
            System.out.println("tamanho da fila de espera: " + filaDeEspera.tamanho() + "\n");
            filaDeEspera.inserir(p);
        }

        // Verifica se algum pedido deve sair do processador
        for (int k = 0; k < processadores.length; k++) {
            if (processadores[k] != null) {
                if (processadores[k].getTempoTotal() == 0) {
                    System.out.println("    " + processadores[k].getId() + " saiu! [" + k + "]");
                    setSaida(processadores[k]);
                    processadores[k] = null;
                } else {
                    processadores[k].setNovoInstante(1);
                    System.out.println(processadores[k].getId() + "--  : " + processadores[k].getTempoTotal());
                }

            }

        }



        //Thread.sleep(2000);
    }
}

