package main.java;

public class CadastroService {
	
	private CadastroRepositorio cadastroRepositorio;

	public CadastroService(CadastroRepositorio cadastroRepositorio) 
	{
	        this.cadastroRepositorio = cadastroRepositorio;
	}
	
	public boolean cadastrar(Cadastro cadastro) {
       
		if (cadastro.getSenha() == null || cadastro.getSenha().isEmpty()) 
		{
            return false;
        }
		
		cadastroRepositorio.salvar(cadastro);
        return true;
    }
}
