package br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Volante Logitech G923");
		pedido.setUlrImagem("https://m.media-amazon.com/images/I/71pJHPTyacL._AC_SL1500_.jpg");
		pedido.setUlrProduto(
				"https://www.amazon.com.br/Logitech-Feedback-TRUEFORCE-Responsivos-Acabamento/dp/B08F7DBTRX/?_encoding=UTF8&pd_rd_w=huG1G&content-id=amzn1.sym.717e1082-1b26-481d-94d5-2a1a46904215&pf_rd_p=717e1082-1b26-481d-94d5-2a1a46904215&pf_rd_r=Q1D30F87XHRGCSW97S60&pd_rd_wg=LJIqS&pd_rd_r=35bdbaab-06ce-45c4-827d-a37019ed24c3&ref_=pd_gw_ci_mcx_mr_hp_atf_m");
		pedido.setDescricao(
				"O O Logitech G923 é um volante de alto desempenho para corridas que revoluciona a experiência nos jogos para Playstation 5, Playstation 4 e PC. Reprojetado para oferecer suporte a um sistema de feedback que muda o jogo, o G923 apresenta o TRUEFORCE, force feedback de última geração que usa as físicas de jogo para oferecer maior fidelidade e realismo. Sinta os pistões bombeando, o cascalho sendo esmagado e cada mudança de marcha, derrapadas e curvas fechadas como nunca antes. Um pedal de freio progressivo recria um sistema de freio sensível à pressão, enquanto uma embreagem dupla programável simula uma assistência real à arrancada de carros de corrida em jogos suportados. O design simplificado apresenta controles integrados ao volante para melhor desempenho, com um seletor de 24 pontos, incluindo controles completos de console e o clássico display de RPM em LED para jogos compatíveis");

		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}

}
