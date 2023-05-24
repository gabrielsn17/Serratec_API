package br.com.serratec.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.api.domains.Planetario;
import br.com.serratec.api.repositories.PlanetarioRepository;

@Service
public class PlanetarioServices {
	
	@Autowired
	private PlanetarioRepository planetario;
	
	//Listar todos
	public List<Planetario> listarTodos(){
		return planetario.findAll();
	}
	
	//Método para inserir um corpo novo novo
		public List<Object> inserirNovo(Planetario corpo) {
	        String nome = corpo.getNome();
	        
	        List<Object> lista = new ArrayList<>();
	        
	        boolean existe = verificarExistencia(nome);
	        if(existe) {
	        	lista.add("Objeto existente");
	        }
	        else {
	        	planetario.save(corpo);
	        	lista.add("Objeto criado");
	        }
	        return lista;
	    }
	
	//verificar se um objeto existe
	public boolean verificarExistencia(String nome) {
		return planetario.existsByNome(nome);
	}
	
	//listar por id
	public List<Object> obterCorpoPorId(Long id) {
	    List<Object> lista = new ArrayList<>();
	    Optional<Planetario> corpoOptional = planetario.findById(id);
	    if(corpoOptional.isPresent()) {
	    	Planetario planetario = corpoOptional.get();
	    	String nome = planetario.getNome();
	    	Double diametro_equatorial = planetario.getDiametro_equatorial();
	    	Double inclinacao = planetario.getInclinacao();
	    	Double gravidade = planetario.getGravidade();
	    	String tipo = planetario.getTipo();
	    	Boolean possui_lua = planetario.getPossui_lua();
	    	Double duracao_dia = planetario.getDuracao_dia();
	    	Integer qnt_lua = planetario.getQuantidade_luas();
	    	
	    	lista.add("Nome: "+nome);
	    	lista.add("Diâmetro equatorial: " + diametro_equatorial + " Km");
	    	lista.add("Inclinação: " + inclinacao + "°");
	    	lista.add("Gravidade: " + gravidade + " m/s²");
	    	lista.add("Tipo: " + tipo);
	    	if(possui_lua){
	    		lista.add("Possui lua: Sim");
	    	}
	    	else {
	    		lista.add("Possui lua: Não");
	    	}
	    	lista.add("Duração do dia: " + duracao_dia + " horas terrestres");
	    	lista.add("Quantidade de luas: " + qnt_lua);
	    }
	    else {
	    	lista.add("Id não encontrado");
	    }
	    return lista;
	}
	
	//listar por tipo
	public List<Planetario> listarPorTipo(String tipo) {
	    if(tipo.equalsIgnoreCase("estrela")) {
	    	return planetario.estrela();
	    }
	    else if(tipo.equals("planeta")) {
	    	return planetario.planetas();
	    }
	    else if(tipo.equals("gasoso")) {
	    	List<Planetario> lista = new ArrayList<Planetario>();
	    	lista.addAll(planetario.planetasGJ());
	    	lista.addAll(planetario.planetasGN());
	    	return lista;
	    }	
	    else if(tipo.equals("anao")) {
	    	return planetario.planetasAnoes();
	    }	    
	    else {
	    	return null;
	    }
	}
	
	//lista de informações adicionais
	public List<Object> quantidades(){
		List<Object> lista = new ArrayList<Object>();
		Long qntd = planetario.quantidadeCorposCelestes();
		Long qntdAnoes = planetario.quantidadePlanetaAnao();
		Long qntdPlanetas = planetario.quantidadeCorposCelestes() - (planetario.quantidadePlanetaAnao() + planetario.quantidadeEstrela());
		Long qntdEstrelas = planetario.quantidadeEstrela();
		
		lista.add("Quantidade de Estrelas: " + qntdEstrelas);
		lista.add("Quantidade de Planetas: " + qntdPlanetas);
		lista.add("Quantidade de Planetas Anões: " + qntdAnoes);
		lista.add("Quantidade de Corpos Celestes Registrados: " + qntd);
		
		return lista;
	}
	
	//atualizar corpo celeste
	public void atualizarCorpo(Long id, Planetario corpoAtualizado) {
	    Optional<Planetario> planetarioOptional = planetario.findById(id);
	    
	    if (planetarioOptional.isPresent()) {
	    	Planetario corpo = planetarioOptional.get();	        	        
	    	corpo.setNome(corpoAtualizado.getNome());
	    	corpo.setDiametro_equatorial(corpoAtualizado.getDiametro_equatorial());
	    	corpo.setInclinacao(corpoAtualizado.getInclinacao());
	    	corpo.setGravidade(corpoAtualizado.getGravidade());
	    	corpo.setTipo(corpoAtualizado.getTipo());
	    	corpo.setPossui_lua(corpoAtualizado.getPossui_lua());
	    	corpo.setDuracao_dia(corpoAtualizado.getDuracao_dia());
	    	corpo.setQuantidade_luas(corpoAtualizado.getQuantidade_luas());
	        	        
	    	planetario.save(corpo);
	    }
	}
	
	//Deletar
	public void deletarCorpo(Long id) {
		planetario.deleteById(id);
	}
	
}
