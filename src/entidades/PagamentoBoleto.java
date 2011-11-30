package entidades;


public class PagamentoBoleto extends Pagamento{
	
	private int numBoleto;
	
	
	PagamentoBoleto(Pacote pacote,double preco,int codigoPagamento, int numBoleto)
	{

		super(pacote,preco,codigoPagamento);
		this.numBoleto = numBoleto;	

	}
	

	public int getnumBoleto()
	{
		return numBoleto;
	}

	public boolean pagar()
	{
		//paga boleto no sistema externo
		return true;
	}

public static List<PagamentoBoleto> porCodigoPagamento(int codigoPagamento)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from PagamentoBoleto where codigoPagamento=:codigoPagamento");
    List l = q.setParameter("codigoPagamento", codigoPagamento).list();
    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
    for (Object o : l) ret.add((PagamentoBoleto) o);
    s.getTransaction().commit();
    return ret;
}

public static List<PagamentoBoleto> porPreco(double preco)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from PagamentoBoleto where preco=:preco");
    List l = q.setParameter("preco", preco).list();
    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
    for (Object o : l) ret.add((PagamentoBoleto) o);
    s.getTransaction().commit();
    return ret;
}

public static List<PagamentoBoleto> porEstado(boolean estado)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from PagamentoBoleto where estado=:estado");
    List l = q.setParameter("estado", estado).list();
    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
    for (Object o : l) ret.add((PagamentoBoleto) o);
    s.getTransaction().commit();
    return ret;
}

public static List<PagamentoBoleto> porPacote(Pacote pacote)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from PagamentoBoleto where pacote=:pacote");
    List l = q.setParameter("pacote", pacote).list();
    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
    for (Object o : l) ret.add((PagamentoBoleto) o);
    s.getTransaction().commit();
    return ret;
}

public static List<PagamentoBoleto> porNumBoleto(int numBoleto)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from PagamentoBoleto where numBoleto=:numBoleto");
    List l = q.setParameter("numBoleto", numBoleto).list();
    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
    for (Object o : l) ret.add((PagamentoBoleto) o);
    s.getTransaction().commit();
    return ret;
}


	public static List<PagamentoBoleto> porCodigoPagamento(int codigoPagamento)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoBoleto where codigoPagamento=:codigoPagamento");
	    List l = q.setParameter("codigoPagamento", codigoPagamento).list();
	    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
	    for (Object o : l) ret.add((PagamentoBoleto) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoBoleto> porPreco(double preco)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoBoleto where preco=:preco");
	    List l = q.setParameter("preco", preco).list();
	    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
	    for (Object o : l) ret.add((PagamentoBoleto) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoBoleto> porEstado(boolean estado)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoBoleto where estado=:estado");
	    List l = q.setParameter("estado", estado).list();
	    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
	    for (Object o : l) ret.add((PagamentoBoleto) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoBoleto> porPacote(Pacote pacote)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoBoleto where pacote=:pacote");
	    List l = q.setParameter("pacote", pacote).list();
	    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
	    for (Object o : l) ret.add((PagamentoBoleto) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<PagamentoBoleto> porNumBoleto(int numBoleto)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from PagamentoBoleto where numBoleto=:numBoleto");
	    List l = q.setParameter("numBoleto", numBoleto).list();
	    List<PagamentoBoleto> ret = new ArrayList<PagamentoBoleto>(l.size());
	    for (Object o : l) ret.add((PagamentoBoleto) o);
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
