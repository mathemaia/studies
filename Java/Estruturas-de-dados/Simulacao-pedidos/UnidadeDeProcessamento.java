public abstract class UnidadeDeProcessamento {
    private final Fila fila = new Fila();
    private Pedido[] processadores = new Pedido[3];
    private boolean temProcessadorLivre;
    private int indiceProcessadorLivre;
    private boolean processamentoFinalizado;
    public Pedido pedido;

    /**
     * Insere novos pedidos na fila de processamento.
     * @param pedido objeto a ser inserido.
     */
    public void colocaNaFila(Pedido pedido) {
        fila.inserir(pedido);
        this.pedido = pedido;
        System.out.println(pedido + " entrou.");
        System.out.println("tamanho: " + fila.tamanho());
    }

    /**
     * Retorna true ou false se tiver processamento livre.
     * @return true ou false
     */
    public boolean temProcessadorLivre() {
        for (int i = 0; i < processadores.length; i++) {
            if (processadores[i] == null) {
                this.temProcessadorLivre = true;
                this.indiceProcessadorLivre = i;
            }
        }

        return this.temProcessadorLivre;
    }

    /**
     * Retira o primeiro elemento da fila de pedidos.
     * @return pedido
     */
    public Pedido retiraDaFila() {
        return fila.retirar();
    }

    /**
     * Atribui o pedido retirado da fila ao processador livre.
     */
    public void atribuiAoProcessadorLivre(Pedido pedido) {
        processadores[indiceProcessadorLivre] = pedido;
    }

    public boolean processamentoFinalizado() {
        return this.processamentoFinalizado;
    }

    public int getTempo() {
        return pedido.getTempoParaProcessar();
    }
}

