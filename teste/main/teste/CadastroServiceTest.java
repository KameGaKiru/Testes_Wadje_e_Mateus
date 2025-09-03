package main.teste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.java.Cadastro;
import main.java.CadastroService;

public class CadastroServiceTest {

    // TC006 - Cadastrar usuário com informações corretas (com falha proposital)
    @Test
    void CadastrarUsuarioComSenhaVazia() {
        CadastroService cadastroService = new CadastroService();

        Cadastro cadastro = new Cadastro("teste", "12 3456 7890", "Usuário", "");

        boolean resultado = cadastroService.cadastrar(cadastro);

        
        assertFalse(resultado, "O cadastro não deveria ser aceito com senha vazia");
    }
}