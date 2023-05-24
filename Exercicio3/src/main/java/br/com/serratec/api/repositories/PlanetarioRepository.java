package br.com.serratec.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.serratec.api.domains.Planetario;

@Repository
public interface PlanetarioRepository extends JpaRepository<Planetario, Long>{
	
	boolean existsByNome(String nome);
	
	@Query("select p from Planetario p where p.tipo = 'Planeta Terrestre/Rochoso'")
	public List<Planetario> planetas();
	
	@Query("select p from Planetario p where p.tipo = 'Planeta Gasoso/Joviano'")
	public List<Planetario> planetasGJ();
	
	@Query("select p from Planetario p where p.tipo = 'Planeta Gasoso/Neptuniano'")
	public List<Planetario> planetasGN();
	
	@Query("select p from Planetario p where p.tipo = 'Planeta anão, Terrestre/Rochoso'")
	public List<Planetario> planetasAnoes();
	
	@Query("select p from Planetario p where p.tipo = 'Estrela anã amarela'")
	public List<Planetario> estrela();
	
	@Query("select count(p.id) from Planetario p")
    Long quantidadeCorposCelestes();
	
	@Query("select count(p) from Planetario p where p.tipo = 'Planeta anão, Terrestre/Rochoso'")
    Long quantidadePlanetaAnao();
	
	@Query("select count(p) from Planetario p where p.tipo = 'Estrela anã amarela'")
    Long quantidadeEstrela();
	
}
