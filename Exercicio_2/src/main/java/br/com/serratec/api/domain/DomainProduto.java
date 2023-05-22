package br.com.serratec.api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="produtos")
public class DomainProduto {
	
	//Mapeamento dos atributos da tabela produto;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	@Column(name = "id")
	private Long id;
		
	@Column(name = "nome", nullable = false)
	private String nome;
		
	@Column(name = "preco", nullable = false)
	private Double preco;
		
	@Column(name = "codigo", nullable = false)
	private String codigo;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public DomainProduto(Long id, String nome, Double preco, String codigo) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
	}

	public DomainProduto() {		
	}
		
}
