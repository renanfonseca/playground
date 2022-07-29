package br.com.renanfonseca.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.renanfonseca.spring.data.orm.Cargo;
import br.com.renanfonseca.spring.data.orm.CargoProjecao;

@Repository
public interface CargoRepository extends PagingAndSortingRepository<Cargo, Integer>, JpaSpecificationExecutor<Cargo> {

	@Query(value = "SELECT c.descricao FROM cargos c", nativeQuery = true)
	List<CargoProjecao> findCargoDescricao();

}
