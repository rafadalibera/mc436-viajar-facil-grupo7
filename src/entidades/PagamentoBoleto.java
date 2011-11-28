package entidades;


public class PagamentoBoleto extends Pagamento{
	
	private int numBoleto;
	
	
	PagamentoBoleto(Pacote pacote,double preco,int codigoPagamento, int numBoleto)
	{

		super(pacote,preco,codigoPagamento);
		this.numBoleto = numBoleto;	

	}
	

	public int getnumBoleto()
	{
		return numBoleto;
	}

	public boolean pagar()
	{
		//paga boleto no sistema externo
		return true;
	}
}
