package main.java;

public interface VagaRepositorio {
	
	void salvar(Vaga vaga);
	Vaga buscarPorId(String id);
	void excluir(String id);
}
