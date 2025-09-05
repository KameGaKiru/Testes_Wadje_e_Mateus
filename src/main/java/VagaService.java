package main.java;

import java.util.ArrayList;
import java.util.List;

public class VagaService {
    private VagaRepositorio vagaRepositorio;

    public VagaService(VagaRepositorio vagaRepositorio) {
        this.vagaRepositorio = vagaRepositorio;
    }

    public boolean criarVaga(String id, String localizacao, String tipo, String status) {
        
    	if (vagaRepositorio.buscarPorId(id) != null ) {
    		return false; // Já existe vaga com ID
    	}
    	
        if (id.isEmpty() || id == null) {
        	return false;
        }
        
        Vaga novaVaga = new Vaga(id, localizacao, tipo, status);              
        vagaRepositorio.salvar(novaVaga);
        return true; // Vaga criada
    }
    
    public Vaga exibirDetalhesVaga(String id) {
    	
    	return this.vagaRepositorio.buscarPorId(id);	
    }
    
    public List<Vaga> buscarVagas(String idBusca){
    	Vaga vagaEncontrada = this.vagaRepositorio.buscarPorId(idBusca);
    	
    	if (vagaEncontrada != null) {
    		
        	List<Vaga> resultado = new ArrayList<>();        	
        	resultado.add(vagaEncontrada);
        	return resultado;
        	
    	} else {
    		return new ArrayList<>();
    	} 	
    	
    }
    
    public boolean atualizarLocalizacao(String id, String localizacao) {
    	Vaga vaga = vagaRepositorio.buscarPorId(id);
    	
    	if (vaga != null) {
    		vaga.setLocalizacao(localizacao);
    		this.vagaRepositorio.salvar(vaga);
    		return true;
    		
    	} 
    		return false;
    }
  
    
    public boolean excluirVaga(String id) {
    	Vaga vagaLivre = vagaRepositorio.buscarPorId(id);
    	
    	if (vagaLivre != null && vagaLivre.getStatus().equals("Livre")) {
    		this.vagaRepositorio.excluir(id);
    		return true;
    	} 
    		return false;
    }
 
   
}