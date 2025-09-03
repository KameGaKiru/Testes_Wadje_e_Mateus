package main.teste;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import main.java.Cadastro;
import main.java.CadastroRepositorio;
import main.java.CadastroService;

public class CadastroServiceTest {

    // TC006 - Cadastrar usuário com informações corretas (com falha proposital)
    @Test
    void CadastrarUsuarioComSenhaVazia() {
    	 
    	CadastroRepositorio cadastroRepositorio = mock(CadastroRepositorio.class);
    	 
        CadastroService cadastroService = new CadastroService(cadastroRepositorio);

        Cadastro cadastro = new Cadastro("teste", "12 3456 7890", "Usuário", "teste123");

        boolean resultado = cadastroService.cadastrar(cadastro);

        assertTrue(resultado, "O cadastro deve ser aceito com todos os dados válidos");
        verify(cadastroRepositorio, times(1)).salvar(cadastro);
    }
}