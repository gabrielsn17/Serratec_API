package br.com.serratec.api.controller;

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

import br.com.serratec.api.domain.DomainProduto;
import br.com.serratec.api.services.ServicesProduto;



@RestController
@RequestMapping("/produtos")
public class ControllerProduto {
	
	@Autowired
	private ServicesProduto services;
	
	
	@GetMapping("/{codigo}")
	public DomainProduto obterPorCodigo(@PathVariable String codigo) {
		return services.obterPorCodigo(codigo);
	}
	
	//Adicionar um produto novo
		@PostMapping
	    public DomainProduto inserirProduto(@RequestBody DomainProduto produto) {
	        return services.inserirProduto(produto);
	    }
	
		
	//Listar todos
	@GetMapping
	public List<DomainProduto> listarProdutos(){
		return services.listarProdutos();
	}	
	
	//Atualizar um produto
	@PutMapping("/{id}")
	public void atualizarProduto(@PathVariable Long id, @RequestBody DomainProduto produtoAtualizado) {
	    services.atualizarProduto(id, produtoAtualizado);
	}
	
	@GetMapping("/{id}")
	public DomainProduto listarProdutoPorId(@PathVariable Long id) {
		return services.obterProdutoPorId(id);
	}
	
	//Deletar um produto
		@DeleteMapping("/{id}")
	    public void deletarProduto(@PathVariable Long id) {
			services.deletarProduto(id);
		}
}
