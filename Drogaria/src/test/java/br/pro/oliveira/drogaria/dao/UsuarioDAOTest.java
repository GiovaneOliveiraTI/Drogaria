package br.pro.oliveira.drogaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.oliveira.drogaria.dao.PessoaDAO;
import br.pro.oliveira.drogaria.dao.UsuarioDAO;
import br.pro.oliveira.drogaria.domain.Pessoa;
import br.pro.oliveira.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	@Test
	@Ignore
	public void salvar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		System.out.println("Pessoa Encontrada");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("q1w2e3r4");
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso.");
	}
}	
