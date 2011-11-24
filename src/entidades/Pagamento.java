package entidades;

public class Pagamento 
{
	private String pacote; // nao deveria ser um objeto Pacote ?
	private double preco;
	private boolean estado; 
	private int codigoPagamento;
	
	///// Construtor basico 
	Pagamento (String pacote,double preco,int codigoPagamento)
	{
		this.pacote = pacote;
		this.preco = preco;
		this.codigoPagamento = codigoPagamento;
		this.estado = false;   //seta estado para falso, jah que o pagamento nao estah quitado
	}
	
	public boolean obterStatus()
	{
		return estado;
	}
	
	public boolean quitar()
	{
		if (estado == false)
		{
			estado = true;
			return true;
		}
		else return false;
	}

	/////////// GETTERS ////////
	public String getPacote() {
		return pacote;
	}

	public double getPreco() {
		return preco;
	}

	public int getCodigoPagamento() {
		return codigoPagamento;
	}
	
}
