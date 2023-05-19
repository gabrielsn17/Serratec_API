package br.com.serratec.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.api.domain.Produto;
import br.com.serratec.api.repository.RepositoryProduto;


@Service
public class ServicesProduto {
	
	@Autowired 
	private RepositoryProduto repositoryProduto; 
	
	//Método para listar todos os produtos em ordem crescente referente ao Id
	public List<Produto> listarProdutos() {
		return repositoryProduto.ordemCrescente();
	}
	
	//Método para inserir um produto novo
	public Produto inserirProduto(Produto produto) {
        return repositoryProduto.save(produto);
    }
	
	//Método para listar um produto específico pelo Id
	public Produto obterProdutoPorId(Long id) {
	    Optional<Produto> produtoOptional = repositoryProduto.findById(id);
	    if (produtoOptional.isPresent()) {
	        return produtoOptional.get();
	    } else {
	        return null;
	    }
	}
	
	//Método para listar todos os produtos de um determinado tipo
	public List<Produto> listarPorTipo(String tipo) {
	    if(tipo.equals("hamburguer")) {
	    	return repositoryProduto.listarHamburguer();
	    }
	    else if(tipo.equals("pastel")) {
	    	return repositoryProduto.listarPastel();
	    }
	    else if(tipo.equals("acompanhamento")) {
	    	return repositoryProduto.listarAcompanhamento();
	    }
	    else if(tipo.equals("bebida")) {
	    	return repositoryProduto.listarBebida();
	    }
	    else if(tipo.equals("sobremesa")) {
	    	return repositoryProduto.listarSobremesa();
	    }
	    else {
	    	return null;
	    }
	}
	
	//Atualizar um produto mantendo seu Id
	public void atualizarProduto(Long id, Produto produtoAtualizado) {
	    Optional<Produto> produtoOptional = repositoryProduto.findById(id);
	    
	    if (produtoOptional.isPresent()) {
	        Produto produto = produtoOptional.get();	        	        
	        produto.setNome(produtoAtualizado.getNome());
	        produto.setDescricao(produtoAtualizado.getDescricao());
	        produto.setPreco(produtoAtualizado.getPreco());
	        produto.setTipo(produtoAtualizado.getTipo());
	        	        
	        repositoryProduto.save(produto);
	    }
	}
	
	//Deletar um produto passando o Id
	public void deletarProduto(Long id) {
		repositoryProduto.deleteById(id);
	}
	
	//Método para retornar a quantidade de produtos na loja
	public Long qntProduto() {
		return repositoryProduto.quantidadeProduto();
	}
	
	//Método de carrinho que retorna o valor da compra
	public List<Object> obterCarrinho(Long id, Integer qntd) {
	    List<Object> lista = new ArrayList<>();
	    Optional<Produto> produtoOptional = repositoryProduto.findById(id);
	    if(produtoOptional.isPresent()) {
	    	Produto produto = produtoOptional.get();
	    	double valorProduto = produto.getPreco();	    	
	    	double valorTotal = valorProduto * qntd;
	    	if(qntd == 0) {
	    		lista.add("Quantidade precisa ser maior que zero");
	    	}
	    	else {
	    		lista.add("Valor do Carrinho: " + valorTotal);
	    	}
	    }
	    else {
	    	lista.add("Produto não encontrado");
	    }
	    return lista;
	}
}
