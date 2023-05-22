package br.com.serratec.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.serratec.api.domain.DomainProduto;
import br.com.serratec.api.repository.RepositoryProdudos;

@Service
public class ServicesProduto {
	

	@Autowired 
	private RepositoryProdudos repository; 
	
	//Método para listar todos os produtos 
		public List<DomainProduto> listarProdutos() {
			return repository.findAll();
		}
	
	//Método para inserir um produto novo
	public DomainProduto inserirProduto(DomainProduto produto) {
		return repository.save(produto);
	}
	
	//Método para listar um produto específico pelo Id
		public DomainProduto obterProdutoPorId(Long id) {
		    Optional<DomainProduto> produtoOptional = repository.findById(id);
		    if (produtoOptional.isPresent()) {
		        return produtoOptional.get();
		    } else {
		        return null;
		    }
		}
	
	//Método para listar um produto específico pelo código
	public DomainProduto obterPorCodigo(String codigo) {		
		Optional<DomainProduto> produtoOptional = repository.findByCodigo(codigo);
	    if (produtoOptional.isPresent()) {
	        return produtoOptional.get();
	    } else {
	        return null;
	    }
		
	}
		
	//Atualizar um produto 
		public void atualizarProduto(Long id, DomainProduto produtoAtualizado) {
		    Optional<DomainProduto> produtoOptional = repository.findById(id);
		    
		    if (produtoOptional.isPresent()) {
		    	DomainProduto produto = produtoOptional.get();	        	        
		        produto.setNome(produtoAtualizado.getNome());
		        produto.setCodigo(produtoAtualizado.getCodigo());
		        produto.setPreco(produtoAtualizado.getPreco());
		        
		       	repository.save(produto);
		    }
		}
		
		
	//Deletar um produto passando o Id
	public void deletarProduto(Long id) {
		repository.deleteById(id);
	}
}
