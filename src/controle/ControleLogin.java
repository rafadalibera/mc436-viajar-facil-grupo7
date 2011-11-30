package controle;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;

import entidades.Cliente;

import controle.ControleCadastro;

public class ControleLogin
{
    private Cliente clientes;
	
    private static ControleLogin instance = null;
	
    private ControleLogin()
    {	
	Cliente cliente = new Cliente();
    }

    public static ControleLogin getInstance()
    {
        if (instance == null)
            instance = new ControleLogin();
		
        return instance;
    }
	
    public boolean verificarLogin (String email, String senha)
    {
	String senha_teste;
	boolean retorno;
	
	Cliente c1 = new Cliente();
	Cliente c2 = new Cliente();
	
	List<Cliente> lista = c1.porEmail(email);

	//Verifica se o registro pesquisado está no BD
	if (lista.isEmpty())
		return false;
	//Obtém o objeto cliente com email fornecido
	c2 = lista.get(0);

	//Obtém a senha do usuário no BD
	senha_teste = c2.getSenha();
		
	System.out.println("Senha teste: " + senha_teste);
	//verifica se a senha digitada é igual a senha do usuário no BD
	if (senha_teste.equals(ControleCadastro.getInstance().hashSenha(senha)))
	    retorno = true;
	else
	    retorno = false;
		
	return retorno;
	}
}
