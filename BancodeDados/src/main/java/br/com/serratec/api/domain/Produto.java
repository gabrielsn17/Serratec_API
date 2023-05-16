package br.com.serratec.api.domain;

import java.math.BigDecimal;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
@Table(name="produto")

public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="pro_cd_id_produto")
	private Long id;
	
	@Column(name="pro_tx_nome", nullable=false, length = 40)
	private String nome;
	
	@Column(name="pro_date_data_de_fabricacao")
	@Temporal(TemporalType.DATE)
	private Date dataFabricacao;
	
	@Column(name="pro_int_quantidade_em_estoque")
	private Integer qtdEstoque;
	
	@Column(name="pro_nm_valor_unitario")
	private Double valor;
	
	@Column(name="pro_tx_desc_produto", nullable=false)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Produto(Long id, String nome, Date dataFabricacao, Integer qtdEstoque, Double valor,
			String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataFabricacao = dataFabricacao;
		this.qtdEstoque = qtdEstoque;
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public Produto() {}
		
}
