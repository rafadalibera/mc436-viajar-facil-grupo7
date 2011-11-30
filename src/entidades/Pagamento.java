package entidades;

public class Pagamento 
{
	private Pacote pacote;
	private double preco;
	private boolean estado; 
	private int codigoPagamento;
	
	///// Construtor basico 
	Pagamento (Pacote pacote,double preco,int codigoPagamento)
	{
		this.pacote = pacote;
		this.preco = preco;
		this.codigoPagamento = codigoPagamento;
		this.estado = false;   //seta estado para falso, jah que o pagamento nao estah quitado
	}
	
	public boolean obterStatus()
	{
		return estado;
	}
	
	public boolean quitar()
	{
		if (estado == false)
		{
			estado = true;
			return true;
		}
		else return false;
	}

	/////////// GETTERS ////////
	public Pacote getPacote() {
		return pacote;
	}

	public double getPreco() {
		return preco;
	}

	public int getCodigoPagamento() {
		return codigoPagamento;
	}


public static List<Pagamento> porCodigoPagamento(int codigoPagamento)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from Pagamento where codigoPagamento=:codigoPagamento");
    List l = q.setParameter("codigoPagamento", codigoPagamento).list();
    List<Pagamento> ret = new ArrayList<Pagamento>(l.size());
    for (Object o : l) ret.add((Pagamento) o);
    s.getTransaction().commit();
    return ret;
}

public static List<Pagamento> porPreco(double preco)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from Pagamento where preco=:preco");
    List l = q.setParameter("preco", preco).list();
    List<Pagamento> ret = new ArrayList<Pagamento>(l.size());
    for (Object o : l) ret.add((Pagamento) o);
    s.getTransaction().commit();
    return ret;
}

public static List<Pagamento> porEstado(boolean estado)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from Pagamento where estado=:estado");
    List l = q.setParameter("estado", estado).list();
    List<Pagamento> ret = new ArrayList<Pagamento>(l.size());
    for (Object o : l) ret.add((Pagamento) o);
    s.getTransaction().commit();
    return ret;
}

public static List<Pagamento> porPacote(Pacote pacote)
{
    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    s.beginTransaction();
    Query q = s.createQuery("from Pagamento where pacote=:pacote");
    List l = q.setParameter("pacote", pacote).list();
    List<Pagamento> ret = new ArrayList<Pagamento>(l.size());
    for (Object o : l) ret.add((Pagamento) o);
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

