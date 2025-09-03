package main.java;

public class Cadastro {
	
	private String usuario;
	private String contato;
	private String permissao;
	private String senha;
	
	public Cadastro() {}
	
    public Cadastro(String usuario, String contato, String permissao, String senha) {
        this.usuario = usuario;
        this.contato = contato;
        this.permissao = permissao;
        this.senha = senha;
    }
	
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public String getPermissao() {
		return permissao;
	}
	
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
}
