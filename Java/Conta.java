/**
 * Código para estudo de orientação a objetos que implementa e simula o comportamento de uma conta bancária.
 * @author matheus maia
 * @version %I%, %G%
 */

public class Conta {
    private String nome;
    private double saldo;

    // Construtures.
    public Conta() {
        this.saldo = 0.0;
        this.nome = null;
    }
    public Conta(String nome, double saldo) {
        this.nome = nome.toUpperCase();
        this.saldo = saldo;
    }

    // Setters.
    /**
     * Define o saldo inicial da conta.
     * @param saldo saldo inicial
     */
    public void setSaldoInicial(double saldo) {
        this.saldo = saldo;
    }
    /**
     * Define o nome do titular da conta.
     * @param nome titular
     */
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }
    /**
     * Define um novo saldo somando com o antigo.
     * @param valor valor a depositar
     */
    public void deposito(double valor) {
        this.saldo = saldo + valor;
    }
    /**
     * Retira o valor definido do saldo atual
     * @param valor valor a ser retirado
     */
    public void saque(double valor) {
        this.saldo = saldo - valor;
    }

    // Getters.
    /**
     * Retorna o saldo atual da conta.
     * @return saldo
     */
    public double getSaldo() {
        return saldo;
    }
    /**
     * Retorna o nome do titular da conta.
     * @return titular
     */
    public String getNome() {
        return nome;
    }

    public static void main(String[] args) {
        Conta c = new Conta("Matheus", 0.0);

        System.out.println("SALDO INICIAL: " + c.getSaldo());
        System.out.println("TITULAR: " + c.getNome());

        c.deposito(100);
        c.saque(25);
        System.out.println("\nsaldo: " + c.getSaldo());
    }
}
