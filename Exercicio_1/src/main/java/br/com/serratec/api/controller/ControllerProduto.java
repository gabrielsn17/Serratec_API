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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.serratec.api.domain.Produto;
import br.com.serratec.api.services.ServicesProduto;

@RestController
@RequestMapping("/produtos")
public class ControllerProduto {

	@Autowired
	private ServicesProduto servicesProduto;
	
	//Listar todos por Id (Ordem Crescente)
	@GetMapping
	public List<Produto> listarProdutos(){
		return servicesProduto.listarProdutos();
	}
	
	//Obter produto por id
	@GetMapping("/{id}")
	public Produto listarProdutoPorId(@PathVariable Long id) {
	    return servicesProduto.obterProdutoPorId(id);
	}
	
	//Listar todos por tipo
	@GetMapping("/tipo/{tipo}")
    public List<Produto> listarPorTipo(@PathVariable("tipo") String tipo) {
        return servicesProduto.listarPorTipo(tipo);
    }
	
	//Adicionar um produto novo
	@PostMapping
    public Produto inserirProduto(@RequestBody Produto produto) {
        return servicesProduto.inserirProduto(produto);
    }
	
	//Atualizar um produto
	@PutMapping("/{id}")
    public void atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        servicesProduto.atualizarProduto(id, produtoAtualizado);
    }
	
	//Deletar um produto
	@DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
		servicesProduto.deletarProduto(id);
	}
	
	//Contagem de produtos
	@GetMapping("/contagem")
	public Long qntProduto() {
		return servicesProduto.qntProduto();
	}
	
	//Retornar valor da compra
	@GetMapping("/carrinho")
	public List<Object> obterCarrinho(@RequestParam("id") Long id, @RequestParam("qntd") Integer qntd){
		return servicesProduto.obterCarrinho(id, qntd);
	}

}
