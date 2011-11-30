package controle;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Set;
import java.util.HashSet;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public String hashSenha(String senha)
    {
        byte byteData[];
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(senha.getBytes());
            byteData = md.digest();
        } catch (NoSuchAlgorithmException e) {
            // Não deveria acontecer
            return null;
        }

        // Converte bytes para o formato hexadecimal.
        // Fonte: http://www.mkyong.com/java/java-sha-hashing-example/
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public boolean cadastrarCliente(int id, int numero_cartao, String nome, String senha,
            String rg, String cpf, String email,
            HashSet<String> telefones)
    {
        //Cria o objeto cliente que será salvo no banco de dados
        Cliente cliente = new Cliente(id,
                                      numero_cartao,
                                      nome,
                                      hashSenha(senha),
                                      rg,
                                      cpf,
                                      email,
                                      telefones);

        //salvar o objeto cliente no banco de dados
        cliente.salvar();

        return true;
        }

}
