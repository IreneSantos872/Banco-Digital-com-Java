package one.dio.bancodigital;

import one.dio.bancodigital.entity.Banco;
import one.dio.bancodigital.entity.Cliente;
import one.dio.bancodigital.entity.Conta;
import one.dio.bancodigital.entity.ContaCorrente;

public class Main {

    public static void main(String[] args) {
        Cliente nome = new Cliente();
        nome.setNome("Pedro");

        Conta cc = new ContaCorrente(nome);
        cc.depositar(100);

        Conta poupanca = new ContaCorrente(nome);
        poupanca.depositar(50);

        cc.transferir(60, poupanca);

        cc.imprimirExtrato();

        poupanca.imprimirExtrato();

        poupanca.transferir(20, cc);

        poupanca.imprimirExtrato();

        Banco bco = new Banco();
        bco.imprimirListaContas();
    }
}
