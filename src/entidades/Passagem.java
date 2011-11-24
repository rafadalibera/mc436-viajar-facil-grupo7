package entidades; 

public class Passagem 
{
	private int id;
	private String destino;
	private String origem;
	private int data;
	private int preco;
	
	// Construtor Basico //
	public Passagem(int id, String destino, String origem, int data, int preco)
	{
		this.id = id;
		this.destino = destino;
		this.origem = origem;
		this.data = data;
		this.preco = preco;
	}

	// GETTERS //
	public int getId() {
		return id;
	}

	public String getDestino() {
		return destino;
	}

	public String getOrigem() {
		return origem;
	}

	public int getData() {
		return data;
	}

	public int getPreco() {
		return preco;
	}
	
}
