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
	ReservaHotel(String hotel, int quarto, int numeroEstrelas, Date dataEntrada,
			     Date dataSaida, int hospedesQuarto, int id, double preco)
	{
		this.hotel = hotel;
		this.quarto = quarto;
		this.numeroEstrelas = numeroEstrelas;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
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
}
