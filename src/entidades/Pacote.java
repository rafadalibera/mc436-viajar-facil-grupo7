package entidades;

import java.util.Date;
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

    Pacote(int id, String destino, Date dataIda, Date dataVolta, double preco, String infoDestino)
    {
        this.id = id;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
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

    public Set<Passeio> getPasseios() {
        return this.passeios;
    }

	// Começo do código autogerado
    // Mon Nov 28 14:07:31 2011
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

    public void salvar()
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(this);
        s.getTransaction().commit();
    }
// Fim do código autogerado
}
