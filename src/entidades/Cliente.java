package entidades;

import java.util.Vector;

class Cliente {
    int id;
    int numero_cartao;
    String nome;
    String senha;
    String rg;
    String cpf;
    String email;
    Vector<String> telefones;

    public Cliente(int id, int numero_cartao, String nome, String senha,
                   String rg, String cpf, String email,
                   Vector<String> telefones) {
        this.id = id;
        this.numero_cartao = numero_cartao;
        this.nome = nome;
        this.senha = senha;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefones = telefones;
    }

    public static void main(String[] args) {
        return;
    }
}
