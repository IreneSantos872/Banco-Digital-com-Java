package one.dio.bancodigital;

import one.dio.bancodigital.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Banco bco = new Banco();
        Scanner scan = new Scanner(System.in);
        String cliente,  tipoConta;
        int aux = 1, cont = 1, nroconta = 0, nrocontadestino = 0;
        double valor = 0.0;
        Conta conta = null;

        do {
            System.out.println("\n======  Banco Digital =======\n");
            System.out.println("Escolha a opção desejada: ");
            System.out.println(" 1 - Abrir Conta");
            System.out.println(" 2 - Depositar");
            System.out.println(" 3 - Transferir ");
            System.out.println(" 4 - Sacar ");
            System.out.println(" 5 - Listar Contas");
            System.out.println(" 6 - Excluir");
            System.out.println(" 7 - Sair");
            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    cliente = scan.next();
                    Cliente cliobj = new Cliente(cliente);
                    do {
                        System.out.println("Qual o tipo de conta (C = Corrente, P = Poupança): ");
                        tipoConta = scan.next();
                        if (tipoConta.equals("C")) {
                            conta = new ContaCorrente(cliobj);
                            aux = 2;
                        } else if (tipoConta.equals("P")) {
                            conta = new ContaPoupanca(cliobj);
                            aux = 2;
                        } else {
                            aux = 1;
                            System.out.println("Por gentileza digitar o tipo de conta correta (C = Corrente, P = Poupança)");
                        }
                    } while (aux == 1);

                    System.out.println("Digite o valor do deposito: ");
                    valor = scan.nextDouble();

                    conta.depositar(valor);
                    bco.addConta(conta);
                    System.out.println("Depósito efetuado!");
                    break;
                case 2:
                    System.out.println("Digite o numero da conta: ");
                    nroconta = scan.nextInt();
                    System.out.println("Digite o valor do deposito: ");
                    valor = scan.nextDouble();
                    bco.depositoEmConta(nroconta, valor);
                    break;
                case 3:
                    System.out.println("Digite o numero da conta origem: ");
                    nroconta = scan.nextInt();
                    System.out.println("Digite o numero da conta destino: ");
                    nrocontadestino = scan.nextInt();
                    System.out.println("Digite o valor para transferir: ");
                    valor = scan.nextDouble();

                    bco.transferirEntreContas(nroconta, nrocontadestino, valor);
                    System.out.println("Transferência efetuada!");
                    break;

                case 4:
                    System.out.println("Digite o numero da conta: ");
                    nroconta = scan.nextInt();
                    System.out.println("Digite o valor do saque: ");
                    valor = scan.nextDouble();
                    bco.saqueEmConta(nroconta, valor);
                    break;
                case 5:
                    bco.imprimirListaContas();
                    break;
                case 6:
                    System.out.println("Digite o numero da conta para excluir: ");
                    nroconta = scan.nextInt();
                    bco.removeConta(nroconta);
                    break;
                case 7:
                    cont = 2;
                    System.out.println("Finalizou o sistema!");
                    break;
                default:
                    System.out.println("Favor escolher um numero das opções");

            }
        } while(cont == 1);
    }

 }


