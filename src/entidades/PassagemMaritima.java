package entidades;

import entidades.Passagem;

public class PassagemMaritima extends Passagem 
{
	String porto;
	String companhia_maritima;
	String cabine;
	
	public PassagemMaritima (int id, String destino, String origem, int data, int preco, String porto, String companhia_maritima, String cabine)
	{
		super(id, destino, origem, data, preco);
		
		this.porto = porto;
		this.companhia_maritima = companhia_maritima;
		this.cabine = cabine;
		
	}
	
	String getPorto()
	{
		return this.porto;
	}
	
	String getCompanhiaMaritima()
	{
		return this.companhia_maritima;
	}
	
	String getCabine()
	{
		return this.cabine;
	}

}
