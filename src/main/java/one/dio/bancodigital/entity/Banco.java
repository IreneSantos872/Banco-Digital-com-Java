package one.dio.bancodigital.entity;

import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimirListaContas(){

        System.out.println(this.contas);
    }
}
