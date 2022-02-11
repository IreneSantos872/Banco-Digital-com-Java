package one.dio.bancodigital.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {

    private String nomeBanco;
    private List<Conta> contas = new ArrayList<>();
    protected Cliente cliente;


    public String getNome() {
        return nomeBanco;
    }

    public void setNome(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public void addConta(Conta c){
        this.contas.add(c);
    }

    public void transferirEntreContas(int numeroContaOrigem, int numeroContaDestino, double valor){
        Optional<Conta> contaOrigem = this.contas.stream().filter((conta) -> conta.getAgencia()== 1 && conta.getNumero() == numeroContaOrigem ).findFirst();
        Optional<Conta> contaDestino = this.contas.stream().filter((conta) -> conta.getAgencia()== 1 && conta.getNumero() == numeroContaDestino ).findFirst();
        if(contaOrigem.isPresent() && contaDestino.isPresent()){
            contaOrigem.get().transferir(valor, contaDestino.get());
        }
        else{
            System.out.println("Conta origem ou destino não existe!");
        }
    }

    public void depositoEmConta(int numeroConta, double valor){
        Optional<Conta> nroconta = this.contas.stream().filter((conta) -> conta.getAgencia()== 1 && conta.getNumero() == numeroConta).findFirst();

        if(nroconta.isPresent()){
            nroconta.get().depositar(valor);
       }
        else{
            System.out.println("Conta não existe!");
        }
    }

    public void saqueEmConta(int numeroConta, double valor){
        Optional<Conta> nroconta = this.contas.stream().filter((conta) -> conta.getAgencia()== 1 && conta.getNumero() == numeroConta).findFirst();

        if(nroconta.isPresent()){
            nroconta.get().sacar(valor);
        }
        else{
            System.out.println("Conta não existe!");
        }
    }

    public void removeConta(int numero){
        Optional<Conta> contaRemove = this.contas.stream().filter((conta) -> conta.getAgencia()== 1 && conta.getNumero() == numero ).findFirst();
        if(contaRemove.isPresent()){
            this.contas.remove(contaRemove.get());
        }
        else{
            System.out.println("Conta não existe!");
        }
    }

    public void imprimirListaContas(){
        System.out.println(String.format("===== LISTA DE CONTAS ======"));
        for (Conta auxConta: this.contas) {

            if(auxConta.getClass().getName().equalsIgnoreCase("one.dio.bancodigital.entity.ContaCorrente"))
                System.out.println(String.format("=== Conta Corrente ==== "));
            else if (auxConta.getClass().getName().equalsIgnoreCase("one.dio.bancodigital.entity.ContaPoupanca"))
                System.out.println(String.format("=== Conta Poupanca ==== "));

            System.out.println(String.format("Titular: %s", auxConta.cliente.getNome())
            +"  " + (String.format("Agencia: %d", auxConta.getAgencia())) + "  " + (String.format("Numero: %d", auxConta.getNumero()))
            + "  " + (String.format("Saldo: %.2f", auxConta.getSaldo())));

        }
   }

}
