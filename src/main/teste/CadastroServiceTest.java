package main.teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.java.CadastroService;

public class CadastroServiceTest {

	// TC006 - Cadastrar usuário com informações corretas
    @Test
    void CadastrarUsuarioComInformacoesCorretas() {
        CadastroService cadastroService = new CadastroService();

        boolean resultado = cadastroService.cadastrar("teste", "1234567890", "Usuário", "teste123");

        assertTrue(resultado, "O cadastro deve ser aceito com todos os dados válidos");
    }

    // TC007 - Cadastrar usuário com usuário inválido
    @Test
    void CadastrarUsuarioComUsuarioInvalido() {
        CadastroService cadastroService = new CadastroService();

        boolean resultado = cadastroService.cadastrar("Wadje#", "1234567890","Usuário","teste123");

        assertFalse(resultado, "O cadastro não deve ser aceito com o usuário inválido");
    }
    
    // TC008 - Cadastrar usuário com contato inválido
    @Test
    void CadastrarUsuarioComContatoInvalido() {
        CadastroService cadastroService = new CadastroService();

        boolean resultado = cadastroService.cadastrar("teste", "abcdefghij","Usuário","teste123");

        assertFalse(resultado, "O cadastro não deve ser aceito com o contato inválido (deve conter apenas números)");
    }
    
 // TC009 - Cadastrar usuário com permissão vazia
    @Test
    void CadastrarUsuarioComPermissaoVazia() {
        CadastroService cadastroService = new CadastroService();

        boolean resultado = cadastroService.cadastrar("teste", "1234567890","","teste123");

        assertFalse(resultado, "O cadastro não deve ser aceito com o permissão inválida");
    }
    
    // TC010 - Cadastrar usuário com informações corretas
    @Test
    void CadastrarUsuarioComsenhaInvalida() {
        CadastroService cadastroService = new CadastroService();

        boolean resultado = cadastroService.cadastrar("teste", "1234567890", "Usuário", "teste");

        assertFalse(resultado, "O cadastro não deve ser aceito com a senha inválida (deve conter letras e números)");
    }
}
    
