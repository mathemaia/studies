package Trabalho;


public class Macaquinho {
    // Numero de identificação
    private int numero;
    // Para qual macaquinho enviar os coquinhos com pedrinhas PARES
    private int enviarPar;
    // Para qual macaquinho enviar os coquinhos com pedrinhas IMPARES
    private int enviarImpar;
    // Quantidade total de coquinhos (PARES + IMPARES)
    private int coquinhosTotal;
    // Vetor com todos os coquinhos pares (quantidade de pedrinhas)
    private int[] coquinhosPares;
    // Vetor com todos os coquinhos impares (quantidade de pedrinhas)
    private int[] coquinhosImpares;

    /**
     * Construtor
     * @param numero Numero de identificação
     * @param enviarPar Para onde enviar os coquinhos com quantidade par de pedrinhas
     * @param enviarImpar Para onde enviar os coquinhos com quantidade impar de pedrinhas
     * @param coquinhosTotal Quantidade total de coquinhos
     */
    public Macaquinho(int numero, int enviarPar, int enviarImpar, int coquinhosTotal, int[] coquinhosPares, int[] coquinhosImpares) {
        this.numero = numero;
        this.enviarPar = enviarPar;
        this.enviarImpar = enviarImpar;
        this.coquinhosTotal = coquinhosTotal;
        this.coquinhosPares = coquinhosPares;
        this.coquinhosImpares = coquinhosImpares;
    }

    // Setters
    /**
     * Define um novo valor/novo vetor de coquinhos com quanidade PAR de pedrinhas ao unir o novo vetor com o antigo
     * @param coquinhosPares vetor que irá ser unido com o atual
     */
    public void setCoquinhosPares(int[] coquinhosPares) {
        // Cria um vetor auxiliar que será o novo vetor de coquinhos PARES
        int[] aux = new int[this.coquinhosPares.length + coquinhosPares.length];
        // Faz a cópia do vetor antigo para o auxiliar
        System.arraycopy(this.coquinhosPares, 0, aux, 0, this.coquinhosPares.length);
        // Faz a cópia do vetor recebido para o auxiilar
        System.arraycopy(coquinhosPares, 0, aux, this.coquinhosPares.length, coquinhosPares.length);
        // Da um novo valor ao vetor de coquinhos pares formado pelo antigo unido ao recebido
        this.coquinhosPares = aux;
        // Modifica o valor total de coquinhos do macaquinho atual
        this.coquinhosTotal = this.coquinhosPares.length + this.coquinhosImpares.length;
    }
    /**
     * Define um novo valor/novo vetor de coquinhos com quanidade IMPAR de pedrinhas ao unir o novo vetor com o antigo
     * @param coquinhosImpares vetor que irá ser unido com o atual
     */
    public void setCoquinhosImpares(int[] coquinhosImpares) {
        // Cria um vetor auxiliar que será o novo vetor de coquinhos IMPARES
        int[] aux = new int[this.coquinhosImpares.length + coquinhosImpares.length];
        // Faz a cópia do vetor antigo para o auxiliar
        System.arraycopy(this.coquinhosImpares, 0, aux, 0, this.coquinhosImpares.length);
        // Faz a cópia do vetor recebido para o auxiilar
        System.arraycopy(coquinhosImpares, 0, aux, this.coquinhosImpares.length, coquinhosImpares.length);
        // Da um novo valor ao vetor de coquinhos pares formado pelo antigo unido ao recebido
        this.coquinhosImpares = aux;
        // Modifica o valor total de coquinhos do macaquinho atual
        this.coquinhosTotal = this.coquinhosPares.length + this.coquinhosImpares.length;
    }

    // Getters
    public int getNumero() {
        return numero;
    }
    /**
     * Devolve o número do macaquinho que irá receber os coquinhos com quantidade PAR
     * @return nº do macaquinho
     */
    public int getEnviarPar() {
        return this.enviarPar;
    }
    /**
     * Devolve o nº do macaquinho que irá receber os coquinhos com quantidade IMPAR
     * @return nº do macaquinho
     */
    public int getEnviarImpar() {
        return this.enviarImpar;
    }
    /**
     * Devolve um vetor com os coquinhos de pedrinhas com quantidades PARES o zera
     * @return coquinhos com pedrinhas PARES
     */
    public int[] getCoquinhosPares() {
        // Zera o array de coquinhos PARES
        int[] aux = this.coquinhosPares;
        this.coquinhosPares = new int[0];
        // Modifica o valor total de coquinhos do macaquinho atual
        this.coquinhosTotal = this.coquinhosPares.length + this.coquinhosImpares.length;

        return aux;
    }
    /**
     * Devolve um vetor com os coquinhos de pedrinhas com quantidades IMPARES o zera
     * @return coquinhos com pedrinhas IMPARES
     */
    public int[] getCoquinhosImpares() {
        // Zera o array de coquinhos IMPARES
        int[] aux = this.coquinhosImpares;
        this.coquinhosImpares = new int[0];
        // Modifica o valor total de coquinhos do macaquinho atual
        this.coquinhosTotal = this.coquinhosPares.length + this.coquinhosImpares.length;

        return aux;
    }
    /**
     * Devolve a quantidade total de coquinhos (pares + impares)
     * @return quanidade total de coquinhos
     */
    public int getCoquinhosTotal() {
        return this.coquinhosTotal;
    }
}
