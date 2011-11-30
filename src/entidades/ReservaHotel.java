package entidades;

import java.util.Date;

public class ReservaHotel 
{
	private String hotel;
	private int quarto;
	private int numeroEstrelas;
	private Date dataEntrada;
	private Date dataSaida;
	private int hospedesQuarto;
	private int id;
	private double preco;
	
	// Construtor basico //
	ReservaHotel(String hotel, int quarto, int numeroEstrelas, int anoEntrada, int mesEntrada, int diaEntrada,
		     int anoSaida, int mesSaida, int diaSaida, int hospedesQuarto, int id, double preco)
	{
		this.hotel = hotel;
		this.quarto = quarto;
		this.numeroEstrelas = numeroEstrelas;
		this.dataEntrada = new Date(anoEntrado, mesEntrada, diaEntrada);
		this.dataSaida = new Date(anoSaida, mesSaida, diaSaida);
		this.hospedesQuarto = hospedesQuarto;
		this.preco = preco;
		this.id = id;		
	}
	////////////////////////////////GETTERS////////////////////////////////////
					
	public String getHotel() {
		return hotel;
	}

	public int getQuarto() {
		return quarto;
	}

	public int getNumeroEstrelas() {
		return numeroEstrelas;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public int getHospedesQuarto() {
		return hospedesQuarto;
	}

	public int getId() {
		return id;
	}

	public double getPreco() {
		return preco;
	}
	
	// Metodo estatico que obteria uma reserva com o sistema externo de reserva de hoteis //
/*	static public int obterReservaHotel(String hotel, int numeroEstrelas, Date dataEntrada, 
			                            Date dataSaida, int hospedesQuarto, double preco)
	{
		int id = sistemaExterno.fazReserva(String hotel, int numeroEstrelas, Date dataEntrada,Date dataSaida, int hospedesQuarto, double preco);
		return id;
	}
*/

	public static List<ReservaHotel> porHotel(String hotel)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from ReservaHotel where hotel=:hotel");
	    List l = q.setParameter("hotel", hotel).list();
	    List<ReservaHotel> ret = new ArrayList<ReservaHotel>(l.size());
	    for (Object o : l) ret.add((ReservaHotel) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<ReservaHotel> porQuarto(int quarto)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from ReservaHotel where quarto=:quarto");
	    List l = q.setParameter("quarto", quarto).list();
	    List<ReservaHotel> ret = new ArrayList<ReservaHotel>(l.size());
	    for (Object o : l) ret.add((ReservaHotel) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<ReservaHotel> porNumeroEstrelas(int numeroEstrelas)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from ReservaHotel where numeroEstrelas=:numeroEstrelas");
	    List l = q.setParameter("numeroEstrelas", numeroEstrelas).list();
	    List<ReservaHotel> ret = new ArrayList<ReservaHotel>(l.size());
	    for (Object o : l) ret.add((ReservaHotel) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<ReservaHotel> porDataEntrada(Date dataEntrada)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from ReservaHotel where dataEntrada=:dataEntrada");
	    List l = q.setParameter("dataEntrada", dataEntrada).list();
	    List<ReservaHotel> ret = new ArrayList<ReservaHotel>(l.size());
	    for (Object o : l) ret.add((ReservaHotel) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<ReservaHotel> porDataSaida(Date dataSaida)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from ReservaHotel where dataSaida=:dataSaida");
	    List l = q.setParameter("dataSaida", dataSaida).list();
	    List<ReservaHotel> ret = new ArrayList<ReservaHotel>(l.size());
	    for (Object o : l) ret.add((ReservaHotel) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<ReservaHotel> porHospedesQuarto(int hospedesQuarto)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from ReservaHotel where hospedesQuarto=:hospedesQuarto");
	    List l = q.setParameter("hospedesQuarto", hospedesQuarto).list();
	    List<ReservaHotel> ret = new ArrayList<ReservaHotel>(l.size());
	    for (Object o : l) ret.add((ReservaHotel) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<ReservaHotel> porId(int id)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from ReservaHotel where id=:id");
	    List l = q.setParameter("id", id).list();
	    List<ReservaHotel> ret = new ArrayList<ReservaHotel>(l.size());
	    for (Object o : l) ret.add((ReservaHotel) o);
	    s.getTransaction().commit();
	    return ret;
	}

	public static List<ReservaHotel> porPreco(double preco)
	{
	    Session s = HibernateUtil.getSessionFactory().getCurrentSession();
	    s.beginTransaction();
	    Query q = s.createQuery("from ReservaHotel where preco=:preco");
	    List l = q.setParameter("preco", preco).list();
	    List<ReservaHotel> ret = new ArrayList<ReservaHotel>(l.size());
	    for (Object o : l) ret.add((ReservaHotel) o);
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
