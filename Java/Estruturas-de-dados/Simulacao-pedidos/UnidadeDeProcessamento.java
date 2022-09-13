/**
 * Esta classe foi criada como abstrata pois decidi usar as unidade de processamentos com saídas diferentess e poder
 * vizualizar melhor o processo no terminal.
 * @author matheus maia
 * @version 12-09-2022
 */

public abstract class UnidadeDeProcessamento {
    Fila fila = new Fila();
    private final Pedido[] processadores = new Pedido[3];
    private Integer indiceProcessadorLivre;
    private final Integer idx = null;
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
     * Insere o pedido retirado da fila ao processador livre.
     */
    public void inssereNoProcessadorLivre(Pedido pedido) {
        processadores[getIndiceProcessadorLivre()] = pedido;
    }

    /**
     * Retorna true se o pedido estiver finalizado
     * @return true
     */
    public boolean processamentoFinalizado() {
        boolean valor = false;
        for (int i = 0; i < processadores.length; i++) {
            if ((processadores[i] != null) && (processadores[i].getTempoParaProcessar() == 0) && (processadores[i].getNumero() != 1)) {
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
     * Retorna o indice do processador livre.
     * @return indice
     */
    public int getIndiceProcessadorLivre() {
        return this.indiceProcessadorLivre;
    }

    /**
     * Conclui o processamento retornando o objeto que zerou o tempo.
     * @return objeto que sai.
     */
    public Pedido concluirProcessamento() {
        System.out.println(processadores[indiceProcessadorLivre].getNumero() + " pronto!");
        Integer aux1 = indiceProcessadorLivre;
        Pedido aux2 = processadores[indiceProcessadorLivre];

        this.indiceProcessadorLivre = null;
        processadores[aux1] = retiraDaFila();
        System.out.println("#" + processadores[aux1].getNumero() + " processando...");

        return aux2;
    }
}

