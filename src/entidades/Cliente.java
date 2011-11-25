package entidades;

import java.util.Vector;

public class Cliente {
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
    public int getId()
    {
        return this.id;
    }

    /* Retorna o número do cartão deste cliente. */
    public int getNumeroCartao()
    {
         return this.numero_cartao;
    }

    /* Retorna o nome deste cliente. */
    public String getNome()
    {
        return this.nome;
    }

    /* Retorna a senha deste cliente. */
    public String getSenha()
    {
        return this.senha;
    }

    /* Retorna o rg deste cliente. */
    public String getRg()
    {
        return this.rg;
    }

    /* Retorna o cpf deste cliente. */
    public String getCpf()
    {
        return this.cpf;
    }

    /* Retorna o email deste cliente. */
    public String getEmail()
    {
        return this.email;
    }

    /* Retorna o telefone deste cliente. */
    public Set<String> getTelefones()
    {
        return this.telefones;
    }


public static List<Cliente> porNome(String nome)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from Cliente where nome=?");
    List l = q.setString(0, nome).list();
    List<Cliente> ret = new ArrayList<Cliente>(l.size());
    for (Object o : l) ret.add((Cliente) o);
    s.getTransaction().commit();
    return ret;
}

public void salvar()
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    s.save(this);
    s.getTransaction().commit();
}

public static List<Cliente> porEmail(String email)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from Cliente where email=?");
    List l = q.setString(0, email).list();
    List<Cliente> ret = new ArrayList<Cliente>(l.size());
    for (Object o : l) ret.add((Cliente) o);
    s.getTransaction().commit();
    return ret;
}





}
