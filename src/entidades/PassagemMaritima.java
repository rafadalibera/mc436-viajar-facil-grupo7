package entidades;

import entidades.Passagem;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import orm.util.HibernateUtil;

public class PassagemMaritima extends Passagem 
{
	private String porto;
	private String companhia_maritima;
	private int cabine;
	
	public PassagemMaritima (int id, String destino, String origem, int ano, int mes, int dia, int preco, 
                                 String porto, String companhia_maritima, int cabine)
	{
		super(id, destino, origem, ano, mes, dia, preco);
		
		this.porto = porto;
		this.companhia_maritima = companhia_maritima;
		this.cabine = cabine;
		
	}
	
	String getPorto()
	{
		return this.porto;
	}
	
	String getCompanhiaMaritima()
	{
		return this.companhia_maritima;
	}
	
	int getCabine()
	{
		return this.cabine;
	}

	public static List<PassagemMaritima> porId(int id)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemMaritima where id=:id");
	    List l = q.setParameter("id", id).list();
	    List<PassagemMaritima> ret = new ArrayList<PassagemMaritima>(l.size());
	    for (Object o : l) ret.add((PassagemMaritima) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemMaritima> porDestino(String destino)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemMaritima where destino=:destino");
	    List l = q.setParameter("destino", destino).list();
	    List<PassagemMaritima> ret = new ArrayList<PassagemMaritima>(l.size());
	    for (Object o : l) ret.add((PassagemMaritima) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemMaritima> porOrigem(String origem)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemMaritima where origem=:origem");
	    List l = q.setParameter("origem", origem).list();
	    List<PassagemMaritima> ret = new ArrayList<PassagemMaritima>(l.size());
	    for (Object o : l) ret.add((PassagemMaritima) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemMaritima> porData(int data)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemMaritima where data=:data");
	    List l = q.setParameter("data", data).list();
	    List<PassagemMaritima> ret = new ArrayList<PassagemMaritima>(l.size());
	    for (Object o : l) ret.add((PassagemMaritima) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemMaritima> porPreco(double preco)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemMaritima where preco=:preco");
	    List l = q.setParameter("preco", preco).list();
	    List<PassagemMaritima> ret = new ArrayList<PassagemMaritima>(l.size());
	    for (Object o : l) ret.add((PassagemMaritima) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemMaritima> porPorto(String porto)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemMaritima where porto=:porto");
	    List l = q.setParameter("porto", porto).list();
	    List<PassagemMaritima> ret = new ArrayList<PassagemMaritima>(l.size());
	    for (Object o : l) ret.add((PassagemMaritima) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemMaritima> porCompanhiaMaritima(String companhia_maritima)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemMaritima where companhia_maritima=:companhia_maritima");
	    List l = q.setParameter("companhia_maritima", companhia_maritima).list();
	    List<PassagemMaritima> ret = new ArrayList<PassagemMaritima>(l.size());
	    for (Object o : l) ret.add((PassagemMaritima) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemMaritima> porCabine(String cabine)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemMaritima where cabine=:cabine");
	    List l = q.setParameter("cabine", cabine).list();
	    List<PassagemMaritima> ret = new ArrayList<PassagemMaritima>(l.size());
	    for (Object o : l) ret.add((PassagemMaritima) o);
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
