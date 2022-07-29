package br.com.renanfonseca.spring.data.service;

import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.renanfonseca.spring.data.orm.Cargo;
import br.com.renanfonseca.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private Boolean system = true;
	private final CargoRepository cargoRepository;

	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void init(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();
			switch (action) {
			case 1: {
				salvar(scanner);
				break;
			}
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar(scanner);
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
		salvar(scanner);
	}

	private void salvar(Scanner scanner) {
		System.out.println("Descrição do Cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Descrição");
		String descricao = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado");
	}
	
	private void visualizar(Scanner scanner) {
		
		System.out.println("Qual pagina você quer visualizar?");
		Integer page = scanner.nextInt();
		
		Pageable pageable = PageRequest.of(page, 2, Sort.by(Sort.Direction.ASC, "descricao"));
		
		Page<Cargo> cargos = cargoRepository.findAll(pageable);
		System.out.println(cargos);
		System.out.println("Pagina atual " + cargos.getNumber());
		System.out.println("Total elemento " + cargos.getTotalElements());
		
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
	}

}
