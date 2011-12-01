package entidades;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class Pacote 
{
    private int id;
    public String destino;
    private Date dataIda;
    private Date dataVolta;
    private double preco;
    private String infoDestino;
    private Set<Passeio> passeios;

    public Pacote()
    {
    }

    public Pacote(int id, String destino, int anoIda, int mesIda, int diaIda, 
           int anoVolta, int mesVolta, int diaVolta, double preco, String infoDestino)
    {
        this.id = id;
        this.destino = destino;
        this.dataIda = new Date(anoIda,mesIda,diaIda);
        this.dataVolta = new Date(anoVolta,mesVolta,diaVolta);
        this.preco = preco;
        this.infoDestino = infoDestino;
        this.passeios = new HashSet<Passeio>() ;
    }

    public Date getDataIda() {
        return dataIda;
    }

    public Date getDataVolta() {
        return dataVolta;
    }

    public double getPreco() {
        return preco;
    }

    public String getInfoDestino() {
        return infoDestino;
    }

    public Boolean addPasseio(Passeio objPasseio) {
        return passeios.add(objPasseio);
    }

    public Boolean removePasseio(Passeio objPasseio)
    {
        return true;
    }

    public String getDestino()
    {
        return destino;
    }

    public Set<Passeio> getPasseios() {
        return this.passeios;
    }

    public static List<Pacote> porDestino(String destino)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where destino=:destino");
        List l = q.setParameter("destino", destino).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Pacote> porId(int id)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where id=:id");
        List l = q.setParameter("id", id).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static int maiorId()
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("select max(id) from Pacote");
        return (Integer) q.list().get(0);
    }

    public static List<Pacote> porDataIda(Date dataIda)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where dataIda=:dataIda");
        List l = q.setParameter("dataIda", dataIda).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Pacote> porDataVolta(Date dataVolta)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where dataVolta=:dataVolta");
        List l = q.setParameter("dataVolta", dataVolta).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Pacote> porPreco(double preco)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where preco=:preco");
        List l = q.setParameter("preco", preco).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Pacote> porInfoDestino(String infoDestino)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where infoDestino=:infoDestino");
        List l = q.setParameter("infoDestino", infoDestino).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
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
