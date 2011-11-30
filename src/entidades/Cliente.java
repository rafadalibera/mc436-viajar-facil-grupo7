package entidades;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import orm.util.HibernateUtil;

public class Cliente {
    private int id;
    private int numero_cartao;
    private String nome;
    private String senha;
    private String rg;
    private String cpf;
    private String email;
    private Set<String> telefones;

    public Cliente()
    {
    }

    public Cliente(int id, int numero_cartao, String nome, String senha,
                   String rg, String cpf, String email,
                   Set<String> telefones)
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

    // Começo do código autogerado
    // Wed Nov 30 11:57:16 2011
    public static List<Cliente> porId(int id)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Cliente where id=:id");
        List l = q.setParameter("id", id).list();
        List<Cliente> ret = new ArrayList<Cliente>(l.size());
        for (Object o : l) ret.add((Cliente) o);
        s.getTransaction().commit();
        return ret;
    }

    public static int maiorId()
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("select max(id) from Cliente");
        return (Integer) q.list().get(0);
    }

    public static List<Cliente> porEmail(String email)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Cliente where email=:email");
        List l = q.setParameter("email", email).list();
        List<Cliente> ret = new ArrayList<Cliente>(l.size());
        for (Object o : l) ret.add((Cliente) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Cliente> porNome(String nome)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Cliente where nome=:nome");
        List l = q.setParameter("nome", nome).list();
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

    // Fim do código autogerado
}
