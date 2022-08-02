package br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.dto.RequisicaoNovoPedido;
import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model.Pedido;
import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		Pedido pedido = requisicaoNovoPedido.toPedido();
		
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}

}
