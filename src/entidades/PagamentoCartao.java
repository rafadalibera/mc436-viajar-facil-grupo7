package entidades;

import java.util.Date;

public class PagamentoCartao extends Pagamento{
	
	private int numeroCartao;
	private String proprietario;
	private String bandeira;
	private int codigoSeguranca;
	private Date dataVencimento;
	
	///// Construtor Basico ////
	PagamentoCartao(Pacote pacote,double preco,int codigoPagamento,int numeroCartao,
			String proprietario,String bandeira,int codigoSeguranca,Date dataVencimento)
	{
		super( pacote, preco, codigoPagamento);
		this.numeroCartao = numeroCartao;
		this.bandeira = bandeira;
		this.proprietario = proprietario;
		this.codigoSeguranca = codigoSeguranca;
		this.dataVencimento = dataVencimento;
	}
	//////// GETTERS ////////////
	public int getNumeroCartao() {
		return numeroCartao;
	}

	public String getProprietario() {
		return proprietario;
	}

	public String getBandeira() {
		return bandeira;
	}

	public int getCodigoSeguranca() {
		return codigoSeguranca;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}
}
