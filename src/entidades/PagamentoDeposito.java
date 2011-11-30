package entidades;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import orm.util.HibernateUtil;

public class PagamentoDeposito extends Pagamento {
	private String banco;
	private int agencia;
	private int conta;	
	
	//Construtor Basico //
	PagamentoDeposito(Pacote pacote,double preco,int codigoPagamento,String banco,
			          int agencia, int conta)
	{
		super(pacote,preco,codigoPagamento);
		this.agencia = agencia;
		this.conta = conta;
		this.banco = banco;
	}

	///////////////// GETTERS ///////////////////////
	public String getBanco() {
		return banco;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}
	
	public boolean pagar()
	{
		//paga deposito no sistema externo
		return true;
	}

	public static List<PagamentoDeposito> porCodigoPagamento(int codigoPagamento)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoDeposito where codigoPagamento=:codigoPagamento");
	    List l = q.setParameter("codigoPagamento", codigoPagamento).list();
	    List<PagamentoDeposito> ret = new ArrayList<PagamentoDeposito>(l.size());
	    for (Object o : l) ret.add((PagamentoDeposito) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoDeposito> porPreco(double preco)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoDeposito where preco=:preco");
	    List l = q.setParameter("preco", preco).list();
	    List<PagamentoDeposito> ret = new ArrayList<PagamentoDeposito>(l.size());
	    for (Object o : l) ret.add((PagamentoDeposito) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoDeposito> porEstado(boolean estado)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoDeposito where estado=:estado");
	    List l = q.setParameter("estado", estado).list();
	    List<PagamentoDeposito> ret = new ArrayList<PagamentoDeposito>(l.size());
	    for (Object o : l) ret.add((PagamentoDeposito) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoDeposito> porPacote(Pacote pacote)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoDeposito where pacote=:pacote");
	    List l = q.setParameter("pacote", pacote).list();
	    List<PagamentoDeposito> ret = new ArrayList<PagamentoDeposito>(l.size());
	    for (Object o : l) ret.add((PagamentoDeposito) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoDeposito> porBanco(String banco)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoDeposito where banco=:banco");
	    List l = q.setParameter("banco", banco).list();
	    List<PagamentoDeposito> ret = new ArrayList<PagamentoDeposito>(l.size());
	    for (Object o : l) ret.add((PagamentoDeposito) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoDeposito> porAgencia(int agencia)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoDeposito where agencia=:agencia");
	    List l = q.setParameter("agencia", agencia).list();
	    List<PagamentoDeposito> ret = new ArrayList<PagamentoDeposito>(l.size());
	    for (Object o : l) ret.add((PagamentoDeposito) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoDeposito> porConta(int conta)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoDeposito where conta=:conta");
	    List l = q.setParameter("conta", conta).list();
	    List<PagamentoDeposito> ret = new ArrayList<PagamentoDeposito>(l.size());
	    for (Object o : l) ret.add((PagamentoDeposito) o);
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
