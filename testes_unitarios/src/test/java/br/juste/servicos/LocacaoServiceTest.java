package br.juste.servicos;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import br.juste.entidades.Filme;
import br.juste.entidades.Locacao;
import br.juste.entidades.Usuario;
import br.juste.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste() {

		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Glenn");
		Filme filme = new Filme("Filme 1", 2, 5.0);

		// ação
		Locacao locacao = service.alugarFilme(usuario, filme);

		// verificação
		Assert.assertTrue(locacao.getValor() == 5.0); // para testar erro, colocar valor == 4.0
		Assert.assertEquals(5.0, locacao.getValor(), 0.01);
		
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

		
		//======== Normal ========
		
		//Assert.assertThat(reason, actual, matcher);
		Assert.assertThat(locacao.getValor(), CoreMatchers.is(5.0)); 				
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
		
		//======== Fluidez ======== importe estático
		
		//Assert.assertThat(reason, actual, matcher);
		assertThat(locacao.getValor(), is(5.0)); 
		
		assertThat(locacao.getValor(), is(equalTo(5.0))); 
		assertThat(locacao.getValor(), is(not(6.0))); 	
		
		assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
		
	}

}
