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
    private int numeroVagas;
    private Date data;
    private String local;
    private int totalPessoas;
    private String infoPasseio;
    private boolean reservado = false;

    public Passeio()
    {
    }

    public Passeio(int id, int numeroVagas, Date data, String local,
            boolean reservado, int totalPessoas, String infoPasseio)
    {
        this.id = id;
        this.numeroVagas = numeroVagas;
        this.data = data;
        this.local = local;
        this.reservado = reservado;
        this.totalPessoas = totalPessoas;
        this.infoPasseio = infoPasseio;
    }

    public int getId() {
        return id;
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void somaPassageiros(int nPassageiros) {
        numeroVagas -= nPassageiros;
        totalPessoas += nPassageiros;
    }

    public void diminuiPassageiros(int nPassageiros) {
        numeroVagas += nPassageiros;
        totalPessoas -= nPassageiros;
    }

    public Date getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public int getTotalPessoas() {
        return totalPessoas;
    }

    public void setTotalPessoas(int totalPessoas) {
        this.totalPessoas = totalPessoas;
    }

    public String getInfoPasseio() {
        return infoPasseio;
    }

    public static List<Passeio> porId(int id)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Passeio where id=?");
        List l = q.setString(0, String.format("%s", id)).list();
        List<Passeio> ret = new ArrayList<Passeio>(l.size());
        for (Object o : l) ret.add((Passeio) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Passeio> porLocal(String local)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Passeio where local=?");
        List l = q.setString(0, String.format("%s", local)).list();
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

