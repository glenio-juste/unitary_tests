package br.juste.servicos;

import static br.juste.utils.DataUtils.adicionarDias;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.juste.entidades.Filme;
import br.juste.entidades.Locacao;
import br.juste.entidades.Usuario;
import br.juste.utils.DataUtils;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar mÃ©todo para salvar
		
		return locacao;
	}

	
	@Test
	public void teste() {
		
		//cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Glenn");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//ação
		Locacao locacao =  service.alugarFilme(usuario, filme);
		
		//verificação		
		Assert.assertTrue(locacao.getValor() == 5.0); // para testar erro, colocar valor == 4.0	
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));		
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
}