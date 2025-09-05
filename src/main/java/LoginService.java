package main.java;

public class LoginService {
	
	private UsuarioRepositorio usuarioRepositorio;

	public LoginService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }
	
	public boolean autenticar(String login, String senha) {
	    if (login == null || senha == null || login.isEmpty() || senha.isEmpty()) 
	    {
	        return false;
	    }
	    
	    Usuario usuario = usuarioRepositorio.buscarPorLogin(login);
	    if (usuario == null) 
	    {
	        return false;
	    }
	    
	    return usuario.getSenha().equals(senha);
	}

}
