package Trabalho;

public class Macaquinho {
    // Numero do macaquinho
    private int numero;
    // Para qual macaquinho enviar os coquinhos com pedrinhas PARES
    private int enviarPar;
    // Para qual macaquinho enviar os coquinhos com pedrinhas IMPARES
    private int enviarImpar;
    // Quantidade total de coquinhos (PARES + IMPARES)
    private int qtdTotal;
    // Vetor com todos os coquinhos pares (quantidade de pedrinhas)
    private int qtdImpar;
    // Vetor com todos os coquinhos impares (quantidade de pedrinhas)
    private int qtdPar;

    /**
     * Construtor
     * @param numero numero do macaquinho
     * @param enviarPar Para onde enviar os coquinhos com quantidade par de pedrinhas
     * @param enviarImpar Para onde enviar os coquinhos com quantidade impar de pedrinhas
     * @param qtdTotal Quantidade total de coquinhos
     */
    public Macaquinho(int numero, int enviarPar, int enviarImpar, int qtdTotal, int qtdPar, int qtdImpar) {
        this.numero = numero;
        this.enviarPar = enviarPar;
        this.enviarImpar = enviarImpar;
        this.qtdTotal = qtdTotal;
        this.qtdPar = qtdPar;
        this.qtdImpar = qtdImpar;
    }

    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * Define um novo valor à quanidade PAR de pedrinhas ao unir o novo vetor com o antigo
     * @param qtdPar vetor que irá ser unido com o atual
     */
    public void setQtdPar(int qtdPar) {
        this.qtdPar = this.qtdPar + qtdPar;
        this.qtdTotal = this.qtdPar + this.qtdImpar;
        //System.out.println("totalPar: " + this.qtdPar);
    }
    /**
     * Define um novo valor à quanidade IMPAR de pedrinhas ao unir o novo vetor com o antigo
     * @param qtdImpar vetor que irá ser unido com o atual
     */
    public void setQtdImpar(int qtdImpar) {
        this.qtdImpar = this.qtdImpar + qtdImpar;
        this.qtdTotal = this.qtdImpar + this.qtdPar;
        //System.out.println("totalImpar: " + this.qtdImpar);
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
     * Devolve a quantidade de coquinhos com numero PAR de pedrinhas
     * @return quantidade de coquinhos com pedrinhas PARES
     */
    public int getQtdPar() {
        int aux = this.qtdPar;
        this.qtdTotal = this.qtdImpar;
        this.qtdPar = 0;
        return aux;
    }
    /**
     * Devolve a quantidade de coquinhos com numero IMPAR de pedrinhas
     * @return quantidade de coquinhos com pedrinhas IMPARES
     */
    public int getQtdImpar() {
        int aux = this.qtdImpar;
        this.qtdTotal = this.qtdPar;
        this.qtdImpar = 0;
        return aux;
    }
    /**
     * Devolve a quantidade total de coquinhos (pares + impares)
     * @return quanidade total de coquinhos
     */
    public int getQtdTotal() {
        return this.qtdTotal;
    }
}
