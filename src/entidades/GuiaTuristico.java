package entidades;

public class GuiaTuristico 
{
    private int id;
    private String nome;
    private int telefone;
    private String email;
    private String localidade;
    private String lingua_falada;
    
    public GuiaTuristico (int id, String nome, int telefone, String email, String localidade, String lingua_estrangeira)
    {
    	this.id = id;
    	this.nome = nome;
    	this.telefone = telefone;
    	this.email =  email;
    	this.localidade = localidade;
    	this.lingua_falada = lingua_falada;
    }
    
    public static void main(String[] args) {
        return;
    }
    
    int getId ()
    {
    	return this.id;
    }
    
    String getNome()
    {
    	return this.nome;
    }
    
    int getTelefone ()
    {
    	return this.telefone;
    }
    
    String getEmail()
    {
    	return this.email;
    }
    
    String getLocalidade()
    {
    	return this.localidade;
    }
    
    String get.Lingua()
    {
    	return this.lingua_falada;
    }
    
}
