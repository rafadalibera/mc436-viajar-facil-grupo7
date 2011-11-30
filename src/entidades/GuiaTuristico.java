package entidades;

public class GuiaTuristico
{
    private int id;
    private String nome;
    private int telefone;
    private String email;
    private String localidade;
    private String lingua_falada;

    public GuiaTuristico (int id, String nome, int telefone, String email, String localidade, String lingua_falada)
    {
    	this.id = id;
    	this.nome = nome;
    	this.telefone = telefone;
    	this.email =  email;
    	this.localidade = localidade;
    	this.lingua_falada = lingua_falada;
    }

    public int getId ()
    {
    	return this.id;
    }

    public String getNome()
    {
    	return this.nome;
    }

    public int getTelefone ()
    {
    	return this.telefone;
    }

    public String getEmail()
    {
    	return this.email;
    }

    public String getLocalidade()
    {
    	return this.localidade;
    }

    public String getLingua()
    {
    	return this.lingua_falada;
    }
}
