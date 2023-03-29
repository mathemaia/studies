package Trabalho;

import java.util.Arrays;

public class Macaquinho {
    // Numero de identificação
    int numero;
    // Para onde enviar os coquinhos com quantidade par de pedrinhas
    int par;
    // Para onde enviar os coquinhos com quantidade impar de pedrinhas
    int impar;
    // Quantidade total de coquinhos
    int coquinhos;
    // Vetor com todos os coquinhos pares (quantidade de pedrinhas)
    int[] coquinhosPares;
    // Vetor com todos os coquinhos impares (quantidade de pedrinhas)
    int[] coquinhosImpares;

    /**
     * Construtor
     * @param numero Numero de identificação
     * @param par Para onde enviar os coquinhos com quantidade par de pedrinhas
     * @param impar Para onde enviar os coquinhos com quantidade impar de pedrinhas
     * @param coquinhos Quantidade total de coquinhos
     */
    public Macaquinho(int numero, int par, int impar, int coquinhos, int[] coquinhosPares, int[] coquinhosImpares) {
        this.numero = numero;
        this.par = par;
        this.impar = impar;
        this.coquinhos = coquinhos;
        this.coquinhosPares = coquinhosPares;
        this.coquinhosImpares = coquinhosImpares;
    }

    /**
     * Setters
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setPar(int par) {
        this.par = par;
    }
    public void setImpar(int impar) {
        this.impar = impar;
    }
    public void setCoquinhos(int coquinhos) {
        this.coquinhos = coquinhos;
    }
    public void setCoquinhosPares(int[] coquinhosPares) {
        int[] aux = new int[this.coquinhosPares.length + coquinhosPares.length];
        System.arraycopy(this.coquinhosPares, 0, aux, 0, this.coquinhosPares.length);
        System.arraycopy(coquinhosPares, 0, aux, this.coquinhosPares.length, coquinhosPares.length);
        this.coquinhosPares = aux;
    }
    public void setCoquinhosImpares(int[] coquinhosImpares) {
        int[] aux = new int[this.coquinhosImpares.length + coquinhosImpares.length];
        System.arraycopy(this.coquinhosImpares, 0, aux, 0, this.coquinhosImpares.length);
        System.arraycopy(coquinhosImpares, 0, aux, this.coquinhosImpares.length, coquinhosImpares.length);
        this.coquinhosImpares = coquinhosImpares;
    }

    /**
     * Getters
     */
    public int getNumero() {
        return this.numero;
    }
    public int getPar() {
        return this.par;
    }
    public int getImpar() {
        return this.impar;
    }
    public int getCoquinhos() {
        return this.coquinhos;
    }
    public int[] getCoquinhosPares() {
        // Zera o array de coquinhos pares para fazer a rotatividade
        int[] aux = this.coquinhosPares;
        System.out.println("p: " + Arrays.toString(this.coquinhosPares));
        this.coquinhosPares = new int[0];
        return aux;
    }
    public int[] getCoquinhosImpares() {
        // Zera o array de coquinhos impares para fazer a rotatividade
        int[] aux = this.coquinhosImpares;
        System.out.println("i: " + Arrays.toString(this.coquinhosImpares));
        this.coquinhosImpares = new int[0];
        return aux;
    }
}
