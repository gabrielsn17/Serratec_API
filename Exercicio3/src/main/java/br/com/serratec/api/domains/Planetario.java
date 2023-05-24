package br.com.serratec.api.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "corposcelestes")
public class Planetario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "diametro_equatorial")
	private Double diametro_equatorial;
	
	@Column(name = "inclinacao")
	private Double inclinacao;
	
	@Column(name = "gravidade")
	private Double gravidade;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "possui_lua")
	private Boolean possui_lua;
	
	@Column(name = "duracao_dia")
	private Double duracao_dia;
	
	@Column(name = "quantidade_luas")
	private Integer quantidade_luas;

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

	public Double getDiametro_equatorial() {
		return diametro_equatorial;
	}

	public void setDiametro_equatorial(Double diametro_equatorial) {
		this.diametro_equatorial = diametro_equatorial;
	}

	public Double getInclinacao() {
		return inclinacao;
	}

	public void setInclinacao(Double inclinacao) {
		this.inclinacao = inclinacao;
	}

	public Double getGravidade() {
		return gravidade;
	}

	public void setGravidade(Double gravidade) {
		this.gravidade = gravidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Boolean getPossui_lua() {
		return possui_lua;
	}

	public void setPossui_lua(Boolean possui_lua) {
		this.possui_lua = possui_lua;
	}

	public Double getDuracao_dia() {
		return duracao_dia;
	}                              

	public void setDuracao_dia(Double duracao_dia) {
		this.duracao_dia = duracao_dia;
	}
	
	public Integer getQuantidade_luas() {
		return quantidade_luas;
	}                              

	public void setQuantidade_luas(Integer quantidade_luas) {
		this.quantidade_luas = quantidade_luas;
	}

	public Planetario(Long id, String nome, Double diametro_equatorial, Double inclinacao, Double gravidade,
			String tipo, Boolean possui_lua, Double duracao_dia, Integer quantidade_luas) {
		super();
		this.id = id;
		this.nome = nome;
		this.diametro_equatorial = diametro_equatorial;
		this.inclinacao = inclinacao;
		this.gravidade = gravidade;
		this.tipo = tipo;
		this.possui_lua = possui_lua;
		this.duracao_dia = duracao_dia;
		this.quantidade_luas = quantidade_luas;
	}

	public Planetario() {
	}	
}
