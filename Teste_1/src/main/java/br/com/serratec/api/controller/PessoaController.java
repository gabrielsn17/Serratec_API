package br.com.serratec.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.api.domain.Pessoa;

@RestController
@RequestMapping("/pessoa")


public class PessoaController {
	
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public PessoaController() {
		pessoas.add(new Pessoa(1l, "Gabriel", 22));
		pessoas.add(new Pessoa(2l, "Joaquim", 27));
		pessoas.add(new Pessoa(3l, "Clodofilda", 19));
		pessoas.add(new Pessoa(4l, "Zamira", 31));
	}
	
	@GetMapping
	public List<Pessoa> listarTodos(){
		return pessoas;
	}
	
	@GetMapping("/{id}")
	public Pessoa busca(@PathVariable Long id) {
		for(int i = 0; i < pessoas.size(); i++) {
			Pessoa pessoa = pessoas.get(i);
			if(pessoa.getId().equals(id)) {
				return pessoa;
			}
		}
		return null;
	}
	
	@PostMapping
	public Pessoa inserir(@RequestBody Pessoa pessoa) {
		pessoa.setId((long) (pessoas.size() + 1));
		pessoas.add(pessoa);
		return pessoa;
	}
	
	@PutMapping("/{id}")
	public Pessoa atualizar(@RequestBody Pessoa pessoa, @PathVariable Long id) {
		for(int i = 0; i < pessoas.size(); i++) {
			Pessoa pessoaLista = pessoas.get(i);
			if(pessoaLista.getId().equals(id)) {
				pessoaLista.setNome(pessoa.getNome());
				pessoaLista.setIdade(pessoa.getIdade());
				return pessoaLista;
			}
		}
		return null;		
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		for(int i = 0; i < pessoas.size(); i++) {
			Pessoa pessoaLista = pessoas.get(i);
			if(pessoaLista.getId().equals(id)) {
				pessoas.remove(i);
				return;
			}
		}
	}
	
	//@PathVariable
	@GetMapping("/{num1}/{num2}")
	public List<Object> calcular(@PathVariable int num1, @PathVariable int num2) {
		List<Object> lista = new ArrayList<>();
		int soma = num1 + num2;
		int sub = num1 - num2;
		int mult = num1 * num2;
		int div = 0;
		
		lista.add("Soma = "+soma);
		//lista.add(soma);
		lista.add("Subtração = "+sub);
		//lista.add(sub);
		lista.add("Multiplicação = "+mult);
		//lista.add(mult);
				
		try {
	        if (num2 != 0) {
	            div = num1 / num2;
	            lista.add("Divisão = "+div);
	            //lista.add(div);
	        } else {
	            throw new IllegalArgumentException("Não pode dividir por zero!");
	        }
	    } catch (IllegalArgumentException e) {
	        lista.add("Erro: " + e.getMessage());
	    }
				
		return lista;
	}
	
	//@RequestBody
	@PostMapping("/calculadora")
	public List<Object> calculadora(@RequestBody Map<String, Integer> request) {
	    List<Object> lista = new ArrayList<>();
	    int num1 = request.get("num1");
	    int num2 = request.get("num2");
	
	    int soma = num1 + num2;
	    int sub = num1 - num2;
	    int mult = num1 * num2;
	    int div = 0;

	    lista.add("Soma = " + soma);
	    lista.add("Subtração = " + sub);
	    lista.add("Multiplicação = " + mult);

	    try {
	        if (num2 != 0) {
	            div = num1/ num2;
	            lista.add("Divisão = " + div);
	        } else {
	            throw new IllegalArgumentException("Não pode dividir por zero!");
	        }
	    } catch (IllegalArgumentException e) {
	        lista.add("Erro: " + e.getMessage());
	    }

	    return lista;
	}
	
	//@RequestParam
	@GetMapping("/calculadora")
	public List<Object> calculadora(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
	    List<Object> lista = new ArrayList<>();
	    int soma = num1 + num2;
	    int sub = num1 - num2;
	    int mult = num1 * num2;
	    int div = 0;

	    lista.add("Soma = " + soma);
	    lista.add("Subtração = " + sub);
	    lista.add("Multiplicação = " + mult);

	    try {
	        if (num2 != 0) {
	            div = num1 / num2;
	            lista.add("Divisão = " + div);
	        } else {
	            throw new IllegalArgumentException("Não pode dividir por zero!");
	        }
	    } catch (IllegalArgumentException e) {
	        lista.add("Erro: " + e.getMessage());
	    }

	    return lista;
	}
}
