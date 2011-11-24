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

	// Construtor basico //
	Pacote(Date dataIda, Date dataVolta, double preco, String infoDestino)
	{
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.preco = preco;
		this.infoDestino = infoDestino;
		this.ListaPasseios = new ArrayList<Passeio>() ;
	}
	
	/////////////////GETTERS///////////////////////
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

	public List<Passeio> getListaPasseios() {
		return this.ListaPasseios;
	}
	// Metodos que adicionam e removem um passeio do pacote //
	public Boolean addPasseio(Passeio objPasseio) {
		return ListaPasseios.add(objPasseio);
	}

	public Boolean removePasseio(Passeio objPasseio)
	{
		return ListaPasseios.remove(objPasseio);
	}
		
}
