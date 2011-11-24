package entidades;

import java.util.List;

public class Compra 
{
	private int id;
	private Pacote pacote;
	private GuiaTuristico guia;
	private Pagamento pagamento;
	private Passeio passeioAdicional;
	private List<Passagem> ListaPassagem;
	private ReservaHotel hotel;
	
	// Construtor basico //
	Compra(int id, Pacote pacote, GuiaTuristico guia, Pagamento pagamento, 
			Passeio passeioAdicional, List<Passagem> ListaPassagem, ReservaHotel hotel)
	{
		this.id = id;
		this.pacote = pacote;
		this.guia = guia;
		this.pagamento = pagamento;
		this.passeioAdicional = passeioAdicional;
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

	public Passeio getPasseioAdicional() {
		return passeioAdicional;
	}

	public List<Passagem> getListaPassagem() {
		return ListaPassagem;
	}

	public ReservaHotel getHotel() {
		return hotel;
	}
}
