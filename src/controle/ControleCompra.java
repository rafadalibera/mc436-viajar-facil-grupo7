package controle;

import entidades.Cliente;
import entidades.GuiaTuristico;
import entidades.Passagem;
import entidades.PassagemAerea;
import entidades.PassagemMaritima;
import entidades.ReservaHotel;
import entidades.Compra;
import entidades.Pacote;
import entidades.Pagamento;
import entidades.Passeio;
import java.util.*;

public class ControleCompra 
{
	private Compra compra;
	
    private static ControleCompra instance = null;
	
    private ControleCompra()
    {	
	Compra compra = new Compra();
    }

    public static ControleCompra getInstance()
    {
        if (instance == null)
            instance = new ControleCompra();
		
        return instance;
    }
    
	GuiaTuristico buscarGuia(String localidade, String lingua_falada)
	{
		String lingua;
		GuiaTuristico guia;
		//lista de guias no local, que falam a lingua e estão disponiveis
		List <GuiaTuristico> guias_dispo= new ArrayList<GuiaTuristico>();
		//lista de guias no local
		List <GuiaTuristico> guias_local = GuiaTuristico.porLocalidade(localidade);
		
		Iterator it = guias_local.iterator();
		
		while(it.hasNext())
		{
			guia = (GuiaTuristico) it.next();
			lingua = guia.getLingua();
			//verifica se o guia encontrada fala a lingua desejada
			if (lingua.equals(lingua_falada))
			    guias_dispo.add(guia);
		}
		
		guia = guias_dispo.get(0);
			
		return guia;
	}
		
	ReservaHotel reservaHotel (int numero_estrelas, Date entrada, Date saida, int hospedes_quarto)
	{
		List <String> nomes_hotel = new ArrayList<String>();
		nomes_hotel.add("Hotel Arara");
		nomes_hotel.add("Hotel Beija-Flor");
		nomes_hotel.add("Hotel Pardal");
		nomes_hotel.add("Hotel João de Barro");
		nomes_hotel.add("Hotel Bem Te vi");
		
		//gera o nome do hotel
		int x = 0 + generator.nextInt(4 - 0); 
		//gera o numero do quarto
		int quarto = 1 + generator.nextInt(50 - 1);
		//gera o preco do hotel
		int preco = 100 + generator.nexInt (500 - 100);
		
		//Cria objeto do hotel reservado
		ReservaHotel hotel = new ReservaHotel(nomes_hotel.get(x), quarto, numero_estrela, entrada, saida, hospedes_quarto, 1234, preco);
		
		return hotel;
	}
	
	PassagemAerea reservaPassagemAerea (String destino, String origem, int ano, int mes, int dia)
	{
		List <String> portao = new ArrayList<String>();
		portao.add("1A");
		portao.add("1B");
		portao.add("1C");
		portao.add("2A");
		portao.add("2B");
		portao.add("2C");
		portao.add("3A");
		portao.add("3B");
		portao.add("3C");
		portao.add("4A");
		portao.add("4B");
		portao.add("4C");
		portao.add("5A");
		portao.add("5B");
		portao.add("5C");
		portao.add("6A");
		portao.add("6B");
		portao.add("6C");
		
		List <String> companhia = new ArrayList<String>();
		companhia.add("TAM");
		companhia.add("Azul");
		companhia.add("Gol");
		companhia.add("WebJet");			
			
		//gera o nemero do portao
		int j = 0 + generator.nextInt(3 - 0); 
		//gera o nemero da companhia
		int x = 0 + generator.nextInt(17 - 0); 
		//gera o preco do hotel
		int preco = 100 + generator.nexInt (1000 - 100);
		//gera o numero da polt		}rona
		int poltrona = 0 + generator.nexInt (50 - 0);
		//gera id
		int id = 0 +generator.nexInt (1000 - 0);
		//Obtem o nome do aeroporto
		String aeroporto = getAeroporto (destino);
			
		//Cria o objeto da passagem
		PassagemAerea passagem = new PassagemAerea (id, destino, origem, ano, mes, dia, preco, aeroporto, portao.get(x), companhia.get(j), poltrona);
		
		return passagem;						
	}
	
	PassagemMaritima reservaPassagemMaritima (String destino, String origem, int ano, int mes, int dia)
	{
		List <String> companhia = new ArrayList<String>();
		companhia.add("MSC");
		companhia.add("CVC");
		companhia.add("Island");
		companhia.add("Sun & Sea");
		
		//gera o numero da companhia
		int j = 0 + generator.nextInt(3 - 0); 
		//gera o preco do cruzeiro
		int preco = 1000 + generator.nexInt (5000 - 100);
		//gera o numero da cabine
		int cabine = 0 + generator.nexInt (500 - 0);
		//gera id
		int id = 0 + generator.nexInt (1000 - 0);
		
		//Cria o objeto da passagem maritima
		PassagemMaritima passagem = new PassagemMaritima (id, destino, origem, ano, mes, dia, preco, origem, companhia.get(j), cabine);
		
		return passagem;		
	}
	
	Pagamento calcularPagamento (Pacote pacote, double preco)
	{
		//gera o codigo do pagamento
		int id = 1000 + generator.nexInt (9999 - 1000);
		
		Pagamento pagamento = new Pagamento (pacote, preco, false, id);
		
		return pagamento;
	}
	
	double getPrecoPacotePasseios (Pacote pacote)
	{
		Passeio pac;
		Set<Passeio> passeios_pacote = new HashSet<Passeio>();
		
		double preco_pacote;
		double preco_passeios = 0;
		
		preco_pacote = pacote.getPreco();
		passeios_pacote = pacote.getPasseios();
		
		Iterator it = passeios_pacote.iterator();
		
		while (it.hasNext())
		{
			pac = (Passeio) it.next();
			if (pac.checkHabilitado())
				preco_passeios += pac.getpreco();
		}
		
		return preco_pacote + preco_passeios;
		
	}
	
	String getAeroporto (String cidade)
	{
		if (cidade.equals("Campinas"))
			return "Viracopos";
		else if (cidade.equals("Sao Paulo"))
			return "Cumbica";
		else if (cidade.equals("Rio de Janeiro"))
			return "Galeao";
		else if (cidade.equals("Curitiba"))
			return "Afonso Pena";
		else if (cidade.equals("Salvador"))
			return "Luiz Eduardo Magalhaes";
		else 
			return "Consulte a companhia aerea";
	}
	
	public Compra criarCompra (Pacote pacote, boolean add_guia, String lingua_falada, int numero_estrelas, int hospedes_quarto, String tipo_passagem, String tipo_pagamento)
	{
		GuiaTuristico guia;
		ReservaHotel hotel;
		PassagemAerea p_aereo;
		PassagemMaritima p_maritimo;
		Pagamento pagamento;
		int ano, mes, dia;
		List<Passagem> lista_passagem = new ArrayList<Passagem>();
		
		double preco, p_pacote, p_hotel, p_passagem, p_guia = 0;
		
		String localidade = pacote.getDestino();
		Date entrada = pacote.getDataIda();
		ano = entrada.getYear();
		mes = entrada.getMonth();
		dia = entrada.getDay();
		Date saida = pacote.getDataVolta();
		
		//obtem o preco do pacote
		p_pacote = getPrecoPacotePasseios (pacote);
					
		//cria um objeto guia
		if (add_guia)
		{
			guia = buscarGuia(localidade, lingua_falada);
			p_guia = 100;
		}
		
		//cria um objeto hotel
		hotel = reservaHotel (numero_estrelas, entrada, saida, hospedes_quarto);
		p_hotel = getPreco();
				
		//cria um objeto passagem
		if (tipo_passagem.equals("aerea"))
		{
			p_aereo = reservaPassagemAerea (destino, origem, ano, mes, dia);
			p_passagem = p_aereo.getPreco();
			lista_passagem.add(p_aereo);
			
		}
		else
		{
			p_maritimo = reservaPassagemMaritima (destino, origem, ano, mes, dia);
			p_passagem = p_maritimo.getPreco();
			lista_passagem.add(p_maritmo);
		}
		
		//calcula o preco total
		preco = p_pacote + p_hotel + p_guia + p_passagem;
		
		//cria um objeto pagamento
		pagamento = calcularPagamento (pacote, preco);
		
		//Cria objeto compra
		Compra compra = new Compra(pacote, guia, pagamento, lista_passagem, hotel);
		
		return compra;		
	}
}


