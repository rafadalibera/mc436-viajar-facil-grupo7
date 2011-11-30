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
    private String telefone;
    private String email;
    private String localidade;
    private String lingua_falada;

    public GuiaTuristico (int id, String nome, String telefone, String email, String localidade, String lingua_falada)
    {
    	this.id = id;
    	this.nome = nome;
    	this.telefone = telefone;
    	this.email =  email;
    	this.localidade = localidade;
    	this.lingua_falada = lingua_falada;
    }

    public int getId ()
    {
    	return this.id;
    }

    public String getNome()
    {
    	return this.nome;
    }

    public String getTelefone ()
    {
    	return this.telefone;
    }

    public String getEmail()
    {
    	return this.email;
    }

    public String getLocalidade()
    {
    	return this.localidade;
    }

    public String getLingua()
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

	public static int maiorId()
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("select max(id) from GuiaTuristico");
		return (Integer) q.list().get(0);
	}

	public static List<GuiaTuristico> porNome(int nome)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from GuiaTuristico where nome=:nome");
		List l = q.setParameter("nome", nome).list();
		List<GuiaTuristico> ret = new ArrayList<GuiaTuristico>(l.size());
		for (Object o : l) ret.add((GuiaTuristico) o);
		s.getTransaction().commit();
		return ret;
	}

	public static List<GuiaTuristico> porTelefone(int telefone)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from GuiaTuristico where telefone=:telefone");
		List l = q.setParameter("telefone", telefone).list();
		List<GuiaTuristico> ret = new ArrayList<GuiaTuristico>(l.size());
		for (Object o : l) ret.add((GuiaTuristico) o);
		s.getTransaction().commit();
		return ret;
	}

	public static List<GuiaTuristico> porEmail(String email)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from GuiaTuristico where email=:email");
		List l = q.setParameter("email", email).list();
		List<GuiaTuristico> ret = new ArrayList<GuiaTuristico>(l.size());
		for (Object o : l) ret.add((GuiaTuristico) o);
		s.getTransaction().commit();
		return ret;
	}

	public static List<GuiaTuristico> porLocalidade(String localidade)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from GuiaTuristico where localidade=:localidade");
		List l = q.setParameter("localidade", localidade).list();
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
