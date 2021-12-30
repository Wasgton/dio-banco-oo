public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Usuario", "65498732145");

        Conta cc = new ContaCorrente(cliente,2500.00);
        Conta cp = new ContaPoupanca(cliente,200.00);

        cp.transferir(200.00,cc);
    }
}
