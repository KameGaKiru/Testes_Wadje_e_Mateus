package main.teste;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import main.java.LoginService;
import main.java.Usuario;
import main.java.UsuarioRepositorio;

public class LoginServiceTest {
	
		// TC 001 - Realizar login de usuário com informações corretas
	    @Test
	    void LogarComInformacoesCorretas() {
	        
	    	// Mock do repositório
	        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
	
	        // Simulando que existe um usuário com login "teste"
	        when(usuarioRepositorio.buscarPorLogin("teste"))
	            .thenReturn(new Usuario("teste", "teste123"));
	
	        // Passando mock para o LoginService
	        LoginService loginService = new LoginService(usuarioRepositorio);
	
	        boolean resultado = loginService.autenticar("teste", "teste123");
	
	        assertTrue(resultado, "O login deve ser bem-sucedido");
	
	        // Verifica se o repositório foi chamado
	        verify(usuarioRepositorio, times(1)).buscarPorLogin("teste");
	    }
	
	    // TC 002 - Realizar login de usuário com senha inválida
	    @Test
	    void LogarComSenhaInvalida() {
	    	
	        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
	
	        when(usuarioRepositorio.buscarPorLogin("teste"))
	            .thenReturn(new Usuario("teste", "teste123"));
	
	        LoginService loginService = new LoginService(usuarioRepositorio);
	
	        boolean resultado = loginService.autenticar("teste", "testando10");
	
	        assertFalse(resultado, "O login não deve ser aceito com senha errada");
	    }
	    
	 // TC 003 - Realizar login de usuário com usuário incorreto
	    @Test
	    void LogarComUsuarioInvalida() {
	    	
	        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
	
	        when(usuarioRepositorio.buscarPorLogin("teste"))
	            .thenReturn(new Usuario("teste", "teste123"));
	
	        LoginService loginService = new LoginService(usuarioRepositorio);
	
	        boolean resultado = loginService.autenticar("testando", "teste123");
	
	        assertFalse(resultado, "O login não deveria ser aceito com o login errada");
	    }
	    
	 // TC 004 - Realizar login de usuário com senha vazia (null)
	    @Test
	    void LogarComSenhaVazia	() {
	    	
	        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
	
	        when(usuarioRepositorio.buscarPorLogin("teste"))
	            .thenReturn(new Usuario("teste", "teste123"));
	
	        LoginService loginService = new LoginService(usuarioRepositorio);
	
	        boolean resultado = loginService.autenticar("testando", null);
	
	        assertFalse(resultado, "O login não deveria ser aceito com senha nula");
	    }
    
	 // TC 005 - Realizar login de usuário com usuário vazio (null)
	    @Test
	    void LogarComUsuarioVazio	() {
	    	
	        UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
	
	        when(usuarioRepositorio.buscarPorLogin("teste"))
	            .thenReturn(new Usuario("teste", "teste123"));
	
	        LoginService loginService = new LoginService(usuarioRepositorio);
	
	        boolean resultado = loginService.autenticar(null, "teste123");
	
	        assertFalse(resultado, "O login não deve ser aceito com usuário nula");
	    }
}
