package entidades; 

import entidades.Passagem;

public class PassagemAerea extends Passagem
{
	public String aeroporto;
	public int portao_embarque;
	public String companhia_aerea;
	public String poltrona;
	
	public PassagemAerea (int id, String destino, String origem, int data, int preco, String aeroporto, int portao_embarque, String companhia_aerea,String poltrona)
	{
		super(id, destino, origem, data, preco);
		
		this.aeroporto = aeroporto;
		this.portao_embarque = portao_embarque;
		this.companhia_aerea = companhia_aerea;
		this.poltrona = poltrona;
	}
	
	String getAeroport()
	{
		return this.aeroporto;
	}
	
	int getPortaoEmbarque()
	{
		return this.portao_embarque;
	}
	
	String getCompanhiaAerea()
	{
		return this.companhia_aerea;
	}
	
	String getPoltrona()
	{
		return this.poltrona;
	}
	

}
