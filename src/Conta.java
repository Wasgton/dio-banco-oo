public abstract class Conta implements IConta{

    protected static final int AGENCIA_DEFAULT = 1;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente cliente, double saldo){
        this.agencia = AGENCIA_DEFAULT;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = saldo;
    }
        
    protected int numero,agencia;
    protected Cliente cliente;
    protected Double saldo;

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        if(saldo>=valor){
            saldo -= valor;
        }else{
            System.out.println("---- Operação invalida ------");
            System.out.println("Saldo insuficiente");
            System.exit(-1);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("----- Transferencia executada com sucesso -----");
        System.out.printf("%.2f%n",valor);
        this.imprimirExtrato();
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("-------- Extrato -------");
        System.out.printf("Titular: %s%n",getCliente().getNome());
        System.out.printf("CPF: %s%n",getCliente().getCpf());
        System.out.printf("Agencia: %d%n",getAgencia());
        System.out.printf("Numero: %d%n",getNumero());
        System.out.printf("Saldo: %.2f%n", getSaldo());
    }

}
