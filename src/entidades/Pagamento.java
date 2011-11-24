package entidades;

public class Pagamento 
{
	private Pacote pacote;
	private double preco;
	private boolean estado; 
	private int codigoPagamento;
	
	///// Construtor basico 
	Pagamento (Pacote pacote,double preco,int codigoPagamento)
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
	public Pacote getPacote() {
		return pacote;
	}

	public double getPreco() {
		return preco;
	}

	public int getCodigoPagamento() {
		return codigoPagamento;
	}
	
}
