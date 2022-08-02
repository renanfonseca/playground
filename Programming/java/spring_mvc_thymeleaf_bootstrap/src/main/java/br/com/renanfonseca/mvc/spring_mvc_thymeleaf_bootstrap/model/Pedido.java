package br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	private String ulrProduto;
	private String ulrImagem;
	@Column(nullable = true, columnDefinition = "TEXT", length = 5000)
	private String descricao;
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}

	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}

	public LocalDate getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(LocalDate dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getUlrProduto() {
		return ulrProduto;
	}

	public void setUlrProduto(String ulrProduto) {
		this.ulrProduto = ulrProduto;
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

	public StatusPedido getStatus() {
		return this.status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	
	

}
