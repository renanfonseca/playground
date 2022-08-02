package br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.dto;

import javax.validation.constraints.NotBlank;

import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model.Pedido;
import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model.StatusPedido;

public class RequisicaoNovoPedido {

	@NotBlank
	private String nomeProduto;

	@NotBlank
	private String ulrProduto;

	@NotBlank
	private String ulrImagem;

	@NotBlank
	private String descricao;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUlrProduto() {
		return ulrProduto;
	}

	public void setUlrProduto(String urlProduto) {
		this.ulrProduto = urlProduto;
	}

	public String getUlrImagem() {
		return ulrImagem;
	}

	public void setUlrImagem(String ulrImagem) {
		this.ulrImagem = ulrImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setDescricao(descricao);
		pedido.setUlrImagem(ulrImagem);
		pedido.setUlrProduto(ulrProduto);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}

}
