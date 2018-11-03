package br.com.doacoesapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

	//TESTE-VIEWS
	@RequestMapping("/listaDoadores2")
	public String listaDoadores2(){
		return "listaDoadores2";
	}
	
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
			attributes.addFlashAttribute("mensagem", "Verifique os Campos!");
			return "redirect:/cadastrarDoador";
		}
		
		er.save(doador);
		attributes.addFlashAttribute("mensagem", "Cadastro Realizado com Sucesso!");
		return "redirect:/cadastrarDoador";
	}
	
	
	//MÉTODOS DE LISTAGEM
	@RequestMapping("/doadores")
	public ModelAndView listaDoadores(){
		ModelAndView mv = new ModelAndView("listaDoadores");
		Iterable<Doador> doadores = er.findAll();
		mv.addObject("doadores", doadores);
		return mv;
	}
	
	@RequestMapping(value="/{idDoador}", method=RequestMethod.GET)
	public ModelAndView detalhesDoador(@PathVariable("idDoador") long idDoador){
		Doador doador = er.findByIdDoador(idDoador);
		ModelAndView mv = new ModelAndView("doador/detalhesDoador");
		mv.addObject("doador", doador);
		
		Iterable<Doacao> doacoes = cr.findByDoador(doador);
		mv.addObject("doacoes", doacoes);
		
		return mv;
	}
	
	@RequestMapping(value="/{idDoador}", method=RequestMethod.POST)
	public String detalhesDoadorPost(@PathVariable("idDoador") long idDoador, @Valid Doacao doacao,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os Campos!");
			return "redirect:/{idDoador}";
		}
		Doador doador = er.findByIdDoador(idDoador);
		doacao.setDoador(doador);
		cr.save(doacao);
		attributes.addFlashAttribute("mensagem", "Cadastro Realizado com Sucesso!");
		return "redirect:/{idDoador}";
	}
	
	
	//METODOS PARA DELEÇÃO
	@RequestMapping("/deletarDoador")
	public String deletarDoador(long idDoador){
		Doador doador = er.findByIdDoador(idDoador);
		er.delete(doador);
		return "redirect:/doadores";
	}
	
	@RequestMapping("/deletarDoacao")
	public String deletarDoacao(long idDoacao){
		Doacao doacao = cr.findByIdDoacao(idDoacao);
		cr.delete(doacao);
		
		Doador doador = doacao.getDoador();
		long idDoadorLong = doador.getIdDoador();
		String idDoador = "" + idDoadorLong;
		return "redirect:/" + idDoador;
	}
}	
