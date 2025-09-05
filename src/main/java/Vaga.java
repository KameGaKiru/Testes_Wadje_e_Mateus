package main.java;

public class Vaga {
	private String id;
	private String localizacao;
	private String tipo;
	private String status;
	
	public Vaga(String id, String localizacao, String tipo, String status) {
		this.id = id;
		this.localizacao = localizacao;
		this.tipo = tipo;
		this.status = status;
	}
	
    public String getId() {
        return id;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    
    public void setLocalizacao(String localizacao) {
    	this.localizacao = localizacao;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getStatus() {
    	return status;
    }

}
