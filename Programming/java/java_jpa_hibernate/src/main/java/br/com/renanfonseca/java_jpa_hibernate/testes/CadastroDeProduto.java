package br.com.renanfonseca.java_jpa_hibernate.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.renanfonseca.java_jpa_hibernate.dao.CategoriaDao;
import br.com.renanfonseca.java_jpa_hibernate.dao.ProdutoDao;
import br.com.renanfonseca.java_jpa_hibernate.modelo.Categoria;
import br.com.renanfonseca.java_jpa_hibernate.modelo.Produto;
import br.com.renanfonseca.java_jpa_hibernate.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarPorNome("Xiaomi Redm");
		todos.forEach(p2 -> System.out.println(p.getNome()));

	}

	private static void cadastrarProduto() {
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

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
