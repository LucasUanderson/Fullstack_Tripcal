package com.api.tripcallv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.api.tripcallv.model.ClienteModel;
import com.api.tripcallv.repository.ClienteRepository;

@Controller
@RequestMapping("/sistema/conta")
public class ClienteCadastroController {
	
	@Autowired
    private ClienteRepository clienteRepository;
    
    
	@RequestMapping(value = {"/novo"}, method = RequestMethod.GET)
	public ModelAndView formulario() {
		ModelAndView modelAndView = new ModelAndView();
		ClienteModel conta = new ClienteModel ();
		modelAndView.setViewName("formulario.html");
		modelAndView.addObject("registroAtual", conta);
		return modelAndView;
	}
	
	@RequestMapping(value = {"/salvar"}, method = RequestMethod.POST)
	public ModelAndView salvarCadastro(ClienteModel conta) {
		ModelAndView modelAndView = new ModelAndView();
		
		try {
			clienteRepository.save(conta);
			 modelAndView.setViewName("index.html");
		}catch(Exception ex) {
			modelAndView.setViewName("formulario.html");	
		}
		return modelAndView;
		
	}
	
	@RequestMapping(value = {"/excluir/{id}"}, method = RequestMethod.GET)
	public ModelAndView excluirCadastro(@PathVariable("id")Long id) {
		ModelAndView modelAndView = new ModelAndView();
		ClienteModel conta = clienteRepository.findById(id).get();
		clienteRepository.delete(conta);
		modelAndView.setViewName("");
		modelAndView.addObject("",conta);
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = {"/editar/{id}"}, method = RequestMethod.GET)
	public ModelAndView alterarCadastro(@PathVariable("id")Long id) {
		ModelAndView modelAndView = new ModelAndView();
		ClienteModel conta = clienteRepository.findById(id).get();
		modelAndView.setViewName("");
		modelAndView.addObject("",conta);
		return modelAndView;
	
	}
	
	/*@RequestMapping(value = {"/","lista"}, method = RequestMethod.GET)
	public  ModelAndView listagem() {
		List<ClienteModel> listaContas= (List<ClienteModel>)clienteRepository.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.html");
		modelAndView.addObject("registroAtual", listaContas);
		return modelAndView;
	}*/
}


