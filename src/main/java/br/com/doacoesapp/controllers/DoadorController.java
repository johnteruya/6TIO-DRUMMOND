package br.com.doacoesapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.doacoesapp.models.Doacao;
import br.com.doacoesapp.models.Doador;
import br.com.doacoesapp.repository.DoacaoRepository;
import br.com.doacoesapp.repository.DoadorRepository;

@Controller
public class DoadorController {

	
	//IMPORTANDO REPOSITÓRIOS
	@Autowired
	private DoadorRepository er;
	
	@Autowired
	private DoacaoRepository cr;
	
	
	//MÉTODOS DE INCLUSÕES
	@RequestMapping(value="/cadastrarDoador", method=RequestMethod.GET)
	public String form(){
		return "doador/formDoador";
	}
	
	@RequestMapping(value="/cadastrarDoador", method=RequestMethod.POST)
	public String form(@Valid Doador doador, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarDoador";
		}
		
		er.save(doador);
		attributes.addFlashAttribute("mensagem", "Doador cadastrado com sucesso!");
		return "redirect:/cadastrarDoador";
	}
	
	
	//MÉTODOS DE LISTAGEM
	@RequestMapping("/Doadores")
	public ModelAndView listaDoadores(){
		ModelAndView mv = new ModelAndView("listaDoadores");
		Iterable<Doador> doadores = er.findAll();
		mv.addObject("doadores", doadores);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesDoador(@PathVariable("codigo") long codigo){
		Doador doador = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("doador/detalhesDoador");
		mv.addObject("doador", doador);
		
		Iterable<Doacao> doacoes = cr.findByDoador(doador);
		mv.addObject("doacoes", doacoes);
		
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesDoadorPost(@PathVariable("codigo") long codigo, @Valid Doacao doacao,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Doador doador = er.findByCodigo(codigo);
		doacao.setDoador(doador);
		cr.save(doacao);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	
	//METODOS PARA DELEÇÃO
	@RequestMapping("/deletarDoador")
	public String deletarDoador(long codigo){
		Doador doador = er.findByCodigo(codigo);
		er.delete(doador);
		return "redirect:/doadores";
	}
	
	@RequestMapping("/deletarDoacao")
	public String deletarDoacao(String rg){
		Doacao doacao = cr.findByRg(rg);
		cr.delete(doacao);
		
		Doador doador = doacao.getDoador();
		long codigoLong = doador.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}
}	
