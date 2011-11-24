package entidades;


public class PagamentoBoleto extends Pagamento{
	
	private int numBoleto;
	
	
	PagamentoBoleto(String pacote,double preco,int codigoPagamento, int numBoleto)
	{

		super(pacote,preco,codigoPagamento);
		this.numBoleto = numBoleto;	

	}
	

	public int getnumBoleto()
	{
		return this.numboleto;
	}

	public boolean pagar()
	{
		//paga boleto no sistema externo
		return true;
	}
	
	public int getConta() {
		return conta;
	}

}
