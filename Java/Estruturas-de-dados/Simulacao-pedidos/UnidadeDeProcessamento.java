public abstract class UnidadeDeProcessamento {
    Fila fila = new Fila();
    private final Pedido[] processadores = new Pedido[3];
    private Integer indiceProcessadorLivre;
    private Integer idx = null;
    public Pedido pedido;

    /**
     * Insere novos pedidos na fila de processamento.
     * @param pedido objeto a ser inserido.
     */
    public void colocaNaFila(Pedido pedido) {
        fila.inserir(pedido);
        this.pedido = pedido;
        System.out.println("#" + pedido.getNumero() + " entrou na fila.\n");
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

        //System.out.println(pedido + " esta sendo processado.");
        //System.out.println("i: " + getIndiceProcessadorLivre());
    }

    /**
     * Retorna true se o pedido estiver finalizado
     * @return true
     */
    public boolean processamentoFinalizado() {
        boolean valor = false;
        for (int i = 0; i < processadores.length; i++) {
            if ((processadores[i] != null) && (processadores[i].getTempoParaProcessar() == 0)) {
                this.indiceProcessadorLivre = i;
                valor = true;
            } else if (processadores[i] != null){
                processadores[i].decrementarTempo();
                System.out.println("#" + processadores[i].getNumero() + ": " + processadores[i].getTempoParaProcessar() + "s");
            }
        }

        return valor;
    }

    /**
     * Retorna o indice do processador livre para atribuir o objeto.
     * @return indice
     */
    public int getIndiceProcessadorLivre() {
        return this.indiceProcessadorLivre;
    }

    public Pedido concluirProcessamento() {
        System.out.println(processadores[indiceProcessadorLivre].getNumero() + " pronto!");
        Integer aux1 = indiceProcessadorLivre;
        Pedido aux2 = processadores[indiceProcessadorLivre];

        this.indiceProcessadorLivre = null;
        processadores[aux1] = retiraDaFila();
        System.out.println("#" + processadores[aux1].getNumero() + " está sendo processado...");

        return aux2;
    }
}

