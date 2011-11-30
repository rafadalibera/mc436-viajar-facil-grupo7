package entidades;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import orm.util.HibernateUtil;


public class Passeio
{
    private int id;
    private double preco;
    private Date data;
    private String local;
    private String infoPasseio;
    private boolean habilitado;

    public Passeio()
    {
    }

    public Passeio(int id, String local, int ano, int mes, int dia,
                   String infoPasseio, double preco)
    {
        this.id = id;
        this.local = local;
        this.habilitado = habilitado;
        this.infoPasseio = infoPasseio;
		this.preco = preco;
		this.habilitado = false;
		this.data = new Date(ano,mes,dia);
    }

    public int getId() {
        return id;
    }

    public double getpreco() {
        return preco;
    }

    public Date getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public boolean checkHabilitado() {
        return habilitado;
    }

    public void habilita() {
        this.habilitado = true;
    }
    

    public String getInfoPasseio() {
        return infoPasseio;
    }

    public static List<Passeio> porId(int id)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Passeio where id=:id");
        List l = q.setParameter("id", id).list();
        List<Passeio> ret = new ArrayList<Passeio>(l.size());
        for (Object o : l) ret.add((Passeio) o);
        s.getTransaction().commit();
        return ret;
    }

    public static int maiorId()
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("select max(id) from Passeio");
        return (Integer) q.list().get(0);
    }

    public static List<Passeio> porPreco(double preco)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Passeio where preco=:preco");
        List l = q.setParameter("preco", preco).list();
        List<Passeio> ret = new ArrayList<Passeio>(l.size());
        for (Object o : l) ret.add((Passeio) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Passeio> porData(Date data)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Passeio where data=:data");
        List l = q.setParameter("data", data).list();
        List<Passeio> ret = new ArrayList<Passeio>(l.size());
        for (Object o : l) ret.add((Passeio) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Passeio> porLocal(String local)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Passeio where local=:local");
        List l = q.setParameter("local", local).list();
        List<Passeio> ret = new ArrayList<Passeio>(l.size());
        for (Object o : l) ret.add((Passeio) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Passeio> porInfoPasseio(String infoPasseio)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Passeio where infoPasseio=:infoPasseio");
        List l = q.setParameter("infoPasseio", infoPasseio).list();
        List<Passeio> ret = new ArrayList<Passeio>(l.size());
        for (Object o : l) ret.add((Passeio) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Passeio> porHabilitado(boolean habilitado)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Passeio where habilitado=:habilitado");
        List l = q.setParameter("habilitado", habilitado).list();
        List<Passeio> ret = new ArrayList<Passeio>(l.size());
        for (Object o : l) ret.add((Passeio) o);
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


}

