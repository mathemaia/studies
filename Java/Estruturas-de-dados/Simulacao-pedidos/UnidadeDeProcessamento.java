public abstract class UnidadeDeProcessamento {
    private final Fila fila = new Fila();
    private final Pedido[] processadores = new Pedido[3];
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
        System.out.println("\n\n" + pedido + " entrou na fila.\n\n");
    }

    /**
     * Retorna true ou false se tiver processamento livre.
     * @return true ou false
     */
    public boolean temProcessadorLivre() {
        boolean temProcessadorLivre = false;
        for (int i = 0; i < processadores.length; i++) {
            if (processadores[i] == null) {
                temProcessadorLivre = true;
                this.indiceProcessadorLivre = i;
                break;
            }
        }

        return temProcessadorLivre;
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
        processadores[getIndiceProcessadorLivre()] = pedido;

        System.out.println(pedido + " esta sendo processado.");
        System.out.println("indiceProcessador: " + getIndiceProcessadorLivre());
    }

    public boolean processamentoFinalizado() {
        return processamentoFinalizado;
    }

    public int getIndiceProcessadorLivre() {
        return this.indiceProcessadorLivre;
    }
}

