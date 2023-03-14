package Alest2;

public class Macaquinho {
    int numero;
    int par;
    int impar;
    int coquinhos;
    int[] pedrinhas;

    /**
     * Construtor
     * @param numero Numero de identificação
     * @param par Para onde enviar caso qtd coquinhos seja par
     * @param impar Para onde enviar caso qtd coquinhos seja impar
     * @param coquinhos Quantidade coquinhos de coquinhos
     * @param pedrinhas Vetor com com as qtds totais de pedrinhas de cada coquinho
     */
    public Macaquinho(int numero, int par, int impar, int coquinhos, int[] pedrinhas) {
        this.numero = numero;
        this.par = par;
        this.impar = impar;
        this.coquinhos = coquinhos;
        this.pedrinhas = pedrinhas;
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
    public void setPedrinhas(int[] pedrinhas) {
        this.pedrinhas = pedrinhas;
    }

    /**
     * Getters
     */
    public int getNumero() {
        return numero;
    }
    public int getPar() {
        return par;
    }
    public int getImpar() {
        return impar;
    }
    public int getCoquinhos() {
        return coquinhos;
    }
    public int[] getPedrinhas() {
        return pedrinhas;
    }
}
