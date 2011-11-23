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
	
	public Passeio()
	{
		this.id = (Integer) null;
		this.numeroVagas = (Integer) null;
		this.data = null;
		this.local = null;
		this.reservado = (Boolean) null;
		this.totalPessoas = (Integer) null;
		this.infoPasseio = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	
	public void somaPassageiros(int nPassageiros) {
		numeroVagas -= nPassageiros;
		totalPessoas += nPassageiros;
	}
	
	public void diminuiPassageiros(int nPassageiros) {
		numeroVagas += nPassageiros;
		totalPessoas -= nPassageiros;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
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

	public void setInfoPasseio(String infoPasseio) {
		this.infoPasseio = infoPasseio;
	}	
}
