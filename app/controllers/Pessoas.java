package controllers;

import java.util.List;

import models.Pessoa;
import play.mvc.Controller;

public class Pessoas extends Controller {
	
	public static void form() {
		render();
		
	}
	
	public static void salvar(Pessoa p) {
		p.save();
		form();
		
	}
	
	public static void listar() {
		String busca = params.get("busca");
		
		List<Pessoa> lista = Pessoa.findAll();
		if (busca == null || busca.isEmpty()) {
			lista = Pessoa.findAll();			
		} else {
			lista = Pessoa.find("lower(nome) like ?1 or lower(email) like ?1",
					"%"+ busca.toLowerCase() +"%").fetch();
		}
		render(lista, busca);
		
	}
	
	public static void editar(long id) {
		Pessoa p = Pessoa.findById(id);
		renderTemplate("Pessoas/form.html", p);
	}
	
	public static void deletar(long id) {
		Pessoa p = Pessoa.findById(id);
		p.delete();
		
		listar();
	}

}
