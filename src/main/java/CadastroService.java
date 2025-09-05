package main.java;

public class CadastroService {
	
	public CadastroService() {}
	
	public boolean cadastrar(String usuario, String contato, String permissao, String senha) {
        if (usuario == null || usuario.isEmpty() || !usuario.matches("^[a-zA-Z]+$")) {
            return false;
        }
        if (contato == null || contato.isEmpty() || !contato.matches("^[0-9]+$")) {
            return false;
        }
        if (permissao == null || !permissao.equals("Usuário")) {
            return false;
        }
        if (senha == null || senha.isEmpty() || !senha.matches("^(?=.*[A-Za-z])(?=.*[0-9]).+$")) {
            return false;
        }

        return true;
    }
}
