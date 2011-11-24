package entidades;

import java.util.Date;

public class Passeio {
	
	private int id;
	private int numeroVagas;
	private Date data;
	private String local;
	private boolean reservado;
	private int totalPessoas;
	private String infoPasseio;
	
	// Construtor basico //
	public Passeio(int id, int numeroVagas, Date data, String local,
			boolean reservado, int totalPessoas, String infoPasseio) 
	{
		this.id = id;
		this.numeroVagas = numeroVagas;
		this.data = data;
		this.local = local;
		this.reservado = reservado;
		this.totalPessoas = totalPessoas;
		this.infoPasseio = infoPasseio;
	}
   
	///////////////////////GETTERS & SETTERS/////////////////////////////
	public int getId() {
		return id;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}
	
	public Date getData() {
		return data;
	}

	public String getLocal() {
		return local;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public int getTotalPessoas() {
		return totalPessoas;
	}

	public void setTotalPessoas(int totalPessoas) {
		this.totalPessoas = totalPessoas;
	}

	public String getInfoPasseio() {
		return infoPasseio;
	}
	
	// Dois metodos que alteram o numero de passageiros e de vagas do pacote //
	public void somaPassageiros(int nPassageiros) {
		numeroVagas -= nPassageiros;
		totalPessoas += nPassageiros;
	}
	
	public void diminuiPassageiros(int nPassageiros) {
		numeroVagas += nPassageiros;
		totalPessoas -= nPassageiros;
	}
}
