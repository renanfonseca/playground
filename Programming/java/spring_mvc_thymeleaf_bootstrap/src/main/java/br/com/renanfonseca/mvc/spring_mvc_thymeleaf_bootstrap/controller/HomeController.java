package br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model.Pedido;
import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model.StatusPedido;
import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model) {

		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
	
	@GetMapping("/aguardando")
	public String aguardando(Model model) {

		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
	
	@GetMapping("/aprovado")
	public String aprovado(Model model) {

		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.APROVADO);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
	
	@GetMapping("/entregue")
	public String entregue(Model model) {

		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}

}
