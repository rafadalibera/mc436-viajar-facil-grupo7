package entidades;

public class PagamentoDeposito extends Pagamento{
	
	private int numBoleto;
	
	
	PagamentoDeposito(String pacote,double preco,int codigoPagamento, int numBoleto)
	{
		super(pacote, preco, codigoPagamento);
		this.numBoleto=numBoleto;
				
	}


	public int getNumBoleto() {
		return numBoleto;
	}

	public boolean payBoleto()
	{
		//paga boleto no sistema externo
		return true;
	}
	
}