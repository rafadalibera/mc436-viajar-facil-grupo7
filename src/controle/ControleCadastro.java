package controle;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Set;
import java.util.HashSet;

import entidades.Cliente;

public class ControleCadastro 
{
    private ArrayList<Cliente> clientes;
	
    private static ControleCadastro instance = null;
	
    private ControleCadastro()
    {	
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    }
	
    public static ControleCadastro getInstance()
    {
        if (instance == null)
            instance = new ControleCadastro();
		
        return instance;
    }	
	
    public boolean cadastrarCliente(int id, int numero_cartao, String nome, String senha,
            String rg, String cpf, String email,
            HashSet<String> telefones)
    {
        //Cria o objeto cliente que será salvo no banco de dados
        Cliente cliente = new Cliente(id, numero_cartao, nome, senha, rg, cpf, email, telefones);
		
        //salvar o objeto cliente no banco de dados
        cliente.salvar();

        return true;
    }

}
