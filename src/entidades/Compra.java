package entidades;

import java.util.List;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Query;

import orm.util.HibernateUtil;

public class Compra 
{
	private int id;
	private Pacote pacote;
	private GuiaTuristico guia;
	private Pagamento pagamento;
	private List<Passagem> ListaPassagem;
	private ReservaHotel hotel;
	
	// Construtor basico //
	Compra(int id, Pacote pacote, GuiaTuristico guia, Pagamento pagamento, 
			List<Passeio> passeioAdicional, List<Passagem> ListaPassagem, ReservaHotel hotel)
	{
		this.id = id;
		this.pacote = pacote;
		this.guia = guia;
		this.pagamento = pagamento;
		this.passeios = passeioAdicional;
		this.ListaPassagem = ListaPassagem;
		this.hotel = hotel;
	}

	////////////////// GETTERS ///////////////////////////
	public int getId() {
		return id;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public GuiaTuristico getGuia() {
		return guia;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}


	public List<Passagem> getListaPassagem() {
		return ListaPassagem;
	}

	public ReservaHotel getHotel() {
		return hotel;
	}


	public static List<Compra> porId(int id)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from Compra where id=:id");
		List l = q.setParameter("id", id).list();
		List<Compra> ret = new ArrayList<Compra>(l.size());
		for (Object o : l) ret.add((Compra) o);
		s.getTransaction().commit();
		return ret;
	}

	public static int maiorId()
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("select max(id) from Compra");
		return (Integer) q.list().get(0);
	}

	public static List<Compra> porPacote(Pacote pacote)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from Compra where pacote=:pacote");
		List l = q.setParameter("pacote", pacote).list();
		List<Compra> ret = new ArrayList<Compra>(l.size());
		for (Object o : l) ret.add((Compra) o);
		s.getTransaction().commit();
		return ret;
	}

	public static List<Compra> porGuia(GuiaTuristico guia)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from Compra where guia=:guia");
		List l = q.setParameter("guia", guia).list();
		List<Compra> ret = new ArrayList<Compra>(l.size());
		for (Object o : l) ret.add((Compra) o);
		s.getTransaction().commit();
		return ret;
	}

	public static List<Compra> porPagamento(Pagamento pagamento)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from Compra where pagamento=:pagamento");
		List l = q.setParameter("pagamento", pagamento).list();
		List<Compra> ret = new ArrayList<Compra>(l.size());
		for (Object o : l) ret.add((Compra) o);
		s.getTransaction().commit();
		return ret;
	}

	public static List<Compra> porHotel(ReservaHotel hotel)
	{
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		Query q = s.createQuery("from Compra where hotel=:hotel");
		List l = q.setParameter("hotel", hotel).list();
		List<Compra> ret = new ArrayList<Compra>(l.size());
		for (Object o : l) ret.add((Compra) o);
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
