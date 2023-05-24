package br.com.serratec.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.api.domains.Planetario;
import br.com.serratec.api.services.PlanetarioServices;

@RestController
@RequestMapping("/planetario")
public class PlanetarioController {
	
	@Autowired 
	private PlanetarioServices planetarios;
	
	//Listar todos
	@GetMapping
	public List<Planetario> listarTodos(){
		return planetarios.listarTodos();
	}
	
	//Filtrar por Id
	@GetMapping("/{id}")
	public List<Object> obterCorpoPorId(@PathVariable Long id) {
		return planetarios.obterCorpoPorId(id);
	}
	
	//Inserir corpo celeste
	@PostMapping
	public List<Object> inserirNovo(@RequestBody Planetario corpo){
		return planetarios.inserirNovo(corpo);
	}
	
	//Filtrar por tipo
	@GetMapping("/tipo/{tipo}")
	public List<Planetario> listarPorTipo(@PathVariable("tipo") String tipo){
		return planetarios.listarPorTipo(tipo);
	}
	
	//Informações adicionais
	@GetMapping("/info")
	public List<Object> quantidades(){
		return planetarios.quantidades();
	}
	
	//Atualizar corpo celeste por Id
	@PutMapping("/{id}")
	public void atualizarCorpo(@PathVariable Long id, @RequestBody Planetario corpoAtualizado) {
		planetarios.atualizarCorpo(id, corpoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCorpo(@PathVariable Long id) {
		planetarios.deletarCorpo(id);
	}
	
}
