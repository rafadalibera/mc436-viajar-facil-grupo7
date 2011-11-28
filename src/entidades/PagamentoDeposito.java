package entidades;

public class PagamentoDeposito extends Pagamento {
	private String banco;
	private int agencia;
	private int conta;	
	
	//Construtor Basico //
	PagamentoDeposito(Pacote pacote,double preco,int codigoPagamento,String banco,
			          int agencia, int conta)
	{
		super(pacote,preco,codigoPagamento);
		this.agencia = agencia;
		this.conta = conta;
		this.banco = banco;
	}

	///////////////// GETTERS ///////////////////////
	public String getBanco() {
		return banco;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getConta() {
		return conta;
	}
	
	public boolean pagar()
	{
		//paga deposito no sistema externo
		return true;
	}
}
