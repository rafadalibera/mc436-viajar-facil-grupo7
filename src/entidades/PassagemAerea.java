package entidades; 

import entidades.Passagem;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import orm.util.HibernateUtil;

public class PassagemAerea extends Passagem
{
	private String aeroporto;
	private int portao_embarque;
	private String companhia_aerea;
	private String poltrona;
	
	public PassagemAerea (int id, String destino, String origem, int ano, 
			      int mes, int dia, int preco, String aeroporto, 
                              int portao_embarque, String companhia_aerea,
			      String poltrona)
	{
		super(id, destino, origem, ano, mes, dia, preco);
		
		this.aeroporto = aeroporto;
		this.portao_embarque = portao_embarque;
		this.companhia_aerea = companhia_aerea;
		this.poltrona = poltrona;
	}
	
	String getAeroport()
	{
		return this.aeroporto;
	}
	
	int getPortaoEmbarque()
	{
		return this.portao_embarque;
	}
	
	String getCompanhiaAerea()
	{
		return this.companhia_aerea;
	}
	
	String getPoltrona()
	{
		return this.poltrona;
	}
	

	public static List<PassagemAerea> porId(int id)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where id=:id");
	    List l = q.setParameter("id", id).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemAerea> porDestino(String destino)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where destino=:destino");
	    List l = q.setParameter("destino", destino).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemAerea> porOrigem(String origem)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where origem=:origem");
	    List l = q.setParameter("origem", origem).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemAerea> porData(int data)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where data=:data");
	    List l = q.setParameter("data", data).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemAerea> porPreco(double preco)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where preco=:preco");
	    List l = q.setParameter("preco", preco).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemAerea> porAeroporto(String aeroporto)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where aeroporto=:aeroporto");
	    List l = q.setParameter("aeroporto", aeroporto).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemAerea> porPortaoEmbarque(int portao_embarque)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where portao_embarque=:portao_embarque");
	    List l = q.setParameter("portao_embarque", portao_embarque).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemAerea> porCompanhiaAerea(String companhia_aerea)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where companhia_aerea=:companhia_aerea");
	    List l = q.setParameter("companhia_aerea", companhia_aerea).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PassagemAerea> porPoltrona(String poltrona)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PassagemAerea where poltrona=:poltrona");
	    List l = q.setParameter("poltrona", poltrona).list();
	    List<PassagemAerea> ret = new ArrayList<PassagemAerea>(l.size());
	    for (Object o : l) ret.add((PassagemAerea) o);
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
