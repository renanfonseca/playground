package br.com.renanfonseca.java_jpa_hibernate.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.renanfonseca.java_jpa_hibernate.Vo.RelatorioDeVendasVo;
import br.com.renanfonseca.java_jpa_hibernate.dao.CategoriaDao;
import br.com.renanfonseca.java_jpa_hibernate.dao.ClienteDao;
import br.com.renanfonseca.java_jpa_hibernate.dao.PedidoDao;
import br.com.renanfonseca.java_jpa_hibernate.dao.ProdutoDao;
import br.com.renanfonseca.java_jpa_hibernate.modelo.Categoria;
import br.com.renanfonseca.java_jpa_hibernate.modelo.Cliente;
import br.com.renanfonseca.java_jpa_hibernate.modelo.ItemPedido;
import br.com.renanfonseca.java_jpa_hibernate.modelo.Pedido;
import br.com.renanfonseca.java_jpa_hibernate.modelo.Produto;
import br.com.renanfonseca.java_jpa_hibernate.util.JPAUtil;

public class CadastroDePedido {

	public static void main(String[] args) {
		populaBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDao.buscarPorId(1l);

		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));

		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);

		em.getTransaction().commit();

		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("TOTAL VENDIDO: " + totalVendido);

//		List<Object[]> relatorioDeVendas = pedidoDao.relatorioDeVendas();
//		for (Object[] objects : relatorioDeVendas) {
//			System.out.println(objects[0]);
//			System.out.println(objects[1]);
//			System.out.println(objects[2]);
//		}
		
		List<RelatorioDeVendasVo> relatorioDeVendasVo = pedidoDao.relatorioDeVendasVo();
		relatorioDeVendasVo.forEach(System.out::println);

	}

	public static void populaBancoDeDados() {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		Cliente cliente = new Cliente("Renan", "123456");
		ClienteDao clienteDao = new ClienteDao(em);

		clienteDao.cadastrar(cliente);

		Produto celular = new Produto();
		celular.setNome("Xiaomi Redm");
		celular.setDescricao("Modelo de 2022");
		celular.setPreco(new BigDecimal("800"));

		Categoria celulares = new Categoria("CELULARES");
		celular.setCategoria(celulares);

		em.getTransaction().begin();

		categoriaDao.cadastrar(celulares);
		dao.cadastrar(celular);

		em.getTransaction().commit();
		em.close();
	}
}
