package entidades;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import orm.util.HibernateUtil;

public class PagamentoCartao extends Pagamento{
	
	private int numeroCartao;
	private String proprietario;
	private String bandeira;
	private int codigoSeguranca;
	private Date dataVencimento;
	
	///// Construtor Basico ////
	PagamentoCartao(Pacote pacote,double preco,int codigoPagamento,int numeroCartao,
			String proprietario,String bandeira,int codigoSeguranca,Date dataVencimento)
	{
		super( pacote, preco, codigoPagamento);
		this.numeroCartao = numeroCartao;
		this.bandeira = bandeira;
		this.proprietario = proprietario;
		this.codigoSeguranca = codigoSeguranca;
		this.dataVencimento = dataVencimento;
	}
	//////// GETTERS ////////////
	public int getNumeroCartao() {
		return numeroCartao;
	}

	public String getProprietario() {
		return proprietario;
	}

	public String getBandeira() {
		return bandeira;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	public boolean pagar()
	{
		//realiza pagamento cartao no sistema externo
		return true;
	}

	public static List<PagamentoCartao> porCodigoPagamento(int codigoPagamento)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where codigoPagamento=:codigoPagamento");
	    List l = q.setParameter("codigoPagamento", codigoPagamento).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoCartao> porPreco(double preco)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where preco=:preco");
	    List l = q.setParameter("preco", preco).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoCartao> porEstado(boolean estado)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where estado=:estado");
	    List l = q.setParameter("estado", estado).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoCartao> porPacote(Pacote pacote)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where pacote=:pacote");
	    List l = q.setParameter("pacote", pacote).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoCartao> porNumeroCartao(int numeroCartao)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where numeroCartao=:numeroCartao");
	    List l = q.setParameter("numeroCartao", numeroCartao).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoCartao> porProprietario(String proprietario)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where proprietario=:proprietario");
	    List l = q.setParameter("proprietario", proprietario).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoCartao> porBandeira(String bandeira)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where bandeira=:bandeira");
	    List l = q.setParameter("bandeira", bandeira).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoCartao> porCodigoSeguranca(int codigoSeguranca)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where codigoSeguranca=:codigoSeguranca");
	    List l = q.setParameter("codigoSeguranca", codigoSeguranca).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoCartao> porDataVencimento(Date dataVencimento)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoCartao where dataVencimento=:dataVencimento");
	    List l = q.setParameter("dataVencimento", dataVencimento).list();
	    List<PagamentoCartao> ret = new ArrayList<PagamentoCartao>(l.size());
	    for (Object o : l) ret.add((PagamentoCartao) o);
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
