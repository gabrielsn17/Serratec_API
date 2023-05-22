package br.com.serratec.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.serratec.api.domain.DomainProduto;

@Repository
public interface RepositoryProdudos extends JpaRepository<DomainProduto, Long> {
	
	@Query
	Optional<DomainProduto> findByCodigo(String codigo);

	
}
