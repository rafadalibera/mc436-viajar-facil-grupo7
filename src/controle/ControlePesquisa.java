package controle;

//import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

//import javax.swing.text.html.HTMLDocument.Iterator;

import entidades.Pacote;

public class ControlePesquisa 
{
	private List<Pacote> pacotes;
	
    private static ControlePesquisa instance = null;
	
    private ControlePesquisa()
    {	
        List<Pacote> pacotes = new ArrayList<Pacote>();
    }
	
    public static ControlePesquisa getInstance()
    {
        if (instance == null)
            instance = new ControlePesquisa();
		
        return instance;
    }	
    
    public List<Pacote> pesquisarPacote (String destino, Date data_ida, Date data_volta)
    {
    	Date ida;
    	Date volta;
        Pacote pac;
    	List <Pacote> lista_retorno = new ArrayList<Pacote>();
    	List <Pacote> lista_destino = Pacote.porDestino(destino);
    	
    	Iterator it = lista_destino.iterator();  
    	
    	while (it.hasNext())
    	{
            pac = (Pacote) it.next();
    		ida = pac.getDataIda();
    		volta = pac.getDataVolta();
    		if ((ida.compareTo(data_ida) >= 0) && (volta.compareTo(data_volta) <= 0))
    			lista_retorno.add(pac);  
    	}
    	
    	return lista_retorno;    	
    }

}
