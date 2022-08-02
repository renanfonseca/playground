package br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model.Pedido;
import br.com.renanfonseca.mvc.spring_mvc_thymeleaf_bootstrap.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);

}
