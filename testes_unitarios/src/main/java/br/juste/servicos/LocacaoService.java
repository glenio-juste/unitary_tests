package br.juste.servicos;

import static br.juste.utils.DataUtils.adicionarDias;

import java.util.Date;

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

	public static void main(String[] args) {
		
		//cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Glenn");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		//ação
		Locacao locacao =  service.alugarFilme(usuario, filme);
		
		//verificação
		System.out.println(locacao.getValor());
		System.out.println(locacao.getValor() == 5.0);
		System.out.println(locacao.getDataLocacao());
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(locacao.getDataRetorno());
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
}