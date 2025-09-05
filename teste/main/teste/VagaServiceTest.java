package main.teste;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import main.java.Vaga;
import main.java.VagaRepositorio;
import main.java.VagaService;

public class VagaServiceTest {

		//TC_018 - Criar uma nova vaga com dados válidos
	
	@Test
	void criarVagaComDadosValidos() {
		
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		
		when(vagaRepositorio.buscarPorId("A-50")).thenReturn(null);
		
		VagaService vagaService = new VagaService(vagaRepositorio);
		
		String idVaga = "A-50";
		String localizacao = "Setor A, corredor 5";
		String tipo = "Normal";
		String status = "Livre";
		
		boolean resultado = vagaService.criarVaga(idVaga, localizacao, tipo, status);
		
		assertTrue(resultado, "Vaga criada com sucesso");
	}
	
	
		//TC_019 - Criar vaga com ID que já existe
	
	@Test
	void naoDeveCriarVagaComIdExistente() {
		
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		
		Vaga vagaExistente = new Vaga ("A-50", "Algum lugar", "Normal", "Livre");
		when(vagaRepositorio.buscarPorId("A-50")).thenReturn(vagaExistente);
		
		VagaService vagaService = new VagaService(vagaRepositorio);
		
		String idVaga = "A-50";
		String localizacao = "Setor A, corredor 55";
		String tipo = "Normal";
		String status = "Livre";
		
		boolean resultado = vagaService.criarVaga(idVaga, localizacao, tipo, status);
		
		assertFalse(resultado, "A criação vai falhar porque o ID já existe");
		
		verify(vagaRepositorio, never()).salvar(any(Vaga.class));
	}
	
	
		//TC_020 - Tentar criar uma vaga com campo obrigatório "ID" vazio
	
	@Test
	void naoDeveCriarVagaComIdVazio() {
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		
		VagaService vagaService = new VagaService(vagaRepositorio);
		
		String idVaga = "";
		String localizacao = "Setor A, corredor 5";
		String tipo = "Normal";
		String status = "Livre";
		
		boolean resultado = vagaService.criarVaga(idVaga, localizacao, tipo, status);
		
		assertFalse(resultado, "A criação deve falhar porque o ID está em branco");
		
		verify(vagaRepositorio, never()).salvar(any(Vaga.class));
	}
	
		//TC_021 - Visualizar detalhes de uma vaga existente
	
	@Test
	void exibirDetalhesVagaExistente() {
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		
		VagaService vagaService = new VagaService(vagaRepositorio);
		
		String idVaga = "A-50";
		String localizacao ="Setor A, corredor 5";
		String tipo = "Normal";
		String status = "Livre";
		
		Vaga vagaExistente = new Vaga(idVaga, localizacao, tipo, status);
		
		when(vagaRepositorio.buscarPorId("A-50")).thenReturn(vagaExistente);
		
		Vaga vagaEncontrada = vagaService.exibirDetalhesVaga("A-50");
		
		
		assertNotNull(vagaEncontrada, "A vaga encontrada é nula");
		assertEquals(idVaga, vagaEncontrada.getId(), "O id da vaga está incorreto");
		assertEquals(localizacao, vagaEncontrada.getLocalizacao(),"A localizacao está incorreta");
		assertEquals(tipo, vagaEncontrada.getTipo(),"O tipo de vaga está incorreto");
		assertEquals(status, vagaEncontrada.getStatus(), "O status está incorreto");
		
		verify(vagaRepositorio, times(1)).buscarPorId(idVaga);
	}
	
		// TC_022 - Buscar vaga existente por ID
	
	@Test
	
	void buscarVagaPeloId() {
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		
		VagaService vagaService = new VagaService(vagaRepositorio);
		
		String idVaga = "A-50";
		String localizacao ="Setor A, corredor 5";
		String tipo = "Normal";
		String status = "Livre";
		
		Vaga vagaAlvo = new Vaga(idVaga, localizacao, tipo, status);
		
		when(vagaRepositorio.buscarPorId("A-50")).thenReturn(vagaAlvo);
		
		List<Vaga> resultadoBusca = vagaService.buscarVagas(idVaga);
		
		assertNotNull(resultadoBusca, "A lista não deve retornar null");
		assertEquals(1, resultadoBusca.size());
		assertEquals(idVaga, vagaAlvo.getId());
		assertEquals(localizacao, vagaAlvo.getLocalizacao());
		assertEquals(tipo, vagaAlvo.getTipo());
		
		verify(vagaRepositorio, times(1)).buscarPorId(idVaga);
	}
	
		// TC_023 - Buscar por uma vaga que não existe
	
	@Test
	void buscarVagaInexistente() {
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		
		VagaService vagaService = new VagaService(vagaRepositorio);		
		
		when(vagaRepositorio.buscarPorId("A-50")).thenReturn(null);
		
		List<Vaga> resultadoBusca = vagaService.buscarVagas("A-50");
		
		assertNotNull(resultadoBusca, "A lista não deve retornar null");
		assertEquals(0, resultadoBusca.size());
		
		verify(vagaRepositorio, times(1)).buscarPorId("A-50");
	}
	
		// TC_024 - Atualizar a localização de uma vaga existente.
	
	@Test
	void atualizarLocalizacaoDeVagaExistente() {
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		VagaService vagaService = new VagaService(vagaRepositorio);
				
		String idVaga = "A-50";
		String localizacao = "Setor A, Corredor 5";
		String tipo = "Normal";
		String status = "Livre";
		
		Vaga vagaExistente = new Vaga(idVaga, localizacao, tipo, status);
		
		when(vagaRepositorio.buscarPorId(idVaga)).thenReturn(vagaExistente);
		
		String novaLocalizacao = "Nova localizacao";
		
		boolean resultado = vagaService.atualizarLocalizacao(idVaga, novaLocalizacao);
		
		assertTrue(resultado, "A atualização deveria retornar sucesso");
		
		verify(vagaRepositorio, times(1)).salvar(any(Vaga.class));
	}
	
		//TC_026 - Excluir um vaga com status "Livre"
	
	@Test
	void excluirVagaComStatusLivre() {
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		
		VagaService vagaService = new VagaService(vagaRepositorio);
		
		String idVaga = "A-50";
		String localizacao = "Setor A, Corredor 5";
		String tipo = "Normal";
		String status = "Livre";
		
		Vaga vagaLivre = new Vaga(idVaga, localizacao, tipo, status);
		
		when(vagaRepositorio.buscarPorId(idVaga)).thenReturn(vagaLivre);				
		
		boolean resultado = vagaService.excluirVaga(vagaLivre.getId());
		
		assertTrue(resultado, "A vaga deveria ser null");
		
		verify(vagaRepositorio, times(1)).excluir("A-50");
	}
	
	//TC_027 - Tentar excluir um vaga com status "Ocupada"
	
@Test
	void excluirVagaComStatusOcupada() {
		VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
		
		VagaService vagaService = new VagaService(vagaRepositorio);
		
		String idVaga = "A-50";
		String localizacao = "Setor A, Corredor 5";
		String tipo = "Normal";
		String status = "Ocupada";
		
		Vaga vagaOcupada = new Vaga(idVaga, localizacao, tipo, status);
		
		when(vagaRepositorio.buscarPorId(idVaga)).thenReturn(vagaOcupada);				
		
		boolean resultado = vagaService.excluirVaga(vagaOcupada.getId());
		
		assertFalse(resultado, "Vaga não deveria ser excluida");
		
		verify(vagaRepositorio, times(0)).excluir("A-50");
	}

//TC_028 - Tentar excluir um vaga com status "Reservada"

@Test
void excluirVagaComStatusReservada() {
	VagaRepositorio vagaRepositorio = Mockito.mock(VagaRepositorio.class);
	
	VagaService vagaService = new VagaService(vagaRepositorio);
	
	String idVaga = "A-50";
	String localizacao = "Setor A, Corredor 5";
	String tipo = "Normal";
	String status = "Reservada";
	
	Vaga vagaReservada = new Vaga(idVaga, localizacao, tipo, status);
	
	when(vagaRepositorio.buscarPorId(idVaga)).thenReturn(vagaReservada);				
	
	boolean resultado = vagaService.excluirVaga(vagaReservada.getId());
	
	assertFalse(resultado, "Vaga não deveria ser excluida");
	
	verify(vagaRepositorio, times(0)).excluir("A-50");
}
}
