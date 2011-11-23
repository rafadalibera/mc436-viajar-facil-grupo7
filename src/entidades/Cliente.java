package entidades;

import java.util.Vector;

class Cliente {
    private int id;
    private int numero_cartao;
    private String nome;
    private String senha;
    private String rg;
    private String cpf;
    private String email;
    private Vector<String> telefones;

    public Cliente(int id, int numero_cartao, String nome, String senha,
                   String rg, String cpf, String email,
                   Vector<String> telefones)
    {
        this.id = id;
        this.numero_cartao = numero_cartao;
        this.nome = nome;
        this.senha = senha;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefones = telefones;
    }

    /* Retorna o número de identificação deste cliente. */
    int getId()
    {
        return this.id;
    }

    /* Retorna o número do cartão deste cliente. */
    int getNumeroCartao()
    {
         return this.numero_cartao;
    }

    /* Retorna o nome deste cliente. */
    String getNome()
    {
        return this.nome;
    }

    /* Retorna a senha deste cliente. */
    String getSenha()
    {
        return this.senha;
    }

    /* Retorna o rg deste cliente. */
    String getRg()
    {
        return this.rg;
    }

    /* Retorna o cpf deste cliente. */
    String getCpf()
    {
        return this.cpf;
    }

    /* Retorna o email deste cliente. */
    String getEmail()
    {
        return this.email;
    }

    /* Retorna o telefone deste cliente. */
    getTelefones()
    {
        return this.telefones;
    }
}
