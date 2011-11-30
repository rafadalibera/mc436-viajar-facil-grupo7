package entidades;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import orm.util.HibernateUtil;

public class GuiaTuristico
{
    private int id;
    private String nome;
    private int telefone;
    private String email;
    private String localidade;
    private String lingua_falada;

    public GuiaTuristico (int id, String nome, int telefone, String email, String localidade, String lingua_falada)
    {
    	this.id = id;
    	this.nome = nome;
    	this.telefone = telefone;
    	this.email =  email;
    	this.localidade = localidade;
    	this.lingua_falada = lingua_falada;
    }

    int getId ()
    {
    	return this.id;
    }

    String getNome()
    {
    	return this.nome;
    }

    int getTelefone ()
    {
    	return this.telefone;
    }

    String getEmail()
    {
    	return this.email;
    }

    String getLocalidade()
    {
    	return this.localidade;
    }

    String getLingua()
    {
    	return this.lingua_falada;
    }

    // Começo do código autogerado
    // Mon Nov 28 14:45:16 2011
    public static List<GuiaTuristico> porId(int id)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from GuiaTuristico where id=:id");
        List l = q.setParameter("id", id).list();
        List<GuiaTuristico> ret = new ArrayList<GuiaTuristico>(l.size());
        for (Object o : l) ret.add((GuiaTuristico) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<GuiaTuristico> porLinguaFalada(String lingua_falada)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from GuiaTuristico where lingua_falada=:lingua_falada");
        List l = q.setParameter("lingua_falada", lingua_falada).list();
        List<GuiaTuristico> ret = new ArrayList<GuiaTuristico>(l.size());
        for (Object o : l) ret.add((GuiaTuristico) o);
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
