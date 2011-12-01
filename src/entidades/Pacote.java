package entidades;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import orm.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Query;

public class Pacote 
{
    private int id;
    public String destino;
    private Date dataIda;
    private Date dataVolta;
    private double preco;
    private String infoDestino;
    private Set<Passeio> passeios;

    public Pacote()
    {
    }

    public Pacote(int id, String destino, int anoIda, int mesIda, int diaIda, 
           int anoVolta, int mesVolta, int diaVolta, double preco, String infoDestino)
    {
        this.id = id;
        this.destino = destino;
        this.dataIda = new Date(anoIda,mesIda,diaIda);
        this.dataVolta = new Date(anoVolta,mesVolta,diaVolta);
        this.preco = preco;
        this.infoDestino = infoDestino;
        this.passeios = new HashSet<Passeio>() ;
    }

    public Date getDataIda() {
        return dataIda;
    }

    public Date getDataVolta() {
        return dataVolta;
    }

    public double getPreco() {
        return preco;
    }

    public String getInfoDestino() {
        return infoDestino;
    }

    public Boolean addPasseio(Passeio objPasseio) {
        return passeios.add(objPasseio);
    }

    public Boolean removePasseio(Passeio objPasseio)
    {
        return true;
    }

    public String getDestino()
    {
        return destino;
    }

    public Set<Passeio> getPasseios() {
        return this.passeios;
    }

    public static List<Pacote> porDestino(String destino)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where destino=:destino");
        List l = q.setParameter("destino", destino).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Pacote> porId(int id)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where id=:id");
        List l = q.setParameter("id", id).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static int maiorId()
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("select max(id) from Pacote");
        return (Integer) q.list().get(0);
    }

    public static List<Pacote> porDataIda(Date dataIda)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where dataIda=:dataIda");
        List l = q.setParameter("dataIda", dataIda).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Pacote> porDataVolta(Date dataVolta)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where dataVolta=:dataVolta");
        List l = q.setParameter("dataVolta", dataVolta).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Pacote> porPreco(double preco)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where preco=:preco");
        List l = q.setParameter("preco", preco).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
        s.getTransaction().commit();
        return ret;
    }

    public static List<Pacote> porInfoDestino(String infoDestino)
    {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query q = s.createQuery("from Pacote where infoDestino=:infoDestino");
        List l = q.setParameter("infoDestino", infoDestino).list();
        List<Pacote> ret = new ArrayList<Pacote>(l.size());
        for (Object o : l) ret.add((Pacote) o);
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
    
    
    public static void main (String args[])
    {
    	System.out.println("okkk");
    	Set<String> s = new HashSet<String>();
    	s.add("telefone92083");
    	
    	Cliente c = new Cliente(0,7289711,"jao","1234","RGdoJao1", "CPF72817","jao@email.com", s);
    	c.salvar();
    	
    	Cliente c2 = new Cliente(0,7289711,"jao","1234","RGdoJao2", "CPF72817","jao@email.com", s);
    	c2.salvar();
    	
    	Pacote p = new Pacote(0,"SP",2010,12,10,2011,01,21,23.44,"San Pablo destino muito loco");
    	Passeio pass = new Passeio(0, "SP", 2010, 10, 14,"passeio muito longo", 5);
    	Passeio pass2 = new Passeio(0, "SP", 2010, 11, 07 ,"passeio muito curto", 5);
    	pass.salvar();
    	pass2.salvar();
    	
    	List<Passeio> lpass = Passeio.porLocal("SP");
    	
    	for (int i=0; i<lpass.size();i++){
    		
    		p.addPasseio( lpass.get(i)  );
    	}
    	
    	p.salvar();
    	
    	Pacote p2 = new Pacote(0,"RJ",2011,12,10,2012,01,21,43.29,"Rio de la Janero destino muito loco");
    	p2.addPasseio(pass);
    	p2.salvar();
    	
    	GuiaTuristico g = new GuiaTuristico(0, "NomeGuia", "telGuia123", "guia@email.com", "brasil", "portunhol");
    	g.salvar();
   		GuiaTuristico g2 = new GuiaTuristico(1, "Senhor guia", "05515", "a_oemail@10.com", "argentina", "portunhol");
  	 	g2.salvar();
    	List<GuiaTuristico> lg = GuiaTuristico.porLinguaFalada("portunhol");
    	for (GuiaTuristico gg : lg)
    	{
   		System.out.println("Nome dos Guias:   "+gg.getNome());
    	}

		PassagemMaritima passmar = new PassagemMaritima(47, "Santos", "Salvador", 2010, 2, 8, 15,"porto", "naufragos SA", 25);
		passmar.salvar();

		ReservaHotel hotel =  new ReservaHotel("hotel 5 estrelas", 25, 5, 2010, 10, 04,     2011, 2, 3, 2, 2, 29.90);
		hotel.salvar();
		PagamentoBoleto pagbol = new PagamentoBoleto(p,20,10,15);
		pagbol.salvar();

		Compra compra = new Compra(0, p, g, pagbol, passmar, hotel);
		compra.salvar();

		List<Compra> listacompra = Compra.porGuia(g);
		for(Compra cmp : listacompra)
		{
			System.out.println("Nome do Guia:   "+cmp.getGuia().getNome());
			System.out.println("Inf do Destino:   "+cmp.getPacote().getInfoDestino());
		}
    }
}
