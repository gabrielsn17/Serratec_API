package br.com.serratec.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.serratec.api.domain.Produto;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto, Long>{
	
	//Repositório para as Queries
	
	//Abaixo, consultas para listar os produtos por tipo
	
	@Query("select p from Produto p where p.tipo = 'Hambúrguer'")
	List<Produto> listarHamburguer();
	
	@Query("select p from Produto p where p.tipo = 'Pastel'")
	List<Produto> listarPastel();
	
	@Query("select p from Produto p where p.tipo = 'Acompanhamento'")
	List<Produto> listarAcompanhamento();
	
	@Query("select p from Produto p where p.tipo = 'Bebida'")
	List<Produto> listarBebida();
	
	@Query("select p from Produto p where p.tipo = 'Sobremesa'")
	List<Produto> listarSobremesa();
	
	//Ordenar todos os produtos por ordem crescente em relação ao Id
	
	@Query("select p from Produto p order by p.id asc")
    List<Produto> ordemCrescente();
	
	//Contagem de todos os produtos da loja
	
	@Query("select count(p.id) from Produto p")
    Long quantidadeProduto();	
	
	
}
