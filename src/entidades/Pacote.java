package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Pacote {

	private Date dataIda;
	private Date dataVolta;
	private double preco;
	private String infoDestino;
	private List<Passeio> ListaPasseios;

	Pacote(Date dataIda, Date dataVolta, double preco, String infoDestino)
	{
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.preco = preco;
		this.infoDestino = infoDestino;
		this.ListaPasseios = new ArrayList<Passeio>() ;
	}
	
	Pacote()
	{
		this.dataIda = null;
		this.dataVolta = null;
		this.preco = (Double) null;
		this.infoDestino = null;
		this.ListaPasseios = new ArrayList<Passeio>() ;
	}

	public Date getDataIda() {
		return dataIda;
	}

	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}

	public Date getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getInfoDestino() {
		return infoDestino;
	}

	public void setInfoDestino(String infoDestino) {
		this.infoDestino = infoDestino;
	}
	
	public Boolean addPasseio(Passeio objPasseio) {
		return ListaPasseios.add(objPasseio);
	}

	public Boolean removePasseio(Passeio objPasseio)
	{
		return true;
	}
	
	public List<Passeio> getListaPasseio() {
		return this.ListaPasseios;
	}
		
}
