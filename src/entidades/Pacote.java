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

    Pacote(int id, String destino, int anoIda, int mesIda, int diaIda, 
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
    	Passeio pass = new Passeio(1,"SP",2010,12,10,false,"passeio no parque",99.99);
    	Passeio pass2 = new Passeio(2,"SP",2012,12,10,false,"passeio no lago",98.99);
    	pass.salvar();
    	pass2.salvar();
    	
    	List<Passeio> lpass = Passeio.porLocal("SP");
    	
    	for (int i=0; i<lpass.size();i++){
    		
    		p.addPasseio( lpass.get(i)  );
    	}
    	
    	p.salvar();
    	
    	//Pacote p2 = new Pacote(0,"RJ",2011,12,10,2012,01,21,43.29,"Rio de la Janero destino muito loco");
    	//p2.addPasseio(lpass.get(0));
    	//p2.salvar();
    	
    //	GuiaTuristico g = new GuiaTuristico(0, "Guia", 05515, "email@10.com", "brasil", "portunhol");
    //	g.salvar();
   //	GuiaTuristico g2 = new GuiaTuristico(1, "Senhor guia", 05515, "a_oemail@10.com", "argentina", "portunhol");
   // 	g2.salvar();
  //  	List<GuiaTuristico> lg = GuiaTuristico.porLinguaFalada("portunhol");
    	//for (GuiaTuristico gg : lg)
    	//{
    //		System.out.println("Nome dos Guias:   "+gg.getNome());
    //	}
       
    	/*PagamentoBoleto pagbol = new PagamentoBoleto(p, 99.99, 32, 45);
    	pagbol.salvar();
    	List<PagamentoBoleto> pb = PagamentoBoleto.porCodigoPagamento(32);
    	for(PagamentoBoleto pbol :pb){
    		System.out.println(pbol.getPacote().getInfoDestino());
    	}*/
    
    }
}
